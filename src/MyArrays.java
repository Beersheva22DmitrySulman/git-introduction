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
	 * @return new array with no number at a given index in a given array
	 * if index doesn't exist in a given array it returns the same array
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
		int index = Arrays.binarySearch(arraySorted , number);
		if (index < 0) {
			index = -1 - index;
		}
		
		return insertAtIndex(arraySorted, number, index);
	}
	
	public static int[] insertAtIndex(int[] array, int number, int index) {
		int[] res = new int[array.length + 1];
		res[index] = number;
		System.arraycopy(array, 0, res, 0, index);
		System.arraycopy(array, index, res, index + 1, array.length - index);
		return res;
	}
}
