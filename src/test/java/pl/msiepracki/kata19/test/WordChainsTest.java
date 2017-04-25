package pl.msiepracki.kata19.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import pl.msiepracki.kata19.puzzle.WordChains;
import pl.msiepracki.kata19.puzzle.exception.WordDifferentLengthException;
import pl.msiepracki.kata19.puzzle.exception.WordNotFoundException;

/**
 * 
 * @author Mateusz Siepracki
 *
 */
public class WordChainsTest {
	private List<String> testDictionary;
	private WordChains wordChains;

	@Before
	public void setup() {
		testDictionary = Arrays.asList("gold", "god", "goad", "load", "lead", "cat", "dog", "cot", "cob", "coh", "cog",
				"ruby", "code", "mode", "rube", "robe", "rode", "role", "mole");
		wordChains = new WordChains();
	}

	@Test
	public void testForTXTGoldToLead() {
		String expected = "gold, goad, load, lead";
		assertEquals(expected, wordChains.solve("gold", "lead", testDictionary));
	}

	@Test
	public void testForTXTCatToDog() {
		String expected = "cat, cot, cog, dog";
		assertEquals(expected, wordChains.solve("cat", "dog", testDictionary));
	}

	@Test
	public void testForTXTRubyToCode() {
		String expected = "ruby, rube, robe, rode, code";
		assertEquals(expected, wordChains.solve("ruby", "code", testDictionary));
	}

	@Test
	public void testForInputLikeOutput() {
		String expected = "lead";
		assertEquals(expected, wordChains.solve("lead", "lead", testDictionary));
	}

	@Test(expected = WordDifferentLengthException.class)
	public void testForLengthException() {
		wordChains.solve("god", "lead", testDictionary);
	}

	@Test(expected = WordNotFoundException.class)
	public void testForWordNotInDictException() {
		wordChains.solve("abcdabcd", "dcbacdba", testDictionary);
	}

	@Test(expected = WordNotFoundException.class)
	public void testForWordNullException() {
		wordChains.solve(null, "dcbacdba", testDictionary);
	}

	@Test(expected = WordNotFoundException.class)
	public void testForDictionaryNullException() {
		wordChains.solve("god", "lead", null);
	}

}
