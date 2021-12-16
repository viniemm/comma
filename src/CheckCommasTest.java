import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * CheckCommas Tester.
 *
 * @author Vinayak Mathur vxm167
 * @version 1.1
 * @since Nov 3, 2021
 */
public class CheckCommasTest {

	private final CheckCommas cc = new CheckCommas();
	private long startTime;


	/**
	 * Method: validateInput(String inputString)
	 */
	@Test
	public void testValidateInput() {
//		Checks if exception is thrown if null
		assertThrows(NullPointerException.class, () -> cc.validateInput(null));
		//		Checks if exception is thrown if null
		assertEquals(cc.validateInput(""), "");
		//		Checks if exception is thrown if numbers are present in String
		assertThrows(IllegalArgumentException.class, () -> cc.validateInput("all 0"));
		assertThrows(IllegalArgumentException.class, () -> cc.validateInput("all 9"));
		assertEquals(cc.validateInput("all hello me here zebra \n aha"), "all hello me here zebra \n aha");
	}

	/**
	 * Method: words(String inputString)
	 */
	@Test
	public void testWords() {
		cc.setInputString("This is, what\n it should be like. is this what it should be like?");
		String[] arr = {"this", "is,", "what.", "it", "should", "be", "like.", "is", "this", "what", "it", "should", "be", "like?"};
		List<String> list = new ArrayList<>();
		Collections.addAll(list, arr);
		assertEquals(cc.words(), list);
	}

	/**
	 * Method: inputString()
	 */
	@Test
	public void testInputString() {
		cc.setInputString("hello there");
		assertEquals(cc.inputString(), "hello there");
	}

	/**
	 * Method: wordSet(List<String> words)
	 */
	@Test
	public void testWordSet() {
		String[] arr = {"this", "is", "what", "it", "should", "be", "like"};
		Set<String> set = new HashSet<>();
		Collections.addAll(set, arr);
		CheckCommas cc2 = new CheckCommas("This is, what\n it should be like. is this what it should be like ?");
		assertEquals(cc2.wordSet(), set);
	}

} 
