package is.ru.stringcalculator;

public class Calculator {

public static int add(String text)
{
	if(text.equals(""))
	{
		return 0;
	}
		
	else
	{
		if (text.contains(",") || text.contains("\n")){
			String numbers [] = text.split("[\n ,]");
			return sum(numbers); 
		}
		else
		{
			return 1;
		}
	}
		
}


private static int toInt(String number)
{
	return Integer.parseInt(number);
}

private static int sum(String [] numbers)
{
	int total = 0;
	for(String number : numbers)
	{
		if(toInt(number) < 0)
		{
			negatives(numbers);
		}
		total += toInt(number);
	}
	return total;
}

private static void negatives(String[] numbers)
{
	String message = "Negatives not allowed: ";
	String newNegatives = "";
	for(String number : numbers)
	{
		if(toInt(number) < 0)
		{
			if(newNegatives.equals(""))
			{
				newNegatives = newNegatives + toInt(number);
			}
			else
			{
				newNegatives = newNegatives + "," + toInt(number);
			}
		}
	}
	message = message + newNegatives;
	throw new IllegalArgumentException(message);
}
}