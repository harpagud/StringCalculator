package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.junit.Assert.fail;

public class CalculatorTest {

	@Test
	
	public void testEmptyString()
	{
		assertEquals(0, Calculator.add(""));
	}
	@Test
	public void testOneNumber()
	{
		assertEquals(1, Calculator.add("1"));
	}
	@Test
	public void testTwoNumbers()
	{
		assertEquals(3, Calculator.add("1,2"));
	}
	@Test
	public void testMultipleNumbers()
	{
		assertEquals(6, Calculator.add("1,2,3"));
	}

	@Test
    public void testNewLineDelimeter(){
         assertEquals(6, Calculator.add("1\n2,3"));
    }

    @Test
	public void testOneNegativeNumber() {
  		try{
			Calculator.add("-5,2");
			fail("did not throw an exception for -5,2");
		}
		catch(IllegalArgumentException e){
			assertEquals("Negatives not allowed: -5", e.getMessage());
		}
	}

	@Test
	public void testMultipleNegativeNumbers() {
  		try{
			Calculator.add("-5,2,-3,-1");
			fail("did not throw an exception for -5,2,-3,-1");
		}
		catch(IllegalArgumentException e){
			assertEquals("Negatives not allowed: -5,-3,-1", e.getMessage());
		}
	}

	@Test
	public void testBigNumbers(){	
			assertEquals(17, Calculator.add("1001,8,5,4"));
	}

	@Test
	public void testDifferentDelimeters()
	{
		assertEquals(3, Calculator.add("//;\n1;2"));
	}

	@Test
	public void testDifferentDelimeters2()
	{
		assertEquals(3, Calculator.add("//-'=\n1-'=2"));
	}

	@Test
	public void testDifferentDelimetersMultipleNumbers()
	{
		assertEquals(11, Calculator.add("//-'=\n1-'=2-'=5-'=3"));
	}

	@Test
	public void testDifferentDelimetersAndBigNumber()
	{
		assertEquals(8, Calculator.add("//-'=\n1-'=2-'=5-'=2005"));
	}

}

