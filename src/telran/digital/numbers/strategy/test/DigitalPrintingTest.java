package telran.digital.numbers.strategy.test;

import org.junit.jupiter.api.Test;
import static telran.digital.numbers.strategy.DigitalNumbersPrinting.*;

public class DigitalPrintingTest {
	
	@Test
	void displayDigitalNumberTest() {
		displayDigitalNumber(1234567890, 0, 5, 5);
		displayDigitalNumber(1234567890, 20, 6, 6);
	}
}
