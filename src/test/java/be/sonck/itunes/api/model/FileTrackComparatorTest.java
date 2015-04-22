package be.sonck.itunes.api.model;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

public class FileTrackComparatorTest {

	@Test
	public void testAlbum() {
		FileTrack track1 = new FileTrack("1", "name", "B", "artist", 1, 1, new File(""));
		FileTrack track2 = new FileTrack("2", "name", "A", "artist", 1, 1, new File(""));
		
		Assert.assertTrue(new FileTrackComparator().compare(track1, track2) > 0);
	}
	
	@Test
	public void testDiscNumber() {
		FileTrack track1 = new FileTrack("1", "name", "A", "artist", 1, 2, new File(""));
		FileTrack track2 = new FileTrack("2", "name", "A", "artist", 1, 1, new File(""));
		
		Assert.assertTrue(new FileTrackComparator().compare(track1, track2) > 0);
	}
	
	@Test
	public void testTrackNumber() {
		FileTrack track1 = new FileTrack("1", "name", "A", "artist", 2, 1, new File(""));
		FileTrack track2 = new FileTrack("2", "name", "A", "artist", 1, 1, new File(""));
		
		Assert.assertTrue(new FileTrackComparator().compare(track1, track2) > 0);
	}
}
