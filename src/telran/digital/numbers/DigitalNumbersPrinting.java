package telran.digital.numbers;

public class DigitalNumbersPrinting {
	private static final String SYMBOL = "*";
	private static final int INTERVAL = 3;

	public static void displayDigitalNumber(int number, int offset, int width, int height) {
		String[] lines = new String[height];
		initLines(lines);
		String str = String.valueOf(number);
		int length = str.length();
		int currentInterval = offset;
		for (int i = 0; i < length; i++) {
			switch (str.charAt(i)) {
			case '0':
				addSymbol(lines, zero(currentInterval, width, height));
				break;
			case '1':
				addSymbol(lines, one(currentInterval, width, height));
				break;
			case '2':
				addSymbol(lines, two(currentInterval, width, height));
				break;
			case '3':
				addSymbol(lines, three(currentInterval, width, height));
				break;
			case '4':
				addSymbol(lines, four(currentInterval, width, height));
				break;
			case '5':
				addSymbol(lines, five(currentInterval, width, height));
				break;
			case '6':
				addSymbol(lines, six(currentInterval, width, height));
				break;
			case '7':
				addSymbol(lines, seven(currentInterval, width, height));
				break;
			case '8':
				addSymbol(lines, eight(currentInterval, width, height));
				break;
			case '9':
				addSymbol(lines, nine(currentInterval, width, height));
				break;
			}
			currentInterval = INTERVAL;
		}

		displayStrings(lines);
	}

	private static void initLines(String[] lines) {
		for (int i = 0; i < lines.length; i++) {
			lines[i] = "";
		}
	}

	private static void addSymbol(String[] lines, String[] digit) {
		for (int i = 0; i < lines.length; i++) {
			lines[i] += digit[i];
		}
	}

	public static String[] zero(int offset, int width, int height) {
		String[] res = new String[height];
		res[0] = line(offset, width);
		String lines[] = twoVerticalLines(offset, width, height - 2);
		System.arraycopy(lines, 0, res, 1, lines.length);
		res[height - 1] = line(offset, width);
		return res;
	}

	public static String[] one(int offset, int width, int height) {
		return rightVerticalLine(offset + width - 1, height);
	}

	public static String[] two(int offset, int width, int height) {
		String[] res = new String[height];
		res[0] = line(offset, width);
		String lines[] = rightVerticalLine(offset + width - 1, height / 2 - 1);
		System.arraycopy(lines, 0, res, 1, lines.length);
		res[height / 2] = line(offset, width);
		lines = leftVerticalLine(offset, width, height - height / 2 - 2);
		System.arraycopy(lines, 0, res, height / 2 + 1, lines.length);
		res[height - 1] = line(offset, width);
		return res;
	}

	public static String[] three(int offset, int width, int height) {
		String[] res = new String[height];
		res[0] = line(offset, width);
		String lines[] = rightVerticalLine(offset + width - 1, height / 2 - 1);
		System.arraycopy(lines, 0, res, 1, lines.length);
		res[height / 2] = line(offset, width);
		lines = rightVerticalLine(offset + width - 1, height - height / 2 - 2);
		System.arraycopy(lines, 0, res, height / 2 + 1, lines.length);
		res[height - 1] = line(offset, width);
		return res;
	}

	public static String[] four(int offset, int width, int height) {
		String[] res = new String[height];
		String lines[] = twoVerticalLines(offset, width, height / 2);
		System.arraycopy(lines, 0, res, 0, lines.length);
		res[height / 2] = line(offset, width);
		lines = rightVerticalLine(offset + width - 1, height - height / 2 - 1);
		System.arraycopy(lines, 0, res, height / 2 + 1, lines.length);
		return res;
	}

	public static String[] five(int offset, int width, int height) {
		String[] res = new String[height];
		res[0] = line(offset, width);
		String lines[] = leftVerticalLine(offset, width, height / 2 - 1);
		System.arraycopy(lines, 0, res, 1, lines.length);
		res[height / 2] = line(offset, width);
		lines = rightVerticalLine(offset + width - 1, height - height / 2 - 2);
		System.arraycopy(lines, 0, res, height / 2 + 1, lines.length);
		res[height - 1] = line(offset, width);
		return res;
	}

	public static String[] six(int offset, int width, int height) {
		String[] res = new String[height];
		res[0] = line(offset, width);
		String lines[] = leftVerticalLine(offset, width, height / 2 - 1);
		System.arraycopy(lines, 0, res, 1, lines.length);
		res[height / 2] = line(offset, width);
		lines = twoVerticalLines(offset, width, height - height / 2 - 2);
		System.arraycopy(lines, 0, res, height / 2 + 1, lines.length);
		res[height - 1] = line(offset, width);
		return res;
	}

	public static String[] seven(int offset, int width, int height) {
		String[] res = new String[height];
		res[0] = line(offset, width);
		String lines[] = rightVerticalLine(offset + width - 1, height - 1);
		System.arraycopy(lines, 0, res, 1, lines.length);
		return res;
	}

	public static String[] eight(int offset, int width, int height) {
		String[] res = new String[height];
		res[0] = line(offset, width);
		String lines[] = twoVerticalLines(offset, width, height / 2 - 1);
		System.arraycopy(lines, 0, res, 1, lines.length);
		res[height / 2] = line(offset, width);
		lines = twoVerticalLines(offset, width, height - height / 2 - 2);
		System.arraycopy(lines, 0, res, height / 2 + 1, lines.length);
		res[height - 1] = line(offset, width);
		return res;
	}

	public static String[] nine(int offset, int width, int height) {
		String[] res = new String[height];
		res[0] = line(offset, width);
		String lines[] = twoVerticalLines(offset, width, height / 2 - 1);
		System.arraycopy(lines, 0, res, 1, lines.length);
		res[height / 2] = line(offset, width);
		lines = rightVerticalLine(offset + width - 1, height - height / 2 - 2);
		System.arraycopy(lines, 0, res, height / 2 + 1, lines.length);
		res[height - 1] = line(offset, width);
		return res;
	}

	public static String line(int offset, int length) {
		return " ".repeat(offset) + SYMBOL.repeat(length);
	}

	public static String[] rightVerticalLine(int offset, int height) {
		String[] res = new String[height];
		for (int i = 0; i < res.length; i++) {
			res[i] = " ".repeat(offset) + SYMBOL;
		}
		return res;
	}

	public static String[] leftVerticalLine(int offset, int width, int height) {
		String[] res = new String[height];
		for (int i = 0; i < res.length; i++) {
			res[i] = " ".repeat(offset) + SYMBOL + " ".repeat(width - 1);
		}
		return res;
	}

	public static String[] twoVerticalLines(int offset, int width, int height) {
		String[] res = new String[height];
		for (int i = 0; i < res.length; i++) {
			res[i] = " ".repeat(offset) + SYMBOL + " ".repeat(width - 2) + SYMBOL;
		}
		return res;
	}

	public static void displayStrings(String[] strings) {
		for (int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}
	}
}
