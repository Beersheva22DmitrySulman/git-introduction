import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class IsraelIdentityTest {
	@Test
	void verifyTest() {;
		assertTrue(IsraelIdentity.verify(123456782));
		assertFalse(IsraelIdentity.verify(123456783));
		assertFalse(IsraelIdentity.verify(1234567820));
	}
	
	@Test
	void getRandomIdTest() {
		//Testing 100 randomly generated IDs
		for (int i = 0; i < 100; i++) {
			int id = IsraelIdentity.generateRandomId();
			assertTrue(IsraelIdentity.verify(id));
		}
	}
}
