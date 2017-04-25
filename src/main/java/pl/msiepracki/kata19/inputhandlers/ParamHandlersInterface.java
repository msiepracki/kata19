package pl.msiepracki.kata19.inputhandlers;

import java.io.IOException;

/**
 * 
 * @author Mateusz Siepracki
 *
 */
public interface ParamHandlersInterface {
	public ParamsPojo handle(String[] args) throws IOException;
}
