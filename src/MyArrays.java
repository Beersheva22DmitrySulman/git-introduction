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
		if (array[l] > number) {
			res = -1 - l;
		} else if (array[l] < number) {
			res = - 2 - l;
		}
			
		return res;
	}

	public static void bubbleSort(int[] array) {
		int nextIterationLimit = array.length - 1;
		do {
			nextIterationLimit = moveGreaterRight(array, nextIterationLimit);
		} while (nextIterationLimit != -1);
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
		boolean res = false;
		int firstBugIndex = -1;
		int secondBugIndex = -1;
		int previousEqualsCount = 1;
		int bugsCount = 0;
		boolean countEqualsAfterFirstBugFound = false;
		for (int i = 1; i < array.length && bugsCount < 3; i++) {
			if (array[i] < array[i - 1]) {
				bugsCount++;
				countEqualsAfterFirstBugFound = false;
				if (bugsCount == 1) {
					firstBugIndex = i - previousEqualsCount;
					countEqualsAfterFirstBugFound = true;
					if (previousEqualsCount > 1) {
						bugsCount++;
					}
				}
				secondBugIndex = i;
			} else if (array[i] == array[i - 1]) {
				previousEqualsCount++;
				if (countEqualsAfterFirstBugFound) {
					secondBugIndex++;
				}
			} else {
				previousEqualsCount = 1;
				countEqualsAfterFirstBugFound = false;
			}
		}
		if (bugsCount == 1 || bugsCount == 2) {
			res = checkSwap(array, firstBugIndex, secondBugIndex);
		}
		return res;
	}

	private static boolean checkSwap(int[] array, int firstBugIndex, int secondBugIndex) {
		boolean res = true;
			if (secondBugIndex - firstBugIndex != 1) {
				res = checkLeftBound(array, secondBugIndex, array[firstBugIndex])
						&& checkRightBound(array, firstBugIndex, array[secondBugIndex]);
			}
			res = res && checkLeftBound(array, firstBugIndex, array[secondBugIndex])
					&& checkRightBound(array, secondBugIndex, array[firstBugIndex]);
		return res;
	}

	private static boolean checkLeftBound(int[] array, int index, int number) {
		return !(index > 0 && number < array[index - 1]);
	}

	private static boolean checkRightBound(int[] array, int index, int number) {
		return !(index < array.length - 1 && number > array[index + 1]);
	}
	
	/**
	 * 
	 * @param array
	 * @param sum
	 * @return true if array contains two numbers sum of which equals a given sum
	 */
	public static boolean isSum2(short[] array, short sum) {
		return true;
	}
}
