package telran.digital.numbers.strategy.symbols;

import java.util.Map;

public abstract class Symbol {
	private static final String SYMBOL = "*";
	
	abstract public String[] render(int offset, int width, int height);
	
	abstract public char symbol();
	
	protected final String line(int offset, int length) {
		return " ".repeat(offset) + SYMBOL.repeat(length);
	}

	protected final String[] rightVerticalLine(int offset, int height) {
		String[] res = new String[height];
		for (int i = 0; i < res.length; i++) {
			res[i] = " ".repeat(offset) + SYMBOL;
		}
		return res;
	}

	protected final String[] leftVerticalLine(int offset, int width, int height) {
		String[] res = new String[height];
		for (int i = 0; i < res.length; i++) {
			res[i] = " ".repeat(offset) + SYMBOL + " ".repeat(width - 1);
		}
		return res;
	}

	protected final String[] twoVerticalLines(int offset, int width, int height) {
		String[] res = new String[height];
		for (int i = 0; i < res.length; i++) {
			res[i] = " ".repeat(offset) + SYMBOL + " ".repeat(width - 2) + SYMBOL;
		}
		return res;
	}
	
	protected void register(Map<Character, Symbol> symbols) {
		symbols.put(symbol(), this);
	}
}
