package pl.msiepracki.kata19.inputhandlers;

import java.util.List;

/**
 * 
 * @author Mateusz Siepracki
 *
 */
public class ParamsPojo {
	private String wordA;
	private String wordB;
	private List<String> dictionary;

	public ParamsPojo(String wordA, String wordB, List<String> dictionary) {
		super();
		this.wordA = wordA;
		this.wordB = wordB;
		this.dictionary = dictionary;
	}

	public ParamsPojo() {
		super();
	}

	public String getWordA() {
		return wordA;
	}

	public void setWordA(String wordA) {
		this.wordA = wordA;
	}

	public String getWordB() {
		return wordB;
	}

	public void setWordB(String wordB) {
		this.wordB = wordB;
	}

	public List<String> getDictionary() {
		return dictionary;
	}

	public void setDictionary(List<String> dictionary) {
		this.dictionary = dictionary;
	}

}
