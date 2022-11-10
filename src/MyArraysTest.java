import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class MyArraysTest {
	@Test
	@Disabled
	void addNumberTest() {
		int[] expected = {1, 2, 3, 4, 5, 10};
		assertArrayEquals(expected, MyArrays.addNumber(new int[] {1, 2, 3, 4, 5}, 10));
	}
	
	@Test
	@Disabled
	void removeNumberTest() {
		int[] expected1 = {1, 2, 4, 5};
		assertArrayEquals(expected1, MyArrays.removeNumber(new int[] {1, 2, 3, 4, 5}, 2));
		int[] expected2 = {1, 2, 3, 4};
		assertArrayEquals(expected2, MyArrays.removeNumber(new int[] {1, 2, 3, 4, 5}, 4));
		int[] expected3 = {2, 3, 4, 5};
		assertArrayEquals(expected3, MyArrays.removeNumber(new int[] {1, 2, 3, 4, 5}, 0));
		int[] expected4 = {1, 2, 3, 4, 5};
		assertArrayEquals(expected4, MyArrays.removeNumber(new int[] {1, 2, 3, 4, 5}, 5));
		int[] expected5 = {1, 2, 3, 4, 5};
		assertArrayEquals(expected5, MyArrays.removeNumber(new int[] {1, 2, 3, 4, 5}, -5));
	}
	
	@Test
	@Disabled
	void insertSortedTest() {
		int[] expected1 = {1, 2, 3, 4, 5, 6};
		assertArrayEquals(expected1, MyArrays.insertSorted(new int[] {1, 2, 3, 4, 6}, 5));
		int[] expected2 = {1, 2, 3, 4, 4, 5};
		assertArrayEquals(expected2, MyArrays.insertSorted(new int[] {1, 2, 3, 4, 5}, 4));
		int[] expected3 = {1, 2, 3, 4, 5, 5};
		assertArrayEquals(expected3, MyArrays.insertSorted(new int[] {1, 2, 3, 4, 5}, 5));
		int[] expected4 = {1, 2, 3, 4, 5, 6};
		assertArrayEquals(expected4, MyArrays.insertSorted(new int[] {1, 2, 3, 4, 5}, 6));
		int[] expected5 = {1, 2, 3, 3, 3, 4};
		assertArrayEquals(expected5, MyArrays.insertSorted(new int[] {1, 2, 3, 3, 4}, 3));
		int[] expected6 = {1, 1, 2, 3, 4};
		assertArrayEquals(expected6, MyArrays.insertSorted(new int[] {1, 2, 3, 4}, 1));
		int[] expected7 = {0, 1, 2, 3, 4};
		assertArrayEquals(expected7, MyArrays.insertSorted(new int[] {1, 2, 3, 4}, 0));
		int[] expected8 = {1, 1, 2, 3, 4};
		assertArrayEquals(expected8, MyArrays.insertSorted(new int[] {1, 2, 3, 4}, 1));
	}
	
	@Test
	void binarySearchTest() {
		assertEquals(2, MyArrays.binarySearch(new int[] {1, 2, 3, 4, 6, 7, 8, 9, 10}, 3));
		assertEquals(3, MyArrays.binarySearch(new int[] {0, 1, 2, 3, 3, 3, 8, 9, 10}, 3));
		assertEquals(0, MyArrays.binarySearch(new int[] {3, 3, 3, 3, 3, 3, 8, 9, 10}, 3));
		assertEquals(0, MyArrays.binarySearch(new int[] {3, 3, 3, 3, 3, 3, 3, 3, 3}, 3));
		assertEquals(0, MyArrays.binarySearch(new int[] {3, 4, 5, 6}, 3));
		assertEquals(0, MyArrays.binarySearch(new int[] {3, 3, 4, 5, 6}, 3));
		assertEquals(-1, MyArrays.binarySearch(new int[] {3, 3, 3, 3, 3, 3, 8, 9, 10}, 2));
		assertEquals(-5, MyArrays.binarySearch(new int[] {1, 2, 3, 4, 6, 7, 8, 9, 10}, 5));
		assertEquals(-5, MyArrays.binarySearch(new int[] {1, 4, 4, 4, 6, 7, 8, 9, 10}, 5));
		assertEquals(-5, MyArrays.binarySearch(new int[] {1, 2, 3, 4, 6, 6, 6, 9, 10}, 5));
		assertEquals(-5, MyArrays.binarySearch(new int[] {1, 4, 4, 4, 6, 6, 6, 9, 10}, 5));
		assertEquals(-2, MyArrays.binarySearch(new int[] {1, 4, 4, 4, 6, 6, 6, 9, 10}, 2));
	}
}
