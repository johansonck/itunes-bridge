package be.sonck.itunes.impl.executor;

import be.sonck.itunes.api.model.Playlist;
import be.sonck.itunes.impl.factory.PlaylistFactory;
import be.sonck.itunes.impl.factory.PlaylistTOFactory;
import be.sonck.itunes.impl.model.PlaylistTO;
import be.sonck.itunes.impl.service.Scripts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.SortedSet;

/**
 * Created by johansonck on 28/12/15.
 */
@Service
public class GetAllPlaylistsExecutor {

    @Autowired
    private ClasspathAppleScriptExecutor executor;

    @Autowired
    private PlaylistTOFactory playlistTOFactory;

    @Autowired
    private PlaylistFactory playlistFactory;


    public SortedSet<Playlist> getAllPlaylists() {
        List<String> playlistStrings = (List<String>) executor.execute(Scripts.GET_ALL_PLAYLISTS);
        List<PlaylistTO> toList = playlistTOFactory.createList(playlistStrings);

        return playlistFactory.createPlaylists(toList);
    }

}
