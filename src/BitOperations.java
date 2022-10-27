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
			long mask = 1 << nBit;
			if ((number & mask) == 0) {
				res = 0;
			} else {
				res = 1;
			}
		}
		return res;
	}
	
	private static boolean checkNbit(int nBit) {
		return nBit < 64 && nBit > 0;
	}

	/**
	 * 
	 * @param number - any number
	 * @param nBit - number of bit
	 * @param value - true for 1, false for 0
	 * @return new number in which value of nBit's bit will have a given value
	 */
	public static long setBitValue(long number, int nBit, boolean value) {
		return -1;
	}

	/**
	 * 
	 * @param number
	 * @param nBit
	 * @return  new number in which value of nBit's bit will be reverted (old value - 1, new value - 0) and vice versa)
	 */
	public static int revertBitValue(long number, int nBit) {
		return -1;
	}
}


