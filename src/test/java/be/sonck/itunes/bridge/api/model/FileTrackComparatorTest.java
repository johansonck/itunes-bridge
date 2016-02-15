package be.sonck.itunes.bridge.api.model;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class FileTrackComparatorTest {

	@Test
	public void testAlbum() {
        FileTrackBuilder builder = new FileTrackBuilder()
                .name("name")
                .artist("artist")
                .trackNumber(1)
                .discNumber(1)
                .location(new File(""));

        FileTrack track1 = builder.persistentId("1").album("B").build();
		FileTrack track2 = builder.persistentId("2").album("A").build();
		
		Assert.assertTrue(new FileTrackComparator().compare(track1, track2) > 0);
	}
	
	@Test
	public void testDiscNumber() {
        FileTrackBuilder builder = new FileTrackBuilder()
                .name("name")
                .album("A")
                .artist("artist")
                .trackNumber(1)
                .location(new File(""));

		FileTrack track1 = builder.persistentId("1").discNumber(2).build();
		FileTrack track2 = builder.persistentId("2").discNumber(1).build();
		
		Assert.assertTrue(new FileTrackComparator().compare(track1, track2) > 0);
	}
	
	@Test
	public void testTrackNumber() {
        FileTrackBuilder builder = new FileTrackBuilder()
                .name("name")
                .album("A")
                .artist("artist")
                .discNumber(1)
                .location(new File(""));

		FileTrack track1 = builder.persistentId("1").trackNumber(2).build();
		FileTrack track2 = builder.persistentId("2").trackNumber(1).build();
		
		Assert.assertTrue(new FileTrackComparator().compare(track1, track2) > 0);
	}
}
