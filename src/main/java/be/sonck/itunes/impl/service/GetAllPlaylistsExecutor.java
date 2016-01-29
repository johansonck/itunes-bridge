package be.sonck.itunes.impl.service;

import be.sonck.itunes.api.model.Playlist;
import be.sonck.itunes.impl.factory.PlaylistFactory;
import be.sonck.itunes.impl.factory.PlaylistTOFactory;
import be.sonck.itunes.impl.model.PlaylistTO;

import java.util.List;
import java.util.SortedSet;

/**
 * Created by johansonck on 28/12/15.
 */
public class GetAllPlaylistsExecutor {

    private ClasspathAppleScriptExecutor executor = new ClasspathAppleScriptExecutor();
    private PlaylistTOFactory playlistTOFactory = new PlaylistTOFactory();
    private PlaylistFactory playlistFactory = new PlaylistFactory();


    public SortedSet<Playlist> getAllPlaylists() {
        List<String> playlistStrings = (List<String>) executor.execute(Scripts.GET_ALL_PLAYLISTS);
        List<PlaylistTO> toList = playlistTOFactory.createList(playlistStrings);

        return playlistFactory.createPlaylists(toList);
    }

}
