package pl.msiepracki.kata19.puzzle.exception;

/**
 * 
 * @author Mateusz Siepracki
 *
 */
public class WordNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WordNotFoundException(String message) {
		super(message);
	}

}
