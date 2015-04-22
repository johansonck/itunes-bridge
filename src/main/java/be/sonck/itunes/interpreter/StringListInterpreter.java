package be.sonck.itunes.interpreter;

import java.util.Arrays;
import java.util.List;

public class StringListInterpreter implements Interpreter<List<String>> {
	
	private static final String SEPARATOR = "\t";
	
	private StringInterpreter stringInterpreter = new StringInterpreter();
	

	@Override
	public List<String> interpret(String string) {
		return Arrays.asList(stringInterpreter.interpret(string).split(SEPARATOR, -1));
	}
}
