package be.sonck.itunes.impl.service;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

import be.sonck.itunes.impl.service.Config;
import be.sonck.itunes.impl.service.ScriptCopier;
import be.sonck.itunes.impl.service.Scripts;

public class ScriptCopierTest {

	@Test
	public void test() {
		new ScriptCopier().copyScript(Scripts.GET_ALL_PLAYLISTS);
		
		File file = new File(Config.TEMP_FOLDER + "/" + Scripts.GET_ALL_PLAYLISTS);
		Assert.assertTrue(file.exists());
	}
}
