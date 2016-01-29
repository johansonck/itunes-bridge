package be.sonck.itunes.impl.service;

import be.sonck.itunes.api.model.FileTrack;
import be.sonck.itunes.api.model.Playlist;
import be.sonck.itunes.impl.factory.FileTrackFactory;
import be.sonck.itunes.impl.factory.FileTrackTOFactory;
import be.sonck.itunes.impl.model.FileTrackTO;

import java.util.List;
import java.util.SortedSet;

/**
 * Created by johansonck on 28/12/15.
 */
public class GetTracksExecutor {

    private ClasspathAppleScriptExecutor executor = new ClasspathAppleScriptExecutor();
    private FileTrackTOFactory fileTrackTOFactory = new FileTrackTOFactory();
    private FileTrackFactory fileTrackFactory = new FileTrackFactory();


    public SortedSet<FileTrack> getTracks(Playlist playlist) {
        List<?> result = (List<?>) executor.execute(Scripts.GET_TRACKS, playlist.getPersistentId());
        List<FileTrackTO> toList = fileTrackTOFactory.createFromTrackInfos(result);

        return fileTrackFactory.createFileTracks(toList);
    }
}
