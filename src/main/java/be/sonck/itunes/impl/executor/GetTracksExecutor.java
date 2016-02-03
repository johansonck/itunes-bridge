package be.sonck.itunes.impl.executor;

import be.sonck.itunes.api.model.FileTrack;
import be.sonck.itunes.api.model.Playlist;
import be.sonck.itunes.impl.factory.FileTrackFactory;
import be.sonck.itunes.impl.factory.FileTrackTOFactory;
import be.sonck.itunes.impl.model.FileTrackTO;
import be.sonck.itunes.impl.service.Scripts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.SortedSet;

/**
 * Created by johansonck on 28/12/15.
 */
@Service
public class GetTracksExecutor {

    @Autowired
    private ClasspathAppleScriptExecutor executor;

    @Autowired
    private FileTrackTOFactory fileTrackTOFactory;

    @Autowired
    private FileTrackFactory fileTrackFactory;


    public SortedSet<FileTrack> getTracks(Playlist playlist) {
        List<?> result = (List<?>) executor.execute(Scripts.GET_TRACKS, playlist.getPersistentId());
        List<FileTrackTO> toList = fileTrackTOFactory.createFromTrackInfos(result);

        return fileTrackFactory.createFileTracks(toList);
    }
}
