package be.sonck.itunes.bridge.interpreter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
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
