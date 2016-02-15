package be.sonck.itunes.bridge.impl.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

public class ScriptCopier {

	public File copyScript(String scriptName) {
		InputStream inputStream = null;
		FileOutputStream outputStream = null;
		
		try {
			File outputFile = new File(Config.TEMP_FOLDER + "/" + scriptName);
			if (outputFile.exists()) { return outputFile; }
			
			inputStream = getResourceAsStream(scriptName);
			outputStream = new FileOutputStream(outputFile);
			
			IOUtils.copy(inputStream, outputStream);
			
			return outputFile;
			
		} catch (IOException e) {
			throw new RuntimeException(e);
			
		} finally {
			IOUtils.closeQuietly(inputStream);
			IOUtils.closeQuietly(outputStream);
		}
	}

	private InputStream getResourceAsStream(String scriptName) {
		InputStream inputStream = ScriptCopier.class.getResourceAsStream("/scripts/" + scriptName);
		if (inputStream == null) {
			throw new IllegalArgumentException("resource '/scripts/" + scriptName + "' could not be found");
		}
		return inputStream;
	}
}
