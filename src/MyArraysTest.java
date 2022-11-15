import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class MyArraysTest {
	@Test
	@Disabled
	void addNumberTest() {
		int[] expected = { 1, 2, 3, 4, 5, 10 };
		assertArrayEquals(expected, MyArrays.addNumber(new int[] { 1, 2, 3, 4, 5 }, 10));
	}

	@Test
	@Disabled
	void removeNumberTest() {
		int[] expected1 = { 1, 2, 4, 5 };
		assertArrayEquals(expected1, MyArrays.removeNumber(new int[] { 1, 2, 3, 4, 5 }, 2));
		int[] expected2 = { 1, 2, 3, 4 };
		assertArrayEquals(expected2, MyArrays.removeNumber(new int[] { 1, 2, 3, 4, 5 }, 4));
		int[] expected3 = { 2, 3, 4, 5 };
		assertArrayEquals(expected3, MyArrays.removeNumber(new int[] { 1, 2, 3, 4, 5 }, 0));
		int[] expected4 = { 1, 2, 3, 4, 5 };
		assertArrayEquals(expected4, MyArrays.removeNumber(new int[] { 1, 2, 3, 4, 5 }, 5));
		int[] expected5 = { 1, 2, 3, 4, 5 };
		assertArrayEquals(expected5, MyArrays.removeNumber(new int[] { 1, 2, 3, 4, 5 }, -5));
	}

	@Test
	@Disabled
	void insertSortedTest() {
		int[] expected1 = { 1, 2, 3, 4, 5, 6 };
		assertArrayEquals(expected1, MyArrays.insertSorted(new int[] { 1, 2, 3, 4, 6 }, 5));
		int[] expected2 = { 1, 2, 3, 4, 4, 5 };
		assertArrayEquals(expected2, MyArrays.insertSorted(new int[] { 1, 2, 3, 4, 5 }, 4));
		int[] expected3 = { 1, 2, 3, 4, 5, 5 };
		assertArrayEquals(expected3, MyArrays.insertSorted(new int[] { 1, 2, 3, 4, 5 }, 5));
		int[] expected4 = { 1, 2, 3, 4, 5, 6 };
		assertArrayEquals(expected4, MyArrays.insertSorted(new int[] { 1, 2, 3, 4, 5 }, 6));
		int[] expected5 = { 1, 2, 3, 3, 3, 4 };
		assertArrayEquals(expected5, MyArrays.insertSorted(new int[] { 1, 2, 3, 3, 4 }, 3));
		int[] expected6 = { 1, 1, 2, 3, 4 };
		assertArrayEquals(expected6, MyArrays.insertSorted(new int[] { 1, 2, 3, 4 }, 1));
		int[] expected7 = { 0, 1, 2, 3, 4 };
		assertArrayEquals(expected7, MyArrays.insertSorted(new int[] { 1, 2, 3, 4 }, 0));
		int[] expected8 = { 1, 1, 2, 3, 4 };
		assertArrayEquals(expected8, MyArrays.insertSorted(new int[] { 1, 2, 3, 4 }, 1));
	}

	@Test
	@Timeout(1)
	void binarySearchTest() {
		assertEquals(2, MyArrays.binarySearch(new int[] { 1, 2, 3, 4, 5 }, 3));
		assertEquals(2, MyArrays.binarySearch(new int[] { 1, 2, 3, 4, 6, 7, 8, 9, 10 }, 3));
		assertEquals(3, MyArrays.binarySearch(new int[] { 0, 1, 2, 3, 3, 3, 8, 9, 10 }, 3));
		assertEquals(2, MyArrays.binarySearch(new int[] { 0, 1, 2, 3, 3, 3, 8, 9, 10 }, 2));
		assertEquals(8, MyArrays.binarySearch(new int[] { 0, 1, 2, 3, 3, 3, 8, 9, 10 }, 10));
		assertEquals(0, MyArrays.binarySearch(new int[] { 3, 3, 3, 3, 3, 3, 8, 9, 10 }, 3));
		assertEquals(0, MyArrays.binarySearch(new int[] { 3, 3, 3, 3, 3, 3, 3, 3, 3 }, 3));
		assertEquals(0, MyArrays.binarySearch(new int[] { 3, 4, 5, 6 }, 3));
		assertEquals(0, MyArrays.binarySearch(new int[] { 3 }, 3));
		assertEquals(-1, MyArrays.binarySearch(new int[] { 3 }, 2));
		assertEquals(-2, MyArrays.binarySearch(new int[] { 3 }, 4));
		assertEquals(0, MyArrays.binarySearch(new int[] { 3, 3, 4, 5, 6 }, 3));
		assertEquals(-1, MyArrays.binarySearch(new int[] { 3, 3, 3, 3, 3, 3, 8, 9, 10 }, 2));
		assertEquals(-5, MyArrays.binarySearch(new int[] { 1, 2, 3, 4, 6, 7, 8, 9, 10 }, 5));
		assertEquals(-5, MyArrays.binarySearch(new int[] { 1, 4, 4, 4, 6, 7, 8, 9, 10 }, 5));
		assertEquals(-5, MyArrays.binarySearch(new int[] { 1, 2, 3, 4, 6, 6, 6, 9, 10 }, 5));
		assertEquals(-5, MyArrays.binarySearch(new int[] { 1, 4, 4, 4, 6, 6, 6, 9, 10 }, 5));
		assertEquals(-2, MyArrays.binarySearch(new int[] { 1, 4, 4, 4, 6, 6, 6, 9, 10 }, 2));
		assertEquals(-1, MyArrays.binarySearch(new int[] { 1, 4, 4, 4, 6, 6, 6, 9, 10 }, 0));
		assertEquals(-10, MyArrays.binarySearch(new int[] { 1, 4, 4, 4, 6, 6, 6, 9, 10 }, 11));

		int[] arrayMillionTwos = new int[1_000_000];
		for (int i = 0; i < 1_000_000; i++) {
			arrayMillionTwos[i] = 2;
		}
		assertEquals(0, MyArrays.binarySearch(arrayMillionTwos, 2));
	}

	@Test
	@Timeout(1)
	void bubbleSort() {
		int[] array1 = { 7, 36, 9, 8, 1, 0, 5, 12, 77, 6, 1 };
		MyArrays.bubbleSort(array1);
		assertArrayEquals(new int[] { 0, 1, 1, 5, 6, 7, 8, 9, 12, 36, 77 }, array1);

		int[] array2 = { 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2 };
		MyArrays.bubbleSort(array2);
		assertArrayEquals(new int[] { 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2 }, array2);

		int[] array3 = { 200, 150, 100, 50, 40, 30, 20, 12, 10, 10, 2 };
		MyArrays.bubbleSort(array3);
		assertArrayEquals(new int[] { 2, 10, 10, 12, 20, 30, 40, 50, 100, 150, 200 }, array3);

		int[] arrayMillionTwos = new int[1_000_000];
		for (int i = 0; i < 1_000_000; i++) {
			arrayMillionTwos[i] = 2;
		}
		MyArrays.bubbleSort(arrayMillionTwos);
	}

	@Test
	void isOneSwapTestTrue() {
		assertTrue(MyArrays.isOneSwapForSorted(new int[] { 10, 2, 3, 4, 1 }));
		assertTrue(MyArrays.isOneSwapForSorted(new int[] { 1, 2, 4, 3, 5, 10 }));
		assertTrue(MyArrays.isOneSwapForSorted(new int[] { 1, 2, 3, 10, 5, 4 }));
		assertTrue(MyArrays.isOneSwapForSorted(new int[] { 1, 5, 3, 4, 2, 10 }));
		assertTrue(MyArrays.isOneSwapForSorted(new int[] { 1, 2, 3, 4, 10, 5 }));
		assertTrue(MyArrays.isOneSwapForSorted(new int[] { 2, 1, 3, 4, 5, 10 }));
		assertTrue(MyArrays.isOneSwapForSorted(new int[] { 3, 2, 1, 4, 5, 6 }));

		assertTrue(MyArrays.isOneSwapForSorted(new int[] { 10, 1, 2, 3, 4, 5, 6, 7, 0 }));
		assertTrue(MyArrays.isOneSwapForSorted(new int[] { 1, 0, 2, 3, 4, 5, 6, 7, 8 }));
		assertTrue(MyArrays.isOneSwapForSorted(new int[] { 0, 0, 1, 3, 4, 5, 6, 9, 7 }));
		assertTrue(MyArrays.isOneSwapForSorted(new int[] { 0, 7, 1, 3, 4, 5, 6, 0, 9 }));
		assertTrue(MyArrays.isOneSwapForSorted(new int[] { 0, 7, 2, 3, 4, 5, 6, 1, 9 }));
		assertTrue(MyArrays.isOneSwapForSorted(new int[] { 1, 2, 3, 10, 16, 11, 20 }));
		assertTrue(MyArrays.isOneSwapForSorted(new int[] { 1, 2, 3, 10, 16, 11, 11, 10, 20 }));
		assertTrue(MyArrays.isOneSwapForSorted(new int[] { 1, 2, 3, 10, 16, 11, 11, 11, 20 }));
		assertTrue(MyArrays.isOneSwapForSorted(new int[] { 1, 2, 3, 10, 16, 11, 11, 16, 20 }));
		assertTrue(MyArrays.isOneSwapForSorted(new int[] { 5, 4, 4, 4, 4 }));
		assertTrue(MyArrays.isOneSwapForSorted(new int[] { 5, 5, 5, 5, 4 }));
		assertTrue(MyArrays.isOneSwapForSorted(new int[] { 5, 5, 5, 5, 5, 6, 5 }));
		assertTrue(MyArrays.isOneSwapForSorted(new int[] { 5, 5, 5, 6, 6, 6, 5 }));
		assertTrue(MyArrays.isOneSwapForSorted(new int[] { 10, 1 }));
		assertTrue(MyArrays.isOneSwapForSorted(new int[] { 1, 2, 3, 4, 5, 6, 5 }));
		assertTrue(MyArrays.isOneSwapForSorted(new int[] { 2, 3, 4, 6, 6, 6, 5 }));
		assertTrue(MyArrays.isOneSwapForSorted(new int[] { 2, 1, -3, 4, 5, 10 }));
		assertTrue(MyArrays.isOneSwapForSorted(new int[] { 1, 2, 5, 4, 4, 4, 4, 4, 2, 5, 5, 6 }));
		assertTrue(MyArrays.isOneSwapForSorted(new int[] { 1, 2, 5, 4, 4, 4, 4, 5, 2, 5, 5, 6 }));
		assertTrue(MyArrays.isOneSwapForSorted(new int[] { 1, 5, 3, 3, 3, 3, 5, 2, 7 }));
		assertTrue(MyArrays.isOneSwapForSorted(new int[] { 1, 5, 3, 3, 3, 3, 4, 2, 7 }));
		assertTrue(MyArrays.isOneSwapForSorted(new int[] { 1, 2, 4, 4, 4, 3, 5 }));
		assertTrue(MyArrays.isOneSwapForSorted(new int[] { 3, 6, 4, 4, 4, 7, 8, 10 }));
		assertTrue(MyArrays.isOneSwapForSorted(new int[] { 3, 3, 6, 3, 3, 6, 6, 3, 6, 6 }));
		assertTrue(MyArrays.isOneSwapForSorted(new int[] { 1, 2, 4, 4, 4, 3, 5, 5 }));
		assertTrue(MyArrays.isOneSwapForSorted(new int[] { 1, 2, 4, 3, 3, 3, 5, 5 }));
		assertTrue(MyArrays.isOneSwapForSorted(new int[] { 1, 2, 3, 10, 16, 16, 15, 16, 20 }));
	}

	@Test
	void isOneSwapTestFalse() {
		assertFalse(MyArrays.isOneSwapForSorted(new int[] { 1, 2, 3, 10, 1, 5, 6 }));
		assertFalse(MyArrays.isOneSwapForSorted(new int[] { 1, 2, 3, 4, 5, 10 }));
		assertFalse(MyArrays.isOneSwapForSorted(new int[] { 5, 1, 2, 4, 6, 10 }));
		assertFalse(MyArrays.isOneSwapForSorted(new int[] { 1, 5, 2, 4, 3, 10 }));
		assertFalse(MyArrays.isOneSwapForSorted(new int[] { 1, 3, 2, 5, 4, 10, 8 }));
		assertFalse(MyArrays.isOneSwapForSorted(new int[] { 1, 3, 20, 4, 5, 6, 10 }));
		assertFalse(MyArrays.isOneSwapForSorted(new int[] { 1, 3, 20, 4, 5, 11, 2 }));

		assertFalse(MyArrays.isOneSwapForSorted(new int[] { 1, 2, 3, 4, 5, 6, 6, 7 }));
		assertFalse(MyArrays.isOneSwapForSorted(new int[] { 5, 4, 4, 2, 1 }));
		assertFalse(MyArrays.isOneSwapForSorted(new int[] { 0, 10, 2, 11, 11, 12, 13, 1, 90 }));
		assertFalse(MyArrays.isOneSwapForSorted(new int[] { 2, 10, 4, 11, 11, 12, 13, 1, 90 }));
		assertFalse(MyArrays.isOneSwapForSorted(new int[] { 10, 0, 1, 3, 4, 5, 6, 7, 9 }));
		assertFalse(MyArrays.isOneSwapForSorted(new int[] { 1, 3, 4, 6, 12, 10, 11, 12, 13, 14 }));
		assertFalse(MyArrays.isOneSwapForSorted(new int[] { 1, 2, 3, 10, 16, 14, 11, 11, 11, 20 }));
		assertFalse(MyArrays.isOneSwapForSorted(new int[] { 5, 5, 5, 5, 5, 5, 5 }));
		assertFalse(MyArrays.isOneSwapForSorted(new int[] { 5, 5, 5, 5, 5, 5, 6 }));
		assertFalse(MyArrays.isOneSwapForSorted(new int[] { 1, 10 }));
		assertFalse(MyArrays.isOneSwapForSorted(new int[] { 1, 2, 3, 10, 0, 11, 12 }));
		assertFalse(MyArrays.isOneSwapForSorted(new int[] { 1, 2, 3, 4, 5, 6, 4 }));
		assertFalse(MyArrays.isOneSwapForSorted(new int[] { 1, 2, 5, 4, 4, 4, 5, 4, 2, 5, 5, 6 }));
		assertFalse(MyArrays.isOneSwapForSorted(new int[] { 10 }));
		assertFalse(MyArrays.isOneSwapForSorted(new int[] { 3, 6, 4, 4, 4, 7, 8, 2, 10 }));
		assertFalse(MyArrays.isOneSwapForSorted(new int[] { 1, 5, 4, 6, 7, 8, 5, 10 }));
		assertFalse(MyArrays.isOneSwapForSorted(new int[] { 1, 2, 3, 10, 16, 11, 11, 15, 20 }));
	}

	@Test
	void isSum2Test() {
		assertTrue(MyArrays.isSum2(new short[] { 0, 1, 2, 3, 4, 20 }, (short) 22));
		assertTrue(MyArrays.isSum2(new short[] { 0, 100, 2, 3, 4, 22 }, (short) 122));
		assertTrue(MyArrays.isSum2(new short[] { 0, 100, 2, 3, 4, 22 }, (short) 6));
		assertTrue(MyArrays.isSum2(new short[] { 0, 100, 2, 3, 4, 22 }, (short) 4));
		assertTrue(MyArrays.isSum2(new short[] { 0, 100, 2, 4, 4, 22 }, (short) 8));
		assertTrue(MyArrays.isSum2(new short[] { 0, 100, 2, 3, 4, 22 }, (short) 2));

		assertFalse(MyArrays.isSum2(new short[] { 0, 1, 2, 3, 4, 8 }, (short) 22));
		assertFalse(MyArrays.isSum2(new short[] { 0, 1, 2, 3, 4, 8 }, (short) 13));
		assertFalse(MyArrays.isSum2(new short[] { 1, 2, 3 }, (short) 1));
		assertFalse(MyArrays.isSum2(new short[] { 0, 100, 2, 3, 4, 22 }, (short) 8));
		assertFalse(MyArrays.isSum2(new short[] { 4, 2, 2, 2, 2, 2 }, (short) 8));
	}
}
