
public class Strings {
	
	//str1 is ASCII string so the maximum letters count is 255
	private static final int MAX_LETTERS_COUNT = 255;
	
	private static final int MIN_VALUE = Byte.MIN_VALUE;
	
	private static final int MAX_VALUE = Byte.MAX_VALUE;
	
	/**
	 * 
	 * @param str1
	 * @param str2
	 * @return true if str2 is an anagram of str1
	 * 
	 */
	public static boolean isAnagram(String str1, String str2) {
		boolean res = false;
		if (str1.length() == str2.length()) {
			int[] lettersCount = new int[MAX_LETTERS_COUNT + 1];
			int i = 0;
			res = true;
			while (i < str1.length() && res) {
				lettersCount[str1.charAt(i)]++;
				int c = str2.charAt(i);
				if (c <= MAX_LETTERS_COUNT) {
					lettersCount[c]--;
					i++;
				} else {
					res = false;
				}
			}
			i = 0;
			while (i < lettersCount.length && res) {
				res = lettersCount[i++] == 0;
			}
		}
		return res;
	}
	
	/**
	 * 
	 * @param array of string objects, each string contains decimal presentation of a number
	 * The method sorts input array in-place
	 * 
	 */
	public static void sortStringNumbers(String[] array) {
		int[] helper = new int[MAX_VALUE - MIN_VALUE + 1];
		int min = MAX_VALUE;
		int max = MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			int value = Integer.parseInt(array[i]);
			helper[value - MIN_VALUE]++;
			min = Math.min(min, value);
			max = Math.max(max, value);
		}
		int index = 0;
		for (int i = min; i < max + 1; i++) {
			for (int j = 0; j < helper[i - MIN_VALUE]; j++) {
				array[index++] = String.valueOf(i);
			}
		}
	}
}
