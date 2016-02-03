package be.sonck.itunes.impl.executor;

import be.sonck.itunes.BasicSpringTest;
import be.sonck.itunes.api.model.FileTrack;
import be.sonck.itunes.api.model.Playlist;
import be.sonck.itunes.api.model.PlaylistBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.SortedSet;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

/**
 * Created by johansonck on 28/12/15.
 */
public class GetTracksExecutorTest extends BasicSpringTest {

    @Autowired
    private GetTracksExecutor executor;

    @Test
    public void test() {
        Playlist playlist = new PlaylistBuilder().persistentId("26D6D2E65A2F19DD").build();
        SortedSet<FileTrack> tracks = executor.getTracks(playlist);

        assertNotNull(tracks);
        assertThat(tracks.size()).isGreaterThan(1);

        FileTrack track = tracks.iterator().next();
        assertThat(track.getPersistentId()).isEqualTo("566EB371EEFB58A8");
        assertThat(track.getAlbum()).isEqualTo("Akoustic Band");
        assertThat(track.getArtist()).isEqualTo("Chick Corea");
        assertThat(track.getName()).isEqualTo("Bessie's Blues");
        assertThat(track.getDiscNumber()).isEqualTo(Integer.valueOf(0));
        assertThat(track.getTrackNumber()).isEqualTo(Integer.valueOf(1));

        File location = track.getLocation();
        assertThat(location).isFile();
        assertThat(location.getAbsolutePath()).endsWith("01 Bessie's Blues.mp3");
    }
}