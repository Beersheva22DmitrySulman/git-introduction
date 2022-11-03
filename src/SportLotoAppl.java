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
			} while (arrayContainsValue(array, random));
			array = setValue(array, i, random);
			System.out.print(random + " ");
		}
	}

	private static int getRandomInt(int min, int max) {
		Random random = new Random();
		return random.nextInt(min, max + 1);
	}
	
	private static long setValue(long array, int index, int value) {
		long mask = (long) value << index * 6;
		return array | mask;
	}
	
	private static int getValue(long array, int index) {
		long mask = 63 << index * 6;
		return (int) ((array & mask) >> index * 6);
	}
	
	private static boolean arrayContainsValue(long array, int value) {
		for (int i = 0; i < 6; i++) {
			if (getValue(array, i) == value) {
				return true;
			}
		}
		return false;
	}
}
