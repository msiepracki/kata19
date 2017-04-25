package pl.msiepracki.kata19.inputhandlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Mateusz Siepracki
 *
 */
public class TwoParamsHandler implements ParamHandlersInterface {

	@Override
	public ParamsPojo handle(String[] args) throws IOException {
		System.out.println("Using internal dictionary");
		ParamsPojo params = new ParamsPojo();

		params.setWordA(args[0]);
		params.setWordB(args[1]);
		params.setDictionary(getWordsToDictionary());
		return params;
	}

	private List<String> getWordsToDictionary() throws IOException {
		List<String> dict = new ArrayList<String>();
		InputStream in = this.getClass().getResourceAsStream("/wordlist.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		try {
			String word;
			while ((word = reader.readLine()) != null) {
				dict.add(word.trim());
			}
		} catch (IOException e) {
			System.err.println("IOException: " + e.getMessage());
		} finally {
			reader.close();
		}
		return dict;
	}

}
