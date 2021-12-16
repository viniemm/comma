import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Comma Tester.
 *
 * @author Vinayak Mathur
 * @version 1.0
 * @since Dec 16, 2021
 */
public class CommaTest {
	/**
	 * Method: validate()
	 */
	@Test
	public void testValidate() throws Exception {
		Comma cc1 = new Comma("all hello me here zebra \n aha");
		// Should throw NullPointerException if argument is null.
		assertThrows(NullPointerException.class, () -> new Comma(null));

		assertEquals(cc1, cc1.validate());

		assertThrows(IllegalArgumentException.class, new Comma("all 0")::validate);
		assertThrows(IllegalArgumentException.class, new Comma("all 9")::validate);

		assertEquals(cc1, cc1.validate());
	}

	/**
	 * Method: isSentence()
	 */
	@Test
	public void testIsSentence() throws Exception {
		Comma c1 = new Comma("This is, what. it, should be like. is this what it should be like?");
		assertFalse(c1.isSentence());
		Comma c2 = new Comma("Please, sit spot. Sit spot, sit. spot, here now, here.");
		assertTrue(c2.validate().isSentence());
	}
} 
