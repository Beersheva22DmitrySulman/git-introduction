import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PrimitivesTest {

	@Test
	@Disabled
	void test() {
//		fail("Not yet implemented");
		int a = 10;
		assertEquals(10.0, a);
	}

	@Test
	@Disabled
	void operatorTest() {
		int a = 10;
		assertEquals(13, a + 3);
		assertEquals(1, a % 3);
		int number = 923;
		assertEquals(3, getThirdDigit(number));
		assertEquals(2, getSecondDigit(number));
		assertEquals(9, getFirstDigit(number));
	}

	private Integer getFirstDigit(int number) {
		return number / 100;
	}

	private Integer getSecondDigit(int number) {
		return number / 10 % 10;
	}

	private Integer getThirdDigit(int number) {
		return number % 10;
	}

	@Test
	void getBitValueTest() {
		long number = 0x3ab7f5;
		assertEquals(1, BitOperations.getBitValue(number, 4));
		assertEquals(0, BitOperations.getBitValue(number, 11));
		assertEquals(0, BitOperations.getBitValue(number, 1));
		assertEquals(1, BitOperations.getBitValue(number, 2));
		assertEquals(-1, BitOperations.getBitValue(number, 100));

		number = -1;
		assertEquals(1, BitOperations.getBitValue(number, 63));
		number = BitOperations.invertBitValue(number, 63);
		assertEquals(0, BitOperations.getBitValue(number, 63));
	}
	
	@Test
	void setBitValueTest() {
		long number = 0x3ab7f5;
		assertEquals(0x3ab7e5, BitOperations.setBitValue(number, 4, false));
		assertEquals(0x3ab7f5, BitOperations.setBitValue(number, 4, true));
	}
	
	@Test
	void invertBitValueTest() {
		long number = 0x3ab7f5;
		assertEquals(0x3ab7e5, BitOperations.invertBitValue(number, 4));
		assertEquals(0x3ab7f4, BitOperations.invertBitValue(number, 0));
	}
	
	@Test
	void leadingZerosTest() {
		long number = 0xFF000000;
		assertEquals(0, BitOperations.leadingZeros(number));
		number = 4;
		assertEquals(61, BitOperations.leadingZeros(number));
		number = 12;
		assertEquals(60, BitOperations.leadingZeros(number));
		number = 13;
		assertEquals(60, BitOperations.leadingZeros(number));
		number = 1;
		assertEquals(63, BitOperations.leadingZeros(number));
		number = 0;
		assertEquals(64, BitOperations.leadingZeros(number));
	}
	
	@Test
	void onesInNumber() {
		long number = 8;
		assertEquals(1, BitOperations.onesInNumber(number));
		number = 4;
		assertEquals(1, BitOperations.onesInNumber(number));
		number = 12;
		assertEquals(2, BitOperations.onesInNumber(number));
		number = 13;
		assertEquals(3, BitOperations.onesInNumber(number));
		number = 1;
		assertEquals(1, BitOperations.onesInNumber(number));
		number = 7;
		assertEquals(3, BitOperations.onesInNumber(number));
		number = 0;
		assertEquals(0, BitOperations.onesInNumber(number));
	}
}
