package be.sonck.itunes.api.model;

import org.junit.Test;

import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by johansonck on 13/12/15.
 */
public class TrackBuilderTest {

    @Test
    public void testBuilder() {
        String persistendId = random(10);
        String name = random(10);
        String album = random(10);
        String artist = random(10);
        int discNumber = 1;
        int trackNumber = 2;

        Track track = new TrackBuilder()
                .persistentId(persistendId)
                .name(name)
                .album(album)
                .artist(artist)
                .discNumber(discNumber)
                .trackNumber(trackNumber)
                .build();

        assertThat(track.getPersistentId(), is(persistendId));
        assertThat(track.getName(), is(name));
        assertThat(track.getAlbum(), is(album));
        assertThat(track.getArtist(), is(artist));
        assertThat(track.getDiscNumber(), is(discNumber));
        assertThat(track.getTrackNumber(), is(trackNumber));
    }
}