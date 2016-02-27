package be.sonck.itunes.bridge.impl.factory;

import be.sonck.itunes.bridge.api.model.FileTrack;
import be.sonck.itunes.bridge.api.model.RatingKind;
import be.sonck.itunes.bridge.impl.model.FileTrackTO;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class FileTrackFactoryTest {

    @Test
    public void test() {
        Calendar currentTime = GregorianCalendar.getInstance();

        FileTrackTO to = FileTrackTO.newBuilder()
                .persistentId("B411CFB0AB9DC862")
                .name("Lights")
                .album("The Back Room")
                .artist("Editors")
                .trackNumber("1")
                .discNumber("0")
                .rating("80")
                .ratingKind("user")
                .albumRating("60")
                .albumRatingKind("user")
                .location("Macintosh HD 2:iTunes:iTunes Music:Music:Editors:The Back Room:01 Lights.mp3")
                .playedDate(currentTime)
                .build();

        FileTrack fileTrack = new FileTrackFactory().create(to);

        Assert.assertNotNull(fileTrack);
        assertEquals("B411CFB0AB9DC862", fileTrack.getPersistentId());
        assertEquals("The Back Room", fileTrack.getAlbum());
        assertEquals("Editors", fileTrack.getArtist());
        assertEquals(Integer.valueOf(0), fileTrack.getDiscNumber());
        assertEquals(Integer.valueOf(1), fileTrack.getTrackNumber());
        assertEquals(Integer.valueOf(80), fileTrack.getRating());
        assertEquals(RatingKind.USER, fileTrack.getRatingKind());
        assertEquals(Integer.valueOf(60), fileTrack.getAlbumRating());
        assertEquals(RatingKind.USER, fileTrack.getAlbumRatingKind());
        assertEquals("Lights", fileTrack.getName());
        assertEquals(
                "/Volumes/Macintosh HD 2/iTunes/iTunes Music/Music/Editors/The Back Room/01 Lights.mp3",
                fileTrack.getLocation().getAbsolutePath());
        assertEquals(currentTime, fileTrack.getPlayedDate());
    }

    @Test
    public void testList() {

        List<FileTrackTO> toList = new ArrayList<FileTrackTO>();

        toList.add(fileTrackTO("4"));
        toList.add(fileTrackTO("3"));
        toList.add(fileTrackTO("2"));
        toList.add(fileTrackTO("1"));

        SortedSet<FileTrack> fileTracks = new FileTrackFactory().createFileTracks(toList);

        assertEquals(4, fileTracks.size());

        Iterator<FileTrack> iterator = fileTracks.iterator();
        assertEquals("1", iterator.next().getPersistentId());
        assertEquals("2", iterator.next().getPersistentId());
        assertEquals("3", iterator.next().getPersistentId());
        assertEquals("4", iterator.next().getPersistentId());
    }

    private FileTrackTO fileTrackTO(String persistentId) {
        return FileTrackTO.newBuilder()
                .persistentId(persistentId)
                .ratingKind("user")
                .albumRatingKind("user")
                .build();
    }
}
