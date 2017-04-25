package pl.msiepracki.kata19;

import java.io.IOException;

import pl.msiepracki.kata19.inputhandlers.ParamHandler;
import pl.msiepracki.kata19.inputhandlers.ParamsPojo;
import pl.msiepracki.kata19.puzzle.WordChains;

/**
 * 
 * @author Mateusz Siepracki
 *
 */
public class Application {
	public static void main(String[] args) throws IOException {
		ParamsPojo params = ParamHandler.handle(args);
		WordChains k = new WordChains();
		String solution = k.solve(params.getWordA(), params.getWordB(), params.getDictionary());
		System.out.println("Input words: " + params.getWordA() + " -> " + params.getWordB());
		System.out.println("Solution: " + solution);
	}

}
