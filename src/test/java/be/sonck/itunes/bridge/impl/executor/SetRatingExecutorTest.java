package be.sonck.itunes.bridge.impl.executor;

import be.sonck.itunes.bridge.BasicSpringTest;
import be.sonck.itunes.bridge.api.model.FileTrack;
import org.fest.assertions.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by johansonck on 04/02/16.
 */
public class SetRatingExecutorTest extends BasicSpringTest {

    @Autowired
    private SetRatingExecutor setRatingExecutor;

    @Autowired
    private GetTrackExecutor getTrackExecutor;

    @Test
    public void setRating() throws Exception {
        FileTrack track = getTrackExecutor.getTrack("When Doves Cry", "Purple Rain", "Prince & The Revolution");

        Integer initialRating = track.getRating();
        Integer newRating = (0 == initialRating ? 100 : initialRating - 20);

        setRatingExecutor.setRating(track.getPersistentId(), newRating);

        track = getTrackExecutor.getTrack("When Doves Cry", "Purple Rain", "Prince & The Revolution");

        Assertions.assertThat(track.getRating()).isEqualTo(newRating);

        // don't mess up my library, reset the data after the test
        setRatingExecutor.setRating(track.getPersistentId(), initialRating);
    }
}