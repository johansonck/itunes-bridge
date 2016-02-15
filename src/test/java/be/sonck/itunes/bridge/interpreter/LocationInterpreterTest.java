package be.sonck.itunes.bridge.interpreter;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class LocationInterpreterTest {

	@Test
	public void test() {
		String location = "Macintosh HD 2:iTunes:iTunes Music:Music:Yo-Yo Ma:Bach_ Cello Suites Nos. 1, 5 & 6:18 No. 6 - VI. Gigue.mp3";
		File file = new LocationInterpreter().interpret(location);
		Assert.assertNotNull(file);
		Assert.assertTrue(file.exists());
	}
}
