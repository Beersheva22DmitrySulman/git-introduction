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
		int l = 0;
		int r = array.length - 1;
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
	
	public static int count;

	public static void bubbleSort(int[] array) {
		count = 0;
		int nextInterationLimit = array.length - 1;
		for (int i = 0; i < array.length - 1; i++) {
			nextInterationLimit = moveGreaterRight(array, nextInterationLimit);
			if (nextInterationLimit == -1) {
				break;
			}
		}
		System.out.println(count);
	}
	
	private static int moveGreaterRight(int[] array, int length) {
		int lastSwapIndex = -1;
		for (int j = 0; j < length; j++) {
			count++;
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

	public static boolean checkArray(int[] array) {
		int[] arrayCopy = Arrays.copyOf(array, array.length);
		boolean res = false;
		int bugsCount = 0;
		int bugIndex = -1;
		for (int i = 1; i < arrayCopy.length; i++) {
			if (arrayCopy[i] < arrayCopy[i - 1]) {
				if (res) {
					res = false;
					break;
				}
				bugsCount++;
				if (bugIndex == -1) {
					bugIndex = i - 1;
				}
			}
			if (!res && bugIndex != -1) {
				swapElements(arrayCopy, bugIndex, i);
				res = isNubmerAtIndexValid(arrayCopy, bugIndex) && isNubmerAtIndexValid(arrayCopy, i);
				if (res) {
					bugsCount--;
				} else {
					swapElements(arrayCopy, bugIndex, i);
				}
			}
			if (bugsCount == 2) {
				res = false;
				break;
			}
		}

		return res;
	}

	private static boolean isNubmerAtIndexValid(int[] array, int index) {
		boolean res = true;
		if (index > 0 && array[index - 1] > array[index]) {
			res = false;
		}
		if (res && index < array.length - 1 && array[index + 1] < array[index]) {
			res = false;
		}
		return res;
	}

}
