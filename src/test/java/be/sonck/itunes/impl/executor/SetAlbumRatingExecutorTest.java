package be.sonck.itunes.impl.executor;

import be.sonck.itunes.BasicSpringTest;
import be.sonck.itunes.api.model.FileTrack;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by johansonck on 04/02/16.
 */
public class SetAlbumRatingExecutorTest extends BasicSpringTest {

    @Autowired
    private SetAlbumRatingExecutor setAlbumRatingExecutor;

    @Autowired
    private GetTrackExecutor getTrackExecutor;

    @Test
    public void setRating() throws Exception {
        FileTrack track = getTrackExecutor.getTrack("When Doves Cry", "Purple Rain", "Prince & The Revolution");

        Integer initialRating = track.getAlbumRating();
        Integer newRating = (0 == initialRating ? 100 : initialRating - 20);

        setAlbumRatingExecutor.setRating(track.getPersistentId(), 0);

        track = getTrackExecutor.getTrack("When Doves Cry", "Purple Rain", "Prince & The Revolution");

//        assertThat(track.getAlbumRating()).isEqualTo(newRating);

        // don't mess up my library, reset the data after the test
//        setAlbumRatingExecutor.setRating(track.getPersistentId(), initialRating);
    }
}