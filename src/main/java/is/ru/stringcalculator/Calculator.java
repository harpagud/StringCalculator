package is.ru.stringcalculator;

public class Calculator {

public static int add(String text)
{
	if(text.equals(""))
	{
		return 0;
	}
	else if(text.contains("//"))
	{
		String numbers [] = differentDelimeter(text);
		return sum(numbers);
	}	
	else
	{
		if (text.contains(",") || text.contains("\n"))
		{
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
		int intNumber = toInt(number);
		if(intNumber < 0)
		{
			negatives(numbers);
		}
		if(intNumber <= 1000)
		{			
			total += intNumber;
		}
	}
	return total;
}

private static void negatives(String[] numbers)
{
	String message = "Negatives not allowed: ";
	String newNegatives = "";
	for(String number : numbers)
	{
		int intNumber = toInt(number);
		if(intNumber < 0)
		{
			if(newNegatives.equals(""))
			{
				newNegatives = newNegatives + intNumber;
			}
			else
			{
				newNegatives = newNegatives + "," + intNumber;
			}
		}
	}
	message = message + newNegatives;
	throw new IllegalArgumentException(message);
}

private static String[] differentDelimeter(String text)
{
		String[] split = text.substring(2).split("\n",2);
		String delimeter = split[0];
		String numbers = split[1];
		String[] numbersArray = numbers.split(delimeter);
		return numbersArray;
}
}