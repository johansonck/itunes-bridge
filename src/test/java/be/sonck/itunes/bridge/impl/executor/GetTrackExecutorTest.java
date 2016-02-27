package be.sonck.itunes.bridge.impl.executor;

import be.sonck.itunes.bridge.BasicSpringTest;
import be.sonck.itunes.bridge.api.model.FileTrack;
import be.sonck.itunes.bridge.api.model.RatingKind;
import be.sonck.itunes.bridge.impl.util.CalendarUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
        assertThat(track.getRatingKind()).isEqualTo(RatingKind.USER);

        Calendar playedDate = track.getPlayedDate();

        assertNotNull(playedDate);
        assertThat(CalendarUtil.formatDate(playedDate)).isEqualTo("2014-08-09");
    }

    @Test
    public void executeWithoutDate() {
        String name = "Caged";
        String album = "Mother Earth";
        String artist = "Within Temptation";

        FileTrack track = executor.getTrack(name, album, artist);

        assertNotNull(track);
        assertNull(track.getPlayedDate());
    }
}