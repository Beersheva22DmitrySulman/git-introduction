package telran.digital.numbers.strategy.symbols;

public class Eight extends Symbol {
	@Override
	public String[] render(int offset, int width, int height) {
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

	@Override
	public char symbol() {
		return '8';
	}
}
