package pl.msiepracki.kata19.test;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import pl.msiepracki.kata19.puzzle.WordDictionary;
import pl.msiepracki.kata19.puzzle.exception.WordDifferentLengthException;
import pl.msiepracki.kata19.puzzle.exception.WordNotFoundException;

/**
 * 
 * @author Mateusz Siepracki
 *
 */
public class WordDictionaryTest {
	private WordDictionary wordDictionary;
	private List<String> exampleWords;

	@Before
	public void setup() {
		exampleWords = Arrays.asList("abcd", "dcba", "abcde", "abcad", "zxcvb", "aa", "ab");
		wordDictionary = new WordDictionary(exampleWords);
	}

	@Test
	public void testSameLength() {
		String exampleWord = "abcad";
		assertThat(wordDictionary.getSameLengthWords(exampleWord), CoreMatchers.hasItems("abcde", "abcad", "zxcvb"));
	}

	@Test
	public void testSameLength2() {
		String exampleWord = "abcd";
		assertThat(wordDictionary.getSameLengthWords(exampleWord), CoreMatchers.hasItems("abcd", "dcba"));
	}

	@Test
	public void testTrim() {
		String exampleWord = "abcd ";
		assertThat(wordDictionary.getSameLengthWords(exampleWord), CoreMatchers.hasItems("abcd", "dcba"));
	}

	@Test(expected = WordNotFoundException.class)
	public void testValidationFailWordNotFound() {
		wordDictionary.validateWords("abcd", "dacb");
	}

	@Test(expected = WordDifferentLengthException.class)
	public void testValidationFailWordLength() {
		wordDictionary.validateWords("abcad", "abcd");
	}

	@Test
	public void testNullWordLength() {
		assertTrue(wordDictionary.getSameLengthWords(null) != null);
		assertTrue(wordDictionary.getSameLengthWords(null).isEmpty());
	}

}
