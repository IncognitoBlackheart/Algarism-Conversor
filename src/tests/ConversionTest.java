package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import conversion.Conversor;
import conversion.InvalidNumberException;

public class ConversionTest {
	
	private Conversor conversor;
	
	@Before
	public void ConversorTest() {
		conversor = new Conversor();
	}
	
	@Test
	public void RomanNumberTest1() throws InvalidNumberException {
		conversor.setRoman("III");
		Assert.assertEquals(conversor.RomanNumber(), 3);
	}
	
	@Test
	public void RomanNumberTest2() throws InvalidNumberException {
		conversor.setRoman("VIII");
		Assert.assertEquals(conversor.RomanNumber(), 8);
	}
	
	@Test
	public void RomanNumberTest3() throws InvalidNumberException {
		conversor.setRoman("XIV");
		Assert.assertEquals(conversor.RomanNumber(), 14);
	}
	
	@Test
	public void RomanNumberTest4() throws InvalidNumberException {
		conversor.setRoman("XLVI");
		Assert.assertEquals(conversor.RomanNumber(), 46);
	}
	
	@Test
	public void RomanNumberTest5() throws InvalidNumberException {
		conversor.setRoman("MCMIII");
		Assert.assertEquals(conversor.RomanNumber(), 1903);
	}
	
	@Test
	public void RomanNumberExceptionTest() throws InvalidNumberException {
		conversor.setRoman("MIIII");
		Assert.assertEquals(conversor.RomanNumber(), new InvalidNumberException());
	}
	
	@Test
	public void NumberRomanTest1() throws InvalidNumberException {
		conversor.setNumber(3);
		Assert.assertEquals(conversor.NumberRoman(), "III");
	}
	
	@Test
	public void NumberRomanTest2() throws InvalidNumberException {
		conversor.setNumber(14);
		Assert.assertEquals(conversor.NumberRoman(), "XIV");
	}
	
	@Test
	public void NumberRomanTest3() throws InvalidNumberException {
		conversor.setNumber(22);
		Assert.assertEquals(conversor.NumberRoman(), "XXII");
	}
	
	@Test
	public void NumberRomanTest4() throws InvalidNumberException {
		conversor.setNumber(440);
		Assert.assertEquals(conversor.NumberRoman(), "CDXL");
	}
	
	@Test
	public void NumberRomanTest5() throws InvalidNumberException {
		conversor.setNumber(2920);
		Assert.assertEquals(conversor.NumberRoman(), "MMCMXX");
	}
	
	@Test
	public void NumberRomanExceptionTest() throws InvalidNumberException {
		conversor.setNumber(4000);
		Assert.assertEquals(conversor.NumberRoman(), new InvalidNumberException());
	}
}
