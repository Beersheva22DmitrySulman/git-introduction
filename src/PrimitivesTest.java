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
	@Disabled
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
	@Disabled
	void setBitValueTest() {
		long number = 0x3ab7f5;
		assertEquals(0x3ab7e5, BitOperations.setBitValue(number, 4, false));
		assertEquals(0x3ab7f5, BitOperations.setBitValue(number, 4, true));
	}
	
	@Test
	@Disabled
	void invertBitValueTest() {
		long number = 0x3ab7f5;
		assertEquals(0x3ab7e5, BitOperations.invertBitValue(number, 4));
		assertEquals(0x3ab7f4, BitOperations.invertBitValue(number, 0));
	}
	
	@Test
	@Disabled
	void leadingZerosTest() {
		assertEquals(0, BitOperations.leadingZeros(0xFF00000000000000L));	
		assertEquals(4, BitOperations.leadingZeros(0x0F00000000000000L));
		assertEquals(61, BitOperations.leadingZeros(4));
		assertEquals(60, BitOperations.leadingZeros(12));
		assertEquals(60, BitOperations.leadingZeros(13));
		assertEquals(63, BitOperations.leadingZeros(1));
		assertEquals(64, BitOperations.leadingZeros(0));
	}
	
	@Test
	@Disabled
	void onesInNumber() {
		assertEquals(1, BitOperations.onesInNumber(8));
		assertEquals(1, BitOperations.onesInNumber(4));
		assertEquals(2, BitOperations.onesInNumber(12));
		assertEquals(3, BitOperations.onesInNumber(13));
		assertEquals(1, BitOperations.onesInNumber(1));
		assertEquals(3, BitOperations.onesInNumber(7));
		assertEquals(0, BitOperations.onesInNumber(0));
		assertEquals(8, BitOperations.onesInNumber(255));
	}
	
	@Test
	@Disabled
	void getNDigitsTest() {
		assertEquals(3, Numbers.getNDigits(255));
		assertEquals(5, Numbers.getNDigits(10001));
		assertEquals(1, Numbers.getNDigits(5));
		assertEquals(9, Numbers.getNDigits(123456789));
	}
	
	@Test
	@Disabled
	void isHappyNumberTest() {
		assertFalse(Numbers.isHappyNumber(1000));
		assertFalse(Numbers.isHappyNumber(100_000));
		assertFalse(Numbers.isHappyNumber(55_334));
		assertFalse(Numbers.isHappyNumber(333_222));
		assertFalse(Numbers.isHappyNumber(1_000_000));
		assertFalse(Numbers.isHappyNumber(1_200_002));
		assertTrue(Numbers.isHappyNumber(271_334));
		assertTrue(Numbers.isHappyNumber(100_010));
		assertTrue(Numbers.isHappyNumber(321_006));
	}
	
	@Test
	@Disabled
	void getDigitsTest() {
		int[] expected = {1, 2, 3, 4};
		assertArrayEquals(expected, Numbers.getDigits(1234));
	}
	
	@Test
	void getNumberTest() {
		int expected = 12335;
		assertEquals(expected, Numbers.getNumber(new int[] {1, 2, 3, 3, 5}));
	}
}
