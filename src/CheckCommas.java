import java.util.*;

public class CheckCommas {
	private String inputString;
	private List<String> words;
	private Set<String> wordsAsSet;
	private Set<String> commaBefore;
	private Set<String> commaAfter;
	private Set<String> commaBoth;
	private Set<String> commaNone;


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

	private List<String> words(String inputString) {
		validateInput(inputString);
		Objects.requireNonNull(inputString);
		List<String> result = Arrays.asList(inputString.split(" "));
		// result.removeAll(Arrays.asList("", null));
		this.words = result;
		return result;
	}

	List<String> words() {
		return this.words(this.inputString);
	}


	private Set<String> wordSet(List<String> words) {
		Objects.requireNonNull(words);
		Set<String> result = new HashSet<>();
		for (String word : words) {
			String fixed = removePunctuation(word);
			if (fixed.length() > 0) {
				result.add(fixed);
			}
		}
		this.wordsAsSet = result;
		return result;
	}

	Set<String> wordSet() {
		return wordSet(words());
	}

	private String removePunctuation(String word) {
		Objects.requireNonNull(word);
		StringBuilder fixed = new StringBuilder();
		for (char c : word.toCharArray()) {
			if ((int) c > 96) {
				fixed.append(c);
			}
		}
		return fixed.toString();
	}

	private String whereComma(int position, List<String> words) {
		Objects.requireNonNull(words);
		try {
			String cur = words.get(position);
			if (cur.charAt(cur.length() - 1) == ',') {
				return "after";
			}
			try {
				String prev = words.get(position - 1);
				if (prev.charAt(prev.length() - 1) == ',' && (int) cur.charAt(cur.length() - 1) > 96) {
					return "before";
				}
			} catch (IndexOutOfBoundsException e) {
				return "none";
			}
		} catch (IndexOutOfBoundsException e) {
			return "none";
		}
		return "none";
	}

	private List<Set<String>> commas(List<String> words) {
		Objects.requireNonNull(words);
		commaBefore = new HashSet<>();
		commaAfter = new HashSet<>();
		for (int i = 0; i < words.size(); i++) {
			String where = whereComma(i, words);
			switch (where) {
				case "after":
					commaAfter.add(words.get(i));
				case "before":
					commaBefore.add(words.get(i));
				case "none":
					commaNone.add(words.get(i));
			}
		}
		commaBoth = new HashSet<>(commaAfter);
		commaBoth.retainAll(commaBefore);
		commaBefore.removeAll(commaBoth);
		commaAfter.removeAll(commaBoth);
		List<Set<String>> result = new ArrayList<>();
		result.add(commaAfter);
		result.add(commaBefore);
		result.add(commaBoth);
		result.add(commaNone);
		return result;
	}


	List<Set<String>> commas() {
		return commas(words());
	}

//	boolean isSentence() {
//		if (Objects.isNull(commaAfter) || Objects.isNull(commaBefore)) {
//			commas();
//		}
//		for (String word : commaBefore){
//
//		}
//	}
//


	class Word {

	}
}
