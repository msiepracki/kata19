package pl.msiepracki.kata19.puzzle.exception;

/**
 * 
 * @author Mateusz Siepracki
 *
 */
public class WordDifferentLengthException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WordDifferentLengthException(String message) {
		super(message); 
	}

}
