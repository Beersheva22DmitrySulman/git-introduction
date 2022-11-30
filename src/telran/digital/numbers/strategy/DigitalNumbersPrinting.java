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
		new Zero(symbols);
		new One(symbols);
		new Two(symbols);
		new Three(symbols);
		new Four(symbols);
		new Five(symbols);
		new Six(symbols);
		new Seven(symbols);
		new Eight(symbols);
		new Nine(symbols);
	}
}
