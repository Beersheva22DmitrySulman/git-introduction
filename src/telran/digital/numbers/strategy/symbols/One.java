package telran.digital.numbers.strategy.symbols;

public class One extends Symbol {
	@Override
	public String[] render(int offset, int width, int height) {
		return rightVerticalLine(offset + width - 1, height);
	}

	@Override
	public char symbol() {
		return '1';
	}
}
