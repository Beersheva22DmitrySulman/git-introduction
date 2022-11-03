
public class Numbers {
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
		if (number >= 100_000 && number <= 999_999) {
			int d1 = number % 10;
			int d2 = number / 10 % 10;
			int d3 = number / 100 % 10;
			int d4 = number / 1000 % 10;
			int d5 = number / 10000 % 10;
			int d6 = number / 100000;
			if (d1 + d2 + d3 == d4 + d5 + d6) {
				res = true;
			}
		}
		return res;
	}
}
