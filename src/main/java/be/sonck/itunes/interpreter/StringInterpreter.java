package be.sonck.itunes.interpreter;

import org.apache.commons.lang3.StringUtils;

public class StringInterpreter implements Interpreter<String> {

	public String interpret(String string) {
		if (StringUtils.isBlank(string)) { return null; }

		if (!string.startsWith("\"")) {
            return string;
        }
		
		// trim quotes
		return string.substring(1, string.length() - 1);
	}
}
