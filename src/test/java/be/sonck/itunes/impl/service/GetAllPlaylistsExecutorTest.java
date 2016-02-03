package be.sonck.itunes.impl.service;

import be.sonck.itunes.BasicSpringTest;
import be.sonck.itunes.api.model.FolderPlaylist;
import be.sonck.itunes.api.model.Playlist;
import be.sonck.itunes.impl.executor.GetAllPlaylistsExecutor;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.SortedSet;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

/**
 * Created by johansonck on 28/12/15.
 */
public class GetAllPlaylistsExecutorTest extends BasicSpringTest {

    @Autowired
    private GetAllPlaylistsExecutor executor;

    @Test
    public void test() {
        SortedSet<Playlist> playlists = executor.getAllPlaylists();

        Playlist playlist = findPlaylist(playlists, "FDFB971E421BADD7");
        FolderPlaylist folderPlaylist = assertIsFolder(playlist, "iTunes");

        SortedSet<Playlist> children = folderPlaylist.getChildren();
        assertNotNull(children);
        assertThat(children.size()).isGreaterThan(1);

        playlist = findPlaylist(children, "566EB371EEFB7967");
        folderPlaylist = assertIsFolder(playlist, "Artiest");

        children = folderPlaylist.getChildren();
        assertNotNull(children);
        assertThat(children.size()).isGreaterThan(1);

        playlist = findPlaylist(children, "566EB371EEFB797C");
        folderPlaylist = assertIsFolder(playlist, "Kiss");

        children = folderPlaylist.getChildren();
        assertNotNull(children);
        assertThat(children.size()).isGreaterThan(1);

        playlist = findPlaylist(children, "566EB371EEFB7946");
        assertThat(playlist.getName()).isEqualTo("Artiest - Kiss - Favoriete versies");

        assertNotNull(playlists);
    }

    private FolderPlaylist assertIsFolder(Playlist playlist, String name) {
        assertThat(playlist).isInstanceOf(FolderPlaylist.class);

        FolderPlaylist folderPlaylist = (FolderPlaylist) playlist;
        assertThat(folderPlaylist.getName()).isEqualTo(name);
        return folderPlaylist;
    }

    private Playlist findPlaylist(Set<Playlist> playlists, String persistentId) {
        for (Playlist playlist : playlists) {
            if (persistentId.equals(playlist.getPersistentId())) {
                return playlist;
            }
        }

        throw new IllegalArgumentException("playlist with persistent id '" + persistentId + "' not found");
    }
}