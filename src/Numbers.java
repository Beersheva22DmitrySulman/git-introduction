
public class Numbers {
	
	public static final int HAPPY_NUMBER_LENGTH = 6;
	
	public static int getNDigits(long number) {
		int res = 0;
		do {
			res++;
			number /= 10;
		} while (number != 0);
		return res;
	}
	
	public static boolean isHappyNumber(int number) {
		boolean res = false;
		if (getNDigits(number) == HAPPY_NUMBER_LENGTH) {
			int halfLengthDivider = (int) Math.pow(10, HAPPY_NUMBER_LENGTH / 2);
			int leftSum = getSumDigits(number / halfLengthDivider);
			res = leftSum == getSumDigits(number % halfLengthDivider);
		}
		return res;
	}
	
	private static int getSumDigits(int num) {
		int res = 0;
		do {
			res += num % 10;
			num /= 10;
		} while (num != 0);
		return res;
	}

	public static int[] getDigits(int number) {
		int[] res = new int[getNDigits(number)];
		for (int i = res.length - 1; i >=0; i--) {
			res[i] = number % 10;
			number /= 10;
		}
		return res;
	}
	
	public static int getNumber(int[] digits) {
		int res = 0;
		for (int i = 0; i < digits.length; i++) {
			res = res * 10 + digits[i];
		}
		return res;
	}
}
