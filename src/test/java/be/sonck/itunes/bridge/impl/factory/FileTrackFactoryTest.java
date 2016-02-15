package be.sonck.itunes.bridge.impl.factory;

import be.sonck.itunes.bridge.api.model.FileTrack;
import be.sonck.itunes.bridge.api.model.RatingKind;
import be.sonck.itunes.bridge.impl.model.FileTrackTO;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;

public class FileTrackFactoryTest {

	@Test
	public void test() {
		FileTrackTO to = new FileTrackTO("B411CFB0AB9DC862", "Lights", "The Back Room", "Editors",
				"1", "0", "80", "60", "user",
				"Macintosh HD 2:iTunes:iTunes Music:Music:Editors:The Back Room:01 Lights.mp3");

		FileTrack fileTrack = new FileTrackFactory().create(to);

		Assert.assertNotNull(fileTrack);
		Assert.assertEquals("B411CFB0AB9DC862", fileTrack.getPersistentId());
		Assert.assertEquals("The Back Room", fileTrack.getAlbum());
		Assert.assertEquals("Editors", fileTrack.getArtist());
		Assert.assertEquals(Integer.valueOf(0), fileTrack.getDiscNumber());
		Assert.assertEquals(Integer.valueOf(1), fileTrack.getTrackNumber());
		Assert.assertEquals(Integer.valueOf(80), fileTrack.getRating());
		Assert.assertEquals(Integer.valueOf(60), fileTrack.getAlbumRating());
		Assert.assertEquals(RatingKind.USER, fileTrack.getAlbumRatingKind());
		Assert.assertEquals("Lights", fileTrack.getName());
		Assert.assertEquals(
				"/Volumes/Macintosh HD 2/iTunes/iTunes Music/Music/Editors/The Back Room/01 Lights.mp3",
				fileTrack.getLocation().getAbsolutePath());
	}

	@Test
	public void testList() {

		List<FileTrackTO> toList = new ArrayList<FileTrackTO>();

		toList.add(new FileTrackTO("1", "Track 4", "The Back Room", "Editors", "4",
				"0", "60", "60", "user",
				"Macintosh HD 2:iTunes:iTunes Music:Music:Editors:The Back Room:01 Lights.mp3"));
		toList.add(new FileTrackTO("2", "Track 3", "The Back Room", "Editors", "3",
				"0", "20", "60", "user",
				"Macintosh HD 2:iTunes:iTunes Music:Music:Editors:The Back Room:01 Lights.mp3"));
		toList.add(new FileTrackTO("3", "Track 2", "The Back Room", "Editors", "2",
				"0", "40", "60", "user",
				"Macintosh HD 2:iTunes:iTunes Music:Music:Editors:The Back Room:01 Lights.mp3"));
		toList.add(new FileTrackTO("4", "Track 1", "The Back Room", "Editors", "1",
				"0", "80", "60", "user",
				"Macintosh HD 2:iTunes:iTunes Music:Music:Editors:The Back Room:01 Lights.mp3"));

		SortedSet<FileTrack> fileTracks = new FileTrackFactory().createFileTracks(toList);

		Assert.assertEquals(4, fileTracks.size());
		
		Iterator<FileTrack> iterator = fileTracks.iterator();
		Assert.assertEquals("4", iterator.next().getPersistentId());
		Assert.assertEquals("3", iterator.next().getPersistentId());
		Assert.assertEquals("2", iterator.next().getPersistentId());
		Assert.assertEquals("1", iterator.next().getPersistentId());
	}
}
