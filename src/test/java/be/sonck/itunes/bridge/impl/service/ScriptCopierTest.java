package be.sonck.itunes.bridge.impl.service;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class ScriptCopierTest {

	@Test
	public void test() {
		new ScriptCopier().copyScript(Scripts.GET_ALL_PLAYLISTS);
		
		File file = new File(Config.TEMP_FOLDER + "/" + Scripts.GET_ALL_PLAYLISTS);
		Assert.assertTrue(file.exists());
	}
}
