package pl.msiepracki.kata19.inputhandlers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Mateusz Siepracki
 *
 */
public class ThreeParamsHandler implements ParamHandlersInterface {

	@Override
	public ParamsPojo handle(String[] args) throws IOException {
		File file = Paths.get(args[2]).toFile();
		System.out.println("Using external dictionary: " + file.getAbsolutePath());
		ParamsPojo params = new ParamsPojo();

		params.setWordA(args[0]);
		params.setWordB(args[1]);
		params.setDictionary(getWordsToDictionary(args[2]));
		return params;
	}

	private List<String> getWordsToDictionary(String path) throws IOException {
		List<String> dict = new ArrayList<String>();
		InputStream in = new FileInputStream(Paths.get(path).toFile());
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String word;
		while ((word = reader.readLine()) != null) {
			dict.add(word.trim());
		}
		reader.close();
		return dict;
	}

}
