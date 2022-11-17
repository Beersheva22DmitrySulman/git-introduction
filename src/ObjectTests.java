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
		assertTrue(Strings.isAnagram("פםןוטאעיחלךעעע", "ךלחיעעאטועןםפע"));
		assertTrue(Strings.isAnagram("qwertyqwerty", "qwertyqwerty"));
		
		assertFalse(Strings.isAnagram("asdqwe", "qweasd1"));
		assertFalse(Strings.isAnagram("asdqwe", "qweasr"));
		assertFalse(Strings.isAnagram("פםןוטאעיחךעעע", "ךלחיעעאטוןםפע"));
	}

}
