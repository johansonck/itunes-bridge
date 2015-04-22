package be.sonck.itunes.impl.factory;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import be.sonck.itunes.impl.model.FileTrackTO;

public class FileTrackTOFactoryTest {

	@Test
	public void test() {
		String input = "{\"B411CFB0AB9DC862	Lights	The Back Room	Editors	1	0	Macintosh HD 2:iTunes:iTunes Music:Music:Editors:The Back Room:01 Lights.mp3\", " +
				"\"C7DAC8C2EB37268A	Munich	The Back Room	Editors	2	0	Macintosh HD 2:iTunes:iTunes Music:Music:Editors:The Back Room:02 Munich.mp3\", " +
				"\"85DB5416B3AFCF43	Blood	The Back Room	Editors	3	0	Macintosh HD 2:iTunes:iTunes Music:Music:Editors:The Back Room:03 Blood.mp3\", " +
				"\"51A294DDA443B02C	Fall	The Back Room	Editors	4	0	Macintosh HD 2:iTunes:iTunes Music:Music:Editors:The Back Room:04 Fall.mp3\", " +
				"\"4E55B3775C247A9C	All Sparks	The Back Room	Editors	5	0	Macintosh HD 2:iTunes:iTunes Music:Music:Editors:The Back Room:05 All Sparks.mp3\", " +
				"\"54A19A339689D212	Camera	The Back Room	Editors	6	0	Macintosh HD 2:iTunes:iTunes Music:Music:Editors:The Back Room:06 Camera.mp3\", " +
				"\"269ECB0AA6E56E02	Fingers in the Factories	The Back Room	Editors	7	0	Macintosh HD 2:iTunes:iTunes Music:Music:Editors:The Back Room:07 Fingers in the Factories.mp3\"}";
		
		List<FileTrackTO> list = new FileTrackTOFactory().createList(input);
		Assert.assertNotNull(list);
		Assert.assertEquals(7, list.size());
		
		FileTrackTO track = findTrack(list, "85DB5416B3AFCF43");
		Assert.assertEquals("Blood", track.getName());
		Assert.assertEquals("The Back Room", track.getAlbum());
		Assert.assertEquals("Editors", track.getArtist());
		Assert.assertEquals("3", track.getTrackNumber());
		Assert.assertEquals("0", track.getDiscNumber());
		Assert.assertEquals("Macintosh HD 2:iTunes:iTunes Music:Music:Editors:The Back Room:03 Blood.mp3", track.getLocation());
	}

	private FileTrackTO findTrack(List<FileTrackTO> list, String id) {
		for (FileTrackTO track : list) {
			if (id.equals(track.getPersistentId())) { return track; }
		}
		
		Assert.fail("no track found with id '" + id + "'");
		return null;
	}
}
