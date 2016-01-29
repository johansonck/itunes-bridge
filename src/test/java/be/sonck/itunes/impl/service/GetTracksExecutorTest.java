package be.sonck.itunes.impl.service;

import be.sonck.itunes.api.model.FileTrack;
import be.sonck.itunes.api.model.Playlist;
import be.sonck.itunes.api.model.PlaylistBuilder;
import org.junit.Test;

import java.io.File;
import java.util.SortedSet;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by johansonck on 28/12/15.
 */
public class GetTracksExecutorTest {

    @Test
    public void test() {
        Playlist playlist = new PlaylistBuilder().persistentId("26D6D2E65A2F19DD").build();
        SortedSet<FileTrack> tracks = new GetTracksExecutor().getTracks(playlist);

        assertNotNull(tracks);

        FileTrack track = tracks.iterator().next();
        File location = track.getLocation();

        assertTrue(location.exists());
    }
}