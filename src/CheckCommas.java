import java.util.*;

public class CheckCommas {
	private String inputString;
	private List<String> words;
	private Set<String> wordsAsSet;
	private Set<String> commaBefore;
	private Set<String> commaAfter;


	public CheckCommas(String inputString) {
		setInputString(inputString);
	}

	public CheckCommas() {
	}

	public String setInputString(String inputString) {
//		This will act as a barricade the input and ensure that
		validateInput(inputString);
//		Makes the program robust to newlines and converts all text to lowercase for simplicity.
//		Also removes multiple spaces and replaces with single space.

		this.inputString = inputString.toLowerCase().
			replaceAll("\n", ". ").
			replaceAll(" +", " ");
		return this.inputString;
	}

	public String inputString() {
		return this.inputString;
	}


	//	validateInput acts as a barricade.
	String validateInput(String inputString) {
		Objects.requireNonNull(inputString, "The input string is null");
		for (int i = 0; i < inputString.length(); i++) {
			int ascii = (int) inputString.charAt(i);
			if (ascii < 58 && ascii > 47) {
				throw new IllegalArgumentException("Numbers cannot be a part of the sentence");
			}
		}
		return inputString;
	}

	List<String> words(String inputString) {
		validateInput(inputString);
		Objects.requireNonNull(inputString);
		List<String> result = Arrays.asList(inputString.split(" "));
		// result.removeAll(Arrays.asList("", null));
		return result;
	}

	List<String> words() {
		return this.words(this.inputString);
	}


	Set<String> wordSet(List<String> words) {
		Objects.requireNonNull(words);
		for (String word : words)
			for (char c : word.toCharArray())
				if ((int) c < 97) word = word.replace(String.valueOf(c), "");
		return new HashSet<>(words);
	}

//	private Set<String> commasBefore() {
//		Set<String> result = new HashSet<>();
//		String[] test = inputString.split(",");
//		for (String str : test) {
//			int i = 0;
//			int j = 1;
//			while (true) {
//				try {
//					int asc = (int) str.charAt(j);
//					if (asc > 97) {
//						break;
//					}
//				} catch (IndexOutOfBoundsException e) {
//					j--;
//					break;
//				}
//				j++;
//			}
//			result.add(str.substring(i, ++j));
//		}
//		return result;
//	}
//
//	private Set<String> commasAfter() {
//		Set<String> result = new HashSet<>();
//		String[] test = inputString.split(",");
//		for (String str : test) {
//			int i = str.length() - 1;
//			int j = i - 1;
//			while (true) {
//				try {
//					int asc = (int) str.charAt(j);
//					if (asc > 97) {
//						break;
//					}
//				} catch (IndexOutOfBoundsException e) {
//					j++;
//					break;
//				}
//				j--;
//			}
//			result.add(str.substring(j, ++i));
//		}
//		return result;
//	}
//
//	public boolean isSentence() {
//		int i = 0;
//		int j = 1;
//		while (j < inputString.length()) {
//			try {
//				int asc =
//				if (inputString.charAt(j))
//			}
//			catch(IndexOutOfBoundsException e){
//
//			}
//			j++;
//		}
//	}


}
