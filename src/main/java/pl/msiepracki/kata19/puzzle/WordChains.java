package pl.msiepracki.kata19.puzzle;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 
 * @author Mateusz Siepracki
 *
 */
public class WordChains {
	private final Integer MAX_ITERS = 10000;

	private Queue<String> potentialNeighbours;
	private Map<String, String> wordT;

	public String solve(String a, String b, List<String> dict) {
		WordDictionary dictionary = new WordDictionary(dict);
		dictionary.validateWords(a, b);
		if (a.equalsIgnoreCase(b))
			return a;

		potentialNeighbours = new LinkedList<>();
		potentialNeighbours.add(a);

		wordT = new HashMap<String, String>();
		wordT.put(a, null);

		return findNext(b, dictionary.getSameLengthWords(a));

	}

	private String findNext(String last, List<String> words) {
		Integer iters = 0;
		while (potentialNeighbours.size() > 0) {
			if (iters++ > MAX_ITERS)
				throw new RuntimeException("Iterations limit exceed over " + MAX_ITERS);
			String prev = potentialNeighbours.remove();

			for (String next : words) {
				if (!wordT.containsKey(next) && isOneCharDifferent(prev, next)) {
					wordT.put(next, prev);
					if (last.equalsIgnoreCase(next))
						return formatWordChain(next);
					potentialNeighbours.add(next);
				}
			}
		}
		return null;
	}

	private boolean isOneCharDifferent(String a, String b) {
		int diffs = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i))
				diffs++;
		}
		return diffs == 1;
	}

	private String formatWordChain(String word) {
		String result = word;
		word = wordT.get(word);
		while (word != null) {
			result = word + ", " + result;
			word = wordT.get(word);
		}
		return result;
	}

}
