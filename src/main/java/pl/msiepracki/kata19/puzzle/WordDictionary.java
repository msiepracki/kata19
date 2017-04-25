package pl.msiepracki.kata19.puzzle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import pl.msiepracki.kata19.puzzle.exception.WordDifferentLengthException;
import pl.msiepracki.kata19.puzzle.exception.WordNotFoundException;

/**
 * 
 * @author Mateusz Siepracki
 *
 */
public class WordDictionary {

	private List<String> dictionary;

	public WordDictionary(List<String> dictionary) {
		if (dictionary != null)
			this.dictionary = dictionary.stream().map(String::trim).collect(Collectors.toList());
		else
			this.dictionary = new ArrayList<String>();
	}

	public List<String> getSameLengthWords(String wordToCheck) {
		List<String> outputWordList = new ArrayList<String>();
		for (String word : dictionary) {
			if (wordToCheck != null && word.length() == wordToCheck.trim().length())
				outputWordList.add(word);
		}
		return outputWordList;
	}

	public void validateWords(String... words) {
		int length = 0;
		if (dictionary == null || dictionary.isEmpty())
			throw new WordNotFoundException("Dictionary is null or empty");
		for (String word : words) {
			if (!dictionary.contains(word))
				throw new WordNotFoundException("Word not in dictionary: " + word);
			if (length == 0)
				length = word.length();
			if (length != word.length())
				throw new WordDifferentLengthException("Words have different length");
		}
	}
}
