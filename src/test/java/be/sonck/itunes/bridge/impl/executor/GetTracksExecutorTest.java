package be.sonck.itunes.bridge.impl.executor;

import be.sonck.itunes.bridge.BasicSpringTest;
import be.sonck.itunes.bridge.api.model.FileTrack;
import be.sonck.itunes.bridge.api.model.Playlist;
import be.sonck.itunes.bridge.api.model.PlaylistBuilder;
import be.sonck.itunes.bridge.api.model.RatingKind;
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
        Playlist playlist = new PlaylistBuilder().persistentId("130D576BFBCDA288").build();
        SortedSet<FileTrack> tracks = executor.getTracks(playlist);

        assertNotNull(tracks);
        assertThat(tracks.size()).isGreaterThan(1);

        FileTrack track = tracks.iterator().next();
        assertThat(track.getPersistentId()).isEqualTo("566EB371EEFB6EAF");
        assertThat(track.getAlbum()).isEqualTo("Mother Earth");
        assertThat(track.getArtist()).isEqualTo("Within Temptation");
        assertThat(track.getName()).isEqualTo("Mother Earth");
        assertThat(track.getDiscNumber()).isEqualTo(Integer.valueOf(0));
        assertThat(track.getTrackNumber()).isEqualTo(Integer.valueOf(1));
        assertThat(track.getRatingKind()).isEqualTo(RatingKind.USER);
        assertNotNull(track.getPlayedDate());

        File location = track.getLocation();
        assertThat(location).isFile();
        assertThat(location.getAbsolutePath()).endsWith("01 Mother Earth.mp3");
    }
}