package telran.digital.numbers.strategy;

import java.util.*;

import telran.digital.numbers.strategy.symbols.*;

public class DigitalNumbersPrinting {
	
	private static final int INTERVAL = 3;
	private static Map<Character, Symbol> symbols = new HashMap<>();

	public static void displayDigitalNumber(int number, int offset, int width, int height) {
		registerSymbols();
		String[] lines = new String[height];
		initLines(lines);
		String str = String.valueOf(number);
		int length = str.length();
		int currentInterval = offset;
		for (int i = 0; i < length; i++) {
			addSymbol(lines, symbols.get(str.charAt(i)).render(currentInterval, width, height));
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

	public static void displayStrings(String[] strings) {
		for (int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}
	}
	
	public static void registerSymbols() {
		Symbol zero = new Zero();
		Symbol one = new One();
		Symbol two = new Two();
		Symbol three = new Three();
		Symbol four  = new Four();
		Symbol five = new Five();
		Symbol six = new Six();
		Symbol seven = new Seven();
		Symbol eight = new Eight();
		Symbol nine = new Nine();
		symbols.put(zero.symbol(), zero);
		symbols.put(one.symbol(), one);
		symbols.put(two.symbol(), two);
		symbols.put(three.symbol(), three);
		symbols.put(four.symbol(), four);
		symbols.put(five.symbol(), five);
		symbols.put(six.symbol(), six);
		symbols.put(seven.symbol(), seven);
		symbols.put(eight.symbol(), eight);
		symbols.put(nine.symbol(), nine);
	}
}
