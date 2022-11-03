public class BitOperations {
	/**
	 * 
	 * @param number - any number
	 * @param nBit - number of bit
	 * @return value of bit with number nBit
	 */
	public static int getBitValue(long number, int nBit) {
		int res = -1;
		if (checkNbit(nBit)) {
			long mask = extracted(nBit);
			res = (number & mask) == 0 ? 0 : 1;
		}
		return res;
	}
	
	private static boolean checkNbit(int nBit) {
		return nBit < 64 && nBit >= 0;
	}

	/**
	 * 
	 * @param number - any number
	 * @param nBit - number of bit
	 * @param value - true for 1, false for 0
	 * @return new number in which value of nBit's bit will have a given value
	 */
	public static long setBitValue(long number, int nBit, boolean value) {
		long res = -1L;
		if (checkNbit(nBit)) {
			long mask = extracted(nBit);
			res = value ? number | mask : number & ~mask;
		}
		return res;
	}

	private static long extracted(int nBit) {
		long mask = 1L << nBit;
		return mask;
	}

	/**
	 * 
	 * @param number
	 * @param nBit
	 * @return  new number in which value of nBit's bit will be reverted (old value - 1, new value - 0 and vice versa)
	 */
	public static long invertBitValue(long number, int nBit) {
		long res = -1L;
		if (checkNbit(nBit)) {
			long mask = extracted(nBit);
			res = number ^ mask;
		}
		return res;
	}
	
	public static int leadingZeros(long number) {
		int res = 0;
		int pos = 63;
		while (pos >= 0 && getBitValue(number, pos) == 0) {
			pos--;
			res++;
		}
		return res;
	}
	
	public static int onesInNumber(long number) {
		int count = 0;
		for (int i = 0; i < 64; i++) {
			if (getBitValue(number, i) == 1) {
				count++;
			}
		}
		return count;
	}
}


