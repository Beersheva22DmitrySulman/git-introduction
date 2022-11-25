package telran.text;

import java.util.Arrays;

public class Strings {

	// str1 is ASCII string so the maximum letters count is 255
	private static final int MAX_LETTERS_COUNT = 255;

	private static final int MIN_VALUE = Byte.MIN_VALUE;

	private static final int MAX_VALUE = Byte.MAX_VALUE;

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
			int[] lettersCount = new int[MAX_LETTERS_COUNT + 1];
			int i = 0;
			res = true;
			while (i < str1.length() && res) {
				lettersCount[str1.charAt(i)]++;
				int c = str2.charAt(i);
				if (c <= MAX_LETTERS_COUNT) {
					lettersCount[c]--;
					i++;
				} else {
					res = false;
				}
			}
			i = 0;
			while (i < lettersCount.length && res) {
				res = lettersCount[i++] == 0;
			}
		}
		return res;
	}

	/**
	 * 
	 * @param array of string objects, each string contains decimal presentation of
	 *              a number The method sorts input array in-place
	 * 
	 */
	public static void sortStringNumbers(String[] array) {
		int[] helper = new int[MAX_VALUE - MIN_VALUE + 1];
		int min = MAX_VALUE;
		int max = MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			int value = Integer.parseInt(array[i]);
			helper[value - MIN_VALUE]++;
			min = Math.min(min, value);
			max = Math.max(max, value);
		}
		int index = 0;
		for (int i = min; i < max + 1; i++) {
			for (int j = 0; j < helper[i - MIN_VALUE]; j++) {
				array[index++] = String.valueOf(i);
			}
		}
	}

	public static String javaNameExp() {
		return "([a-zA-Z$][\\w$]*|_[\\w$]+)";
	}

	public static String ipV4Octet() {
		return "([0-1]?\\d?\\d|2[0-4]\\d|25[0-5])";
	}

	public static String ipV4() {
		return String.format("(%1$s\\.){3}%1$s", ipV4Octet());
	}

	private static String arithmeticExpression() {
		return String.format("\\(*%1$s(%2$s\\(*%1$s\\)*)*", operand(), operator());
	}

	private static String operand() {
		return String.format("(%1$s|%2$s)", doubleOperand(), javaNameExp());
	}
	
	private static String doubleOperand() {
		return "(\\d+\\.?\\d*|\\.\\d+)";
	}

	private static String operator() {
		return "([-+/*])";
	}

	public static boolean isArithmeticExpression(String expression) {
		expression = expression.replaceAll("\\s+", "");
		return expression.matches(arithmeticExpression());
	}

	/**
	 * 
	 * @param expression
	 * @param values
	 * @param namesSorted - variable names sorted
	 * @return computed value of a given expression or Double.NaN
	 */
	public static Double computeArithmeticExpression(String expression, double values[], String names[]) {
		Double res = Double.NaN;
		if (isArithmeticExpression(expression) && checkBraces(expression)) {
			expression = expression.replaceAll("[\\s()]+", "");
			String[] operands = expression.split(operator());
			String[] operators = expression.split(operand());
			res = getOperandValue(operands[0], values, names); 
			int index = 1;
			while (index < operators.length && !res.isNaN()) {
				double operandValue = getOperandValue(operands[index], values, names);
				res = computeOperation(res, operandValue, operators[index]);
				index++;
			}
		}
		return res;
	}

	private static Double computeOperation(Double operand1, Double operand2, String operator) {
		Double res = Double.NaN;
		if (!Double.isNaN(operand2)) {
			switch (operator) {
				case "+":
					res = operand1 + operand2;
					break;
				case "-":
					res = operand1 - operand2;
					break;
				case "*":
					res = operand1 * operand2;
					break;
				case "/":
					res = operand1 / operand2;
					break;
				default:
					res = Double.NaN;
			}
		}
		return res;
	}

	private static Double getOperandValue(String operand, double[] values, String[] names) {
		Double res = Double.NaN;
		if (operand.matches(doubleOperand())) {
			res = Double.parseDouble(operand);
		} else if (values != null && names != null){
			int index = Arrays.binarySearch(names, operand);
			if (index >= 0) {
				res = values[index];
			}
		}
		return res;
	}

	private static boolean checkBraces(String expression) {
		int count = 0;
		int index = 0;
		while (index < expression.length() && count >= 0) {
			char c = expression.charAt(index);
			if (c == '(') {
				count++;
			} else if (c == ')') {
				count--;
			}
			index++;
		}
		return count == 0;
	}
}
