package telran.digital.numbers.strategy.symbols;

public class Seven extends Symbol {
	@Override
	public String[] render(int offset, int width, int height) {
		String[] res = new String[height];
		res[0] = line(offset, width);
		String lines[] = rightVerticalLine(offset + width - 1, height - 1);
		System.arraycopy(lines, 0, res, 1, lines.length);
		return res;
	}

	@Override
	public char symbol() {
		return '7';
	}
}
