package be.sonck.itunes.interpreter;

import org.apache.commons.lang3.StringUtils;

public class AliasInterpreter implements Interpreter<String> {

	@Override
	public String interpret(String string) {
		if (StringUtils.isBlank(string)) { return null; }
		
		// trim quotes
		return string.substring("alias \"".length(), string.length() - 1);
	}
}
