package pl.msiepracki.kata19.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pl.msiepracki.kata19.inputhandlers.ParamHandler;
import pl.msiepracki.kata19.inputhandlers.ParamsPojo;

/**
 * 
 * @author Mateusz Siepracki
 *
 */
public class ParamHandlerTest {
	private String par1 = "aaa";
	private String par2 = "bbb";
	private String pathString = "test_dictionary.txt";
	private Path filePath = Paths.get(pathString);
	private List<String> lines;

	@Before
	public void setup() throws IOException {
		lines = Arrays.asList("aaa", "aab", "bab", "bbb", "cdef");
		Files.write(filePath, lines, Charset.forName("UTF-8"));
	}

	@After
	public void teardown() throws IOException {
		if (Files.exists(filePath))
			Files.delete(filePath);
	}

	@Test
	public void testHandleTwoParams() throws IOException {
		ParamsPojo handle = ParamHandler.handle(new String[] { par1, par2 });
		assertEquals(handle.getWordA(), par1);
		assertEquals(handle.getWordB(), par2);
	}

	@Test(expected = IOException.class)
	public void testHandleFileDoesntExist() throws IOException {
		ParamHandler.handle(new String[] { par1, par2, filePath + "notexist" });
	}

	@Test
	public void testHandleThreeParams() throws IOException {
		ParamsPojo handle = ParamHandler.handle(new String[] { par1, par2, pathString });
		assertEquals(handle.getWordA(), par1);
		assertEquals(handle.getWordB(), par2);
		assertTrue(handle.getDictionary().containsAll(lines));
	}

}
