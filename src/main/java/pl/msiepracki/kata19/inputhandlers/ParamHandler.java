package pl.msiepracki.kata19.inputhandlers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Mateusz Siepracki
 *
 */
public class ParamHandler {
	private static Map<Integer, ParamHandlersInterface> map;

	static {
		map = new HashMap<Integer, ParamHandlersInterface>();
		map.put(2, new TwoParamsHandler());
		map.put(3, new ThreeParamsHandler());
	}

	public static ParamsPojo handle(String[] args) throws IOException {
		ParamHandlersInterface paramHandlersInterface = map.get(args.length);
		if (paramHandlersInterface == null)
			throw new RuntimeException("Wrong params - Usage: <word1> <word2> <path_to_dictionary (optional)>");
		return paramHandlersInterface.handle(args);
	}
}
