import java.util.*;

public class Comma {
	private final String inputString;
	List<String> inputList;
	List<String> words;
	Set<String> after;
	Set<String> before;

	public Comma(String inputString) {
		Objects.requireNonNull(inputString);
		this.inputString = inputString.toLowerCase().
			replaceAll("\n", ". ").
			replaceAll(" +", " ");
		inputList = List.of(this.inputString);
		words = Arrays.asList(this.inputString.split(" "));

		commas();
	}

	public Comma validate() {
		Character[] nums = {'0','1','2','3','4','5','6','7','8','9'};
		List<Character> num = Arrays.asList(nums);
		for(char c: inputString.toCharArray()){
			if (num.contains(c)){
				throw new IllegalArgumentException("Numbers cannot be a part of the sentence");
			}
		}
		return this;
	}

	private boolean isPunctuation(Character c) {
		return (int) c < 97;
	}

	private String removePunctuation(String word) {
		StringBuilder fixed = new StringBuilder();
		for (char c : word.toCharArray()) {
			if (!isPunctuation(c)) {
				fixed.append(c);
			}
		}
		return fixed.toString();
	}

	private boolean endPunctuation(String s) {
		return isPunctuation(s.charAt(s.length() - 1));
	}

	private void commas() {
		after = new HashSet<>();
		before = new HashSet<>();
		for (int i = 0; i < words.size() - 1; i++) {
			String cur = words.get(i);
			String next = words.get(i + 1);
			if (hasAfter(cur)) {
				after.add(removePunctuation(cur));
				before.add(removePunctuation(next));
			}
		}
	}

	private boolean hasAfter(String cur) {
		return (cur.charAt(cur.length() - 1) == ',');
	}

	public boolean isSentence() {
		System.out.println("Should have comma before: "+before.toString()+"\nShould have comma after: "+after.toString());
		for (int i = 1; i < words.size(); i++) {
			String cur = words.get(i);
			String prev = words.get(i - 1);
			if (commaAfter(cur) || commaBefore(cur, prev))
				return false;

		}

		return true;
	}

	private boolean commaAfter(String cur) {
		return (after.contains(removePunctuation(cur)) && !endPunctuation(cur));
	}

	private boolean commaBefore(String cur, String prev) {
		return (before.contains(removePunctuation(cur)) && !endPunctuation(prev));
	}

}
