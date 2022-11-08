import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class MyArraysTest {
	@Test
	void addNumberTest() {
		int[] expected = {1, 2, 3, 4, 5, 10};
		assertArrayEquals(expected, MyArrays.addNumber(new int[] {1, 2, 3, 4, 5}, 10));
	}
	
	@Test
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
}
