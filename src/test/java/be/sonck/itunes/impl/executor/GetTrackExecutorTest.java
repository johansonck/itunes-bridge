package be.sonck.itunes.impl.executor;

import be.sonck.itunes.BasicSpringTest;
import be.sonck.itunes.api.model.FileTrack;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

/**
 * Created by johansonck on 03/02/16.
 */
public class GetTrackExecutorTest extends BasicSpringTest {

    @Autowired
    private GetTrackExecutor executor;


    @Test
    public void execute() {
        String name = "When Doves Cry";
        String album = "Purple Rain";
        String artist = "Prince & The Revolution";

        FileTrack track = executor.getTrack(name, album, artist);

        assertNotNull(track);
        assertThat(track.getPersistentId()).isEqualTo("566EB371EEFB5DA7");
    }
}