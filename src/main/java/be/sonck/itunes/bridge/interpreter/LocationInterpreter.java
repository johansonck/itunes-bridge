package be.sonck.itunes.bridge.interpreter;

import java.io.File;

public class LocationInterpreter implements Interpreter<File> {
	
	private static final String VOLUMES = "/Volumes/";
	

	@Override
	public File interpret(String string) {
		String path = VOLUMES + string.replace(':', '/');
		
		return new File(path);
	}

}
