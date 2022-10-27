import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PrimitivesTest {

	@Test
	void test() {
//		fail("Not yet implemented");
		int a = 10;
		assertEquals(10.0, a);
	}

	@Test
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
}
