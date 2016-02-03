package be.sonck.itunes.interpreter;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListInterpreter implements Interpreter<List<String>>{
	
	private static final String SEPARATOR = ", ";

	public List<String> interpret(String string) {
		if (!string.startsWith("{") || !string.endsWith("}")) {
			throw new IllegalArgumentException("a list must start with { and end with } (string='" + string + "')");
		}
		
		return splitElements(string.substring(1, string.length() - 1));
	}

	private List<String> splitElements(String string) {
		List<String> list = new ArrayList<String>();
		
		int pos = 0;
		
		int nextSeparator;
		while ((nextSeparator = findNextSeparator(string, pos)) != -1) {
			list.add(string.substring(pos, nextSeparator));
			pos = nextSeparator + SEPARATOR.length();
		}
		
		// add last element
		list.add(string.substring(pos));
		
		return list;
	}

	private int findNextSeparator(String string, int pos) {
		if (string.charAt(pos) == '{') {
			return determineIndex(string, findEndOfList(string, pos)); 
			
		} else if (string.charAt(pos) == '"') {
			return determineIndex(string, findEndOfString(string, pos)); 
			
		} else if (string.substring(pos).startsWith("alias \"")) {
			return determineIndex(string, findEndOfString(string, pos + 6)); 
			
		} else {
			return string.indexOf(SEPARATOR, pos);
		}
	}

	private int determineIndex(String string, int end) {
		int index;
		if (end == string.length()) {
			index = -1;
		} else {
			index = end;
		}
		return index;
	}

	private int findEndOfString(String string, int pos) {
		int length = string.length();
		for (int i = pos + 1; i < length; i++) {
			if (string.charAt(i) == '\\') {
				i++;
				continue;
			}
					
			if (string.charAt(i) == '"') { return i + 1; }
		}
		
		throw new IllegalStateException("no matching end-of-string could be found " + toString(string, pos));
	}

	private int findEndOfList(String string, int pos) {
		int length = string.length();
		int depth = 1;
		
		for (int i = pos + 1; i < length; i++) {
			if (string.charAt(i) == '\\') {
				i++;
				continue;
			}
			
			if (string.charAt(i) == '{') {
				depth++;
			} else if (string.charAt(i) == '}') {
				if (--depth == 0) { return i + 1; }
			}
		}
		
		throw new IllegalStateException("no matching end-of-list could be found " + toString(string, pos));
	}

	private String toString(String string, int pos) {
		return new StringBuilder().append("at pos ").append(pos).append(" in string '")
				.append(string).append("'").toString();
	}
}
