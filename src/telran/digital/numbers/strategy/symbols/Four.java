package telran.digital.numbers.strategy.symbols;

import java.util.Map;

public class Four extends Symbol {
	public Four(Map<Character, Symbol> symbols) {
		register(symbols);
	}

	@Override
	public String[] render(int offset, int width, int height) {
		String[] res = new String[height];
		String lines[] = twoVerticalLines(offset, width, height / 2);
		System.arraycopy(lines, 0, res, 0, lines.length);
		res[height / 2] = line(offset, width);
		lines = rightVerticalLine(offset + width - 1, height - height / 2 - 1);
		System.arraycopy(lines, 0, res, height / 2 + 1, lines.length);
		return res;
	}

	@Override
	public char symbol() {
		return '4';
	}
}
