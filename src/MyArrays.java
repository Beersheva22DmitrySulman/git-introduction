import java.util.Arrays;

public class MyArrays {
	/**
	 * 
	 * @param array
	 * @param num
	 * @return new array with added at end given number
	 */
	public static int[] addNumber(int[] array, int num) {
		int[] res = Arrays.copyOf(array, array.length + 1);
		res[res.length - 1] = num;
		return res;
	}

	/**
	 * 
	 * @param array
	 * @param index
	 * @return new array with no number at a given index in a given array if index
	 *         doesn't exist in a given array it returns the same array
	 */
	public static int[] removeNumber(int[] array, int index) {
		int[] res = array;
		if (index > -1 && index < array.length) {
			res = new int[array.length - 1];
			System.arraycopy(array, 0, res, 0, index);
			System.arraycopy(array, index + 1, res, index, array.length - index - 1);
		}
		return res;
	}

	/**
	 * 
	 * @param arraySorted
	 * @param number
	 * @return new array with inserted number at an index for keeping array sorted
	 */
	public static int[] insertSorted(int[] arraySorted, int number) {
		int index = Arrays.binarySearch(arraySorted, number);
		if (index < 0) {
			index = -1 - index;
		}

		return insertAtIndex(arraySorted, number, index);
	}

	private static int[] insertAtIndex(int[] array, int number, int index) {
		int[] res = new int[array.length + 1];
		res[index] = number;
		System.arraycopy(array, 0, res, 0, index);
		System.arraycopy(array, index, res, index + 1, array.length - index);
		return res;
	}

	public static int binarySearch(int[] array, int number) {
		return binarySearchLeft(array, number, 0, array.length - 1);
	}

	private static int binarySearchLeft(int[] array, int number, int l, int r) {
		while (l != r) {
			int m = l + (r - l) / 2;
			if (array[m] >= number) {
				r = m;
			} else {
				l = m + 1;
			}
		}
		int res = l;
		if (array[l] != number) {
			res = -1 - l;
		}
		return res;
	}

	public static void bubbleSort(int[] array) {
		int nextIterationLimit = array.length - 1;
		for (int i = 0; i < array.length - 1; i++) {
			nextIterationLimit = moveGreaterRight(array, nextIterationLimit);
			if (nextIterationLimit == -1) {
				break;
			}
		}
	}

	private static int moveGreaterRight(int[] array, int iterationLimit) {
		int lastSwapIndex = -1;
		for (int j = 0; j < iterationLimit; j++) {
			if (array[j + 1] < array[j]) {
				lastSwapIndex = j;
				swapElements(array, j, j + 1);
			}
		}
		return lastSwapIndex;
	}

	private static void swapElements(int[] array, int index1, int index2) {
		int swap = array[index1];
		array[index1] = array[index2];
		array[index2] = swap;
	}

	public static boolean isOneSwapForSorted(int[] array) {
		int[] arrayCopy = Arrays.copyOf(array, array.length);
		boolean res = false;
		int bugIndex = -1;
		int continueIndex = -1;		
		//Find the index of the first "bug" in the array
		for (int i = 1; i < arrayCopy.length; i++) {
			if (arrayCopy[i] < arrayCopy[i - 1]) {
				//Find the index of the first "bug" to properly handle the case when we have a subsequence of the same "bugs", e.g. { 2, 3, 4, 6, 6, 6, 5 }
				//At this moment we can be sure that the beginning part of the array is sorted, so we can safely use binarySearchLeft
				bugIndex = binarySearchLeft(arrayCopy, arrayCopy[i - 1], 0, i - 1);
				//Store the index where we stopped + 1
				continueIndex = i + 1;
				break;
			}
		}
		//If we found a "bug" we should find the first index where we can make a swap with the bug
		if (bugIndex != -1) {
			//If we don't find the index to swap we will take the last element of the array
			int swapIndex = arrayCopy.length - 1;
			//Find the index to swap starting from the continueIndex
			for (int i = continueIndex; i < arrayCopy.length; i++) {
				//Find the index of the first element which is not less than bug and return the previous index
				if (arrayCopy[i] >= arrayCopy[bugIndex]) {
					swapIndex = i - 1;
					break;
				}
			}
			//Swap elements
			swapElements(arrayCopy, bugIndex, swapIndex);
			//Check if now array is sorted. We can check it starting from the index of the bug (we can be sure that the beginning part of the array is sorted) but not less than from the 2nd element (index №1)
			res = isArrayPartSorted(arrayCopy, bugIndex);
		}	
		return res;
	}
	
	private static boolean isArrayPartSorted(int[] array, int start) {
		boolean res = true;
		for (int i = Math.max(1, start); i < array.length; i++) {
			if (array[i] < array[i - 1]) {
				res = false;
				break;
			}
		}
		return res;
	}
}
