
public class Strings {
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
			int[] lettersCount = new int[Character.MAX_VALUE + 1];
			for (int i = 0; i < str1.length(); i++) {
				lettersCount[str1.charAt(i)]++;
				lettersCount[str2.charAt(i)]--;
			}

			int i = 0;
			res = true;
			while (i < lettersCount.length && res) {
				res = lettersCount[i] == 0;
				i++;
			}
		}
		return res;
	}
}
