package be.sonck.itunes.bridge.impl.executor;

import be.sonck.itunes.bridge.BasicSpringTest;
import be.sonck.itunes.bridge.api.model.FileTrack;
import be.sonck.itunes.bridge.api.model.Playlist;
import be.sonck.itunes.bridge.api.model.PlaylistBuilder;
import org.fest.assertions.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.SortedSet;

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

        Assert.assertNotNull(tracks);
        Assertions.assertThat(tracks.size()).isGreaterThan(1);

        FileTrack track = tracks.iterator().next();
        Assertions.assertThat(track.getPersistentId()).isEqualTo("566EB371EEFB58A8");
        Assertions.assertThat(track.getAlbum()).isEqualTo("Akoustic Band");
        Assertions.assertThat(track.getArtist()).isEqualTo("Chick Corea");
        Assertions.assertThat(track.getName()).isEqualTo("Bessie's Blues");
        Assertions.assertThat(track.getDiscNumber()).isEqualTo(Integer.valueOf(0));
        Assertions.assertThat(track.getTrackNumber()).isEqualTo(Integer.valueOf(1));

        File location = track.getLocation();
        Assertions.assertThat(location).isFile();
        Assertions.assertThat(location.getAbsolutePath()).endsWith("01 Bessie's Blues.mp3");
    }
}