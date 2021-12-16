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
		words = Arrays.asList(inputString.split(" "));
		commas();
	}

	public void validate() {
		inputList.forEach(s -> {
			int ascii = (int) s.charAt(0);
			if (ascii < 58 && ascii > 47) {
				throw new IllegalArgumentException("Numbers cannot be a part of the sentence");
			}
		});
	}

	boolean isPunctuation(Character c) {
		return (int) c > 96;
	}

	String removePunctuation(String word) {
		StringBuilder fixed = new StringBuilder();
		for (char c : word.toCharArray()) {
			if (isPunctuation(c)) {
				fixed.append(c);
			}
		}
		return fixed.toString();
	}

	void commas() {
		after = new HashSet<>();
		before = new HashSet<>();
		for (int i = 0; i < words.size() - 1; i++) {
			String cur = words.get(i);
			String next = words.get(i + 1);
			if (cur.charAt(cur.length() - 1) == ',') {
				after.add(removePunctuation(cur));
				before.add(removePunctuation(cur));
			}
		}
	}

	public boolean isSentence() {
		for (String word : words)
			for (int i = 1; i < words.size(); i++) {
				String cur = words.get(i);
				String prev = words.get(i - 1);
				if (!checkBeforeAfter(cur, prev))
					return false;
			}
		return true;
	}

	private boolean checkBeforeAfter(String cur, String prev) {
		return checkAfter(cur) && checkBefore(cur, prev);
	}

	private boolean checkAfter(String cur) {
		return !after.contains(removePunctuation(cur)) || isPunctuation(cur.charAt(cur.length() - 1));
	}

	private boolean checkBefore(String cur, String prev) {
		return !before.contains(removePunctuation(cur)) || checkAfter(prev);
	}

}
