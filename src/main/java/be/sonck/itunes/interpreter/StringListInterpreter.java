package be.sonck.itunes.interpreter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StringListInterpreter implements Interpreter<List<String>> {
	
	private static final String SEPARATOR = "\t";
	
    @Autowired
	private StringInterpreter stringInterpreter;
	

	@Override
	public List<String> interpret(String string) {
		String interpretedString = stringInterpreter.interpret(string);
		String[] splitString = interpretedString.split(SEPARATOR, -1);
		return Arrays.asList(splitString);
	}
}
