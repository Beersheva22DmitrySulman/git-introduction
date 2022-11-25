package telran.text;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static telran.text.Strings.*;

public class StringsTest {
	@Test
	@Disabled
	void stringTest() {
		String hello = "hello";
		char[] helloAr = hello.toCharArray();
		assertEquals(104, helloAr[0]);
		assertEquals('h', helloAr[0]);
		assertEquals('i', helloAr[0] + 1);
		System.out.println(helloAr[0]);
		System.out.println((int) helloAr[0]);
	}
	
	@Test
	@Disabled
	void anagramTest() {
		assertTrue(Strings.isAnagram("asdqwe", "qweasd"));
		assertTrue(Strings.isAnagram("aa ssd d qqwwe  e", "q    wqweaeasdsd "));
		assertTrue(Strings.isAnagram("qwertyqwerty", "qwertyqwerty"));

		assertFalse(Strings.isAnagram("asdqwe", "qweasd1"));
		assertFalse(Strings.isAnagram("asdqwe", "qweasr"));
		assertFalse(Strings.isAnagram("hello", "привет"));

		String word = "yellow";

		assertTrue(Strings.isAnagram(word, "loweyl"));
		assertTrue(Strings.isAnagram(word, "elolyw"));
		assertTrue(Strings.isAnagram(word, "wolley"));
		assertTrue(Strings.isAnagram(word, "loleyw"));

		assertFalse(Strings.isAnagram(word, ""));
		assertFalse(Strings.isAnagram(word, "yellob"));
		assertFalse(Strings.isAnagram(word, "yello"));
		assertFalse(Strings.isAnagram(word, "yelllo"));
	}

	@Test
	@Disabled
	void sortStringNumbersTest() {
		String[] array1 = { "5", "-37", "15", "2", "22", "120", "118", "-110", "5", "2", "1", "0", "127", "-128", "1",
				"5" };
		Strings.sortStringNumbers(array1);
		assertArrayEquals(new String[] { "-128", "-110", "-37", "0", "1", "1", "2", "2", "5", "5", "5", "15", "22",
				"118", "120", "127" }, array1);

		String[] array2 = { "127", "127", "127", "127", "-128", "-128", "-128", "-128" };
		Strings.sortStringNumbers(array2);
		assertArrayEquals(new String[] { "-128", "-128", "-128", "-128", "127", "127", "127", "127" }, array2);

		String[] array3 = { "127", "100", "50", "0", "-50", "-100", "-128" };
		Strings.sortStringNumbers(array3);
		assertArrayEquals(new String[] { "-128", "-100", "-50", "0", "50", "100", "127" }, array3);

		String[] array4 = { "0", "0", "0", "0" };
		Strings.sortStringNumbers(array4);
		assertArrayEquals(new String[] { "0", "0", "0", "0" }, array4);

		String[] array5 = { "1" };
		Strings.sortStringNumbers(array5);
		assertArrayEquals(new String[] { "1" }, array5);
		
		String[] array6 = { "127", "-128" };
		Strings.sortStringNumbers(array6);
		assertArrayEquals(new String[] { "-128", "127" }, array6);
	}

	@Test
	void javaVariableTest() {
		assertTrue("java".matches(Strings.javaNameExp()));
		assertFalse("1java".matches(Strings.javaNameExp()));
		assertFalse("_".matches(Strings.javaNameExp()));
		assertTrue("__".matches(Strings.javaNameExp()));
		assertTrue("java_1_2".matches(Strings.javaNameExp()));
		assertTrue("$".matches(Strings.javaNameExp()));
		assertFalse("$ _".matches(Strings.javaNameExp()));
	}
	
	@Test
	void ipV40OctetTest() {
		assertTrue("0".matches(Strings.ipV4Octet()));
		assertTrue("00".matches(Strings.ipV4Octet()));
		assertTrue("000".matches(Strings.ipV4Octet()));
		assertTrue("1".matches(Strings.ipV4Octet()));
		assertTrue("01".matches(Strings.ipV4Octet()));
		assertTrue("001".matches(Strings.ipV4Octet()));
		assertTrue("10".matches(Strings.ipV4Octet()));
		assertTrue("010".matches(Strings.ipV4Octet()));
		assertTrue("100".matches(Strings.ipV4Octet()));
		assertTrue("199".matches(Strings.ipV4Octet()));
		assertTrue("200".matches(Strings.ipV4Octet()));
		assertTrue("249".matches(Strings.ipV4Octet()));
		assertTrue("250".matches(Strings.ipV4Octet()));
		assertTrue("255".matches(Strings.ipV4Octet()));
		
		assertFalse("256".matches(Strings.ipV4Octet()));
		assertFalse("260".matches(Strings.ipV4Octet()));
		assertFalse("300".matches(Strings.ipV4Octet()));
		assertFalse("1000".matches(Strings.ipV4Octet()));
	}
	
	@Test
	void ipV4() {
		assertTrue("0.0.0.0".matches(Strings.ipV4()));
		assertTrue("01.001.010.249".matches(Strings.ipV4()));
		assertTrue("255.255.255.255".matches(Strings.ipV4()));
		
		assertFalse("1.1.1.256".matches(Strings.ipV4()));
		assertFalse("1.1.1.260".matches(Strings.ipV4()));
		assertFalse("1.1.1.300".matches(Strings.ipV4()));
		assertFalse("1.1.1.1000".matches(Strings.ipV4()));
	}
	
	@Test
	void computeExpressionTest() {
		assertEquals(23, computeArithmeticExpression("10 * (2) + 3", null, null));
		assertEquals(10.5, computeArithmeticExpression("2 + 2 + 1 * 2 + 0.5", null, null));
		assertEquals(10.5, computeArithmeticExpression("a + 2 + c * 2 + 0.5", new double[] {2, 1},
				new String[] {"a", "c"}));	
		assertEquals(41.5, computeArithmeticExpression("((1 + 11 / 2) + (3 * 3 - 7) + 21.5)", null, null));
		assertEquals(10.5, computeArithmeticExpression("a$ + 2 + c_ * 2 + 0.5", new double[] {2, 1},
				new String[] {"a$", "c_"}));
		
		assertTrue(Double.isNaN(computeArithmeticExpression("2 # 2 ++ 10", null, null)));
		assertTrue(Double.isNaN(computeArithmeticExpression("(2 + 2) + 10)", null, null)));
		assertTrue(Double.isNaN(computeArithmeticExpression("(2 + 2() + 10)", null, null)));
		assertTrue(Double.isNaN(computeArithmeticExpression("a + 2 + c * 2 + d23", new double[] {2, 1},
				new String[] {"a", "c"})));
		assertTrue(Double.isNaN(computeArithmeticExpression("a$ + 2 + _ * 2 + 0.5", new double[] {2, 1},
				new String[] {"_", "a$"})));
		assertTrue(Double.isNaN(computeArithmeticExpression("(10 * 2 + 3))", null, null)));
		assertTrue(Double.isNaN(computeArithmeticExpression("10 * 2( + 3)", null, null)));
		assertTrue(Double.isNaN(computeArithmeticExpression("10 * )2) + 3", null, null)));
	}
}
