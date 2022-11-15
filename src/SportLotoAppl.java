
public class SportLotoAppl {

	/**
	 * Application displays out 6 random numbers from 1 to 49 inclusive
	 * numbers can not be repeated in a sequence of 6 random numbers
	 * no additional collections / arrays
	 */
	public static void main(String[] args) {
		long array = 0;
		for (int i = 0; i < 6; i++) {
			int random = getUniqueRandomNumber(array);
			array = BitOperations.setBitValue(array, random, true);
			System.out.print(random + " ");
		}
	}

	private static int getUniqueRandomNumber(long array) {
		int result;
		do {
			result = Numbers.getRandomInt(1, 49);
		} while (BitOperations.getBitValue(array, result) == 1);
		return result;
	}
}
