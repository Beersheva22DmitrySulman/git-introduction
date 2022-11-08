import java.util.Arrays;
import java.util.Random;

public class IsraelIdentity {
	public static final int VALID_ID_LENGTH = 9;
	
	/**
	 * 
	 * @param id
	 * @return true for right id otherwise false
	 * number 
	 * control sum should be multiple of 10  ( sum % 10 == 0)
	 * for even indexes (0, 2, 4, 6, 8) digits as is
	 * for odd indexes (1, 3, 5, 9) digit = digit * 2, if > 9 the sum of inner digits is taken
	 * example, 123456782 => 1 + 4(2 * 2) + 3 + 8(4 * 2) +5 + 3 (6 * 2 = 12 => 1 + 2) + 7 + 7 (8 * 2=16=>1 + 6) + 2
	 */
	public static boolean verify(int id) {
		int[] digits = Numbers.getDigits(id);
		return digits.length == VALID_ID_LENGTH && getCheckSum(digits) % 10 == 0;
	}
	
	/**
	 * 	
	 * @return random number of 9 digits matching right Israel id
	 * cycle not more than 9 iterations
	 */
	public static int generateRandomId() {
		int[] digits = new int[VALID_ID_LENGTH];
		for (int i = 0; i < VALID_ID_LENGTH - 1; i++) {
			int min = i == 0 ? 1 : 0;
			digits[i] = getRandomDigit(min);
		}
		int checkSumMod = getCheckSum(digits) % 10;
		digits[VALID_ID_LENGTH - 1] = checkSumMod == 0 ? 0 : 10 - checkSumMod;
		return Numbers.getNumber(digits);
	}
	
	private static int getCheckSum(int[] digits) {
		int sum = 0;
		for (int i = 0; i < digits.length; i++) {
			int digit = i % 2 == 0 ? digits[i] : Numbers.getSumDigits(digits[i] * 2);
			sum += digit;
		}
		return sum;
	}
	
	private static int getRandomDigit(int min) {
		Random random = new Random();
		return random.nextInt(min, 10);
	}
}
