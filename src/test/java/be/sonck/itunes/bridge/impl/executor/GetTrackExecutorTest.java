package be.sonck.itunes.bridge.impl.executor;

import be.sonck.itunes.bridge.BasicSpringTest;
import be.sonck.itunes.bridge.api.model.FileTrack;
import org.fest.assertions.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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

        Assert.assertNotNull(track);
        Assertions.assertThat(track.getPersistentId()).isEqualTo("566EB371EEFB5DA7");
    }
}