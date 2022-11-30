package telran.digital.numbers.strategy.symbols;

import java.util.Map;

public class One extends Symbol {
	public One(Map<Character, Symbol> symbols) {
		register(symbols);
	}
	
	@Override
	public String[] render(int offset, int width, int height) {
		return rightVerticalLine(offset + width - 1, height);
	}

	@Override
	public char symbol() {
		return '1';
	}
}
