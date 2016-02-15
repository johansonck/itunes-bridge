package be.sonck.itunes.bridge.api.model;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import static org.apache.commons.lang3.RandomStringUtils.random;

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

        Assert.assertThat(track.getPersistentId(), CoreMatchers.is(persistendId));
        Assert.assertThat(track.getName(), CoreMatchers.is(name));
        Assert.assertThat(track.getAlbum(), CoreMatchers.is(album));
        Assert.assertThat(track.getArtist(), CoreMatchers.is(artist));
        Assert.assertThat(track.getDiscNumber(), CoreMatchers.is(discNumber));
        Assert.assertThat(track.getTrackNumber(), CoreMatchers.is(trackNumber));
    }
}