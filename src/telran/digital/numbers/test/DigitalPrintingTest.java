package telran.digital.numbers.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static telran.digital.numbers.DigitalNumbersPrinting.*;

public class DigitalPrintingTest {
	@Test
	@Disabled
	void lineTest() {
		System.out.println(line(30, 30));
	}
	
	@Test
	@Disabled
	void verticalLineTest() {
		displayStrings(rightVerticalLine(30, 5));
	}
	
	@Test
	@Disabled
	void twoVerticalLinesTest() {
		displayStrings(twoVerticalLines(30, 10, 5));
	}
	
	@Test
	@Disabled
	void zeroTest() {
		displayStrings(zero(30, 5, 5));
	}
	
	@Test
	@Disabled
	void oneTest() {
		displayStrings(one(30, 5, 5));
	}
	
	@Test
	@Disabled
	void twoTest() {
		displayStrings(two(30, 5, 5));
	}
	
	@Test
	@Disabled
	void threeTest() {
		displayStrings(three(30, 5, 5));
	}
	
	@Test
	@Disabled
	void fourTest() {
		displayStrings(four(30, 5, 6));
	}
	
	@Test
	@Disabled
	void fiveTest() {
		displayStrings(five(30, 5, 5));
	}
	
	@Test
	@Disabled
	void sixTest() {
		displayStrings(six(30, 5, 6));
	}
	
	@Test
	@Disabled
	void sevenTest() {
		displayStrings(seven(30, 5, 5));
	}
	
	@Test
	@Disabled
	void eightTest() {
		displayStrings(eight(30, 5, 6));
	}
	
	@Test
	@Disabled
	void nineTest() {
		displayStrings(nine(30, 5, 5));
	}
	
	@Test
	void displayDigitalNumberTest() {
		displayDigitalNumber(1234567890, 0, 5, 5);
		displayDigitalNumber(1234567890, 20, 6, 6);
	}
}
