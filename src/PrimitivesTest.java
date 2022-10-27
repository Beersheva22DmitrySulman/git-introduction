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
	}
	
	@Test
	void setBitValueTest() {
		long number = 0x3ab7f5;
		assertEquals(0x3ab7e5, BitOperations.setBitValue(number, 4, false));
		assertEquals(0x3ab7f5, BitOperations.setBitValue(number, 4, true));
	}
	
	@Test
	void revertBitValueTest() {
		long number = 0x3ab7f5;
		assertEquals(0x3ab7e5, BitOperations.revertBitValue(number, 4));
		assertEquals(0x3ab7f4, BitOperations.revertBitValue(number, 0));
	}
}
