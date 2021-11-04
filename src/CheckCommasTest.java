import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * CheckCommas Tester.
 *
 * @author Vinayak Mathur vxm167
 * @version 1.1
 * @since Nov 3, 2021
 */
public class CheckCommasTest {

	private CheckCommas cc = new CheckCommas();

	@Before
	public void before() throws Exception {
		System.out.println("Starting test");
	}

	@After
	public void after() throws Exception {
		System.out.println("Test complete");
	}

	/**
	 * Method: validateInput(String inputString)
	 */
	@Test
	public void testValidateInput1() throws Exception {
//		Checks if exception is thrown if null
		assertThrows(NullPointerException.class, () -> cc.validateInput(null));
	}

	@Test
	public void testValidateInput2() throws Exception {
		//		Checks if exception is thrown if null
		assertEquals(cc.validateInput(""), "");
	}

	@Test
	public void testValidateInput3() throws Exception {
//		Checks if exception is thrown if numbers are present in String
		assertThrows(IllegalArgumentException.class, () -> cc.validateInput("all 0"));
	}

	@Test
	public void testValidateInput4() throws Exception {
		assertThrows(IllegalArgumentException.class, () -> cc.validateInput("all 9"));
	}

	@Test
	public void testValidateInput5() throws Exception {
		assertEquals(cc.validateInput("all hello me here zebra \n aha"), "all hello me here zebra \n aha");
	}

	/**
	 * Method: words(String inputString)
	 */
	@Test
	public void testWords() throws Exception {
		cc.setInputString("This is, what\n it should be like. is this what it should be like?");
		String[] arr = {"this", "is,", "what.", "it", "should", "be", "like.", "is", "this", "what", "it", "should", "be", "like?"};
		List<String> list = new ArrayList<>();
		Collections.addAll(list, arr);
		System.out.println(cc.words());
		System.out.println(list);
		assertEquals(cc.words(), list);
	}

	/**
	 * Method: inputString()
	 */
	@Test
	public void testInputString() throws Exception {
		cc.setInputString("hello there");
		assertEquals(cc.inputString(), "hello there");
	}

	/**
	 * Method: wordSet(List<String> words)
	 */
	@Test
	public void testWordSet() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = CheckCommas.getClass().getMethod("wordSet", List<String>.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
	}

} 
