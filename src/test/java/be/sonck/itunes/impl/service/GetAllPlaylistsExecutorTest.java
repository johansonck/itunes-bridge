package be.sonck.itunes.impl.service;

import be.sonck.itunes.api.model.Playlist;
import org.junit.Test;

import java.util.SortedSet;

import static org.junit.Assert.assertNotNull;

/**
 * Created by johansonck on 28/12/15.
 */
public class GetAllPlaylistsExecutorTest {

    @Test
    public void test() {
        SortedSet<Playlist> playlists = new GetAllPlaylistsExecutor().getAllPlaylists();

        assertNotNull(playlists);
    }
}