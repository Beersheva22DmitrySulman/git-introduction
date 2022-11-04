import java.util.Random;

public class SportLotoAppl {

	/**
	 * Application displays out 6 random numbers from 1 to 49 inclusive
	 * numbers can not be repeated in a sequence of 6 random numbers
	 * no additional collections / arrays
	 */
	public static void main(String[] args) {
		long array = 0;
		for (int i = 0; i < 6; i++) {
			int random;
			do {
				random = getRandomInt(1, 49);
			} while (BitOperations.getBitValue(array, random) == 1);
			array = BitOperations.setBitValue(array, random, true);
			System.out.print(random + " ");
		}
	}

	private static int getRandomInt(int min, int max) {
		Random random = new Random();
		return random.nextInt(min, max + 1);
	}
}
