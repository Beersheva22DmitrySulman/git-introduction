import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class ObjectTests {

	@Test
	@Disabled
	void wrapperTest() {
		Integer a = 10;
		Integer b = 11;
		assertEquals(++a, b);
		Integer c = 201;
		Integer d = 201;
		assertEquals(c, d);
		assertTrue(a == b);
		assertTrue(d == 201);
		assertTrue(d >= b);
		assertFalse(d == c);
		assertTrue(d.equals(c));
	}

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

}
