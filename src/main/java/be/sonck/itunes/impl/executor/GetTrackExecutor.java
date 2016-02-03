package be.sonck.itunes.impl.executor;

import be.sonck.itunes.api.model.FileTrack;
import be.sonck.itunes.impl.factory.FileTrackFactory;
import be.sonck.itunes.impl.factory.FileTrackTOFactory;
import be.sonck.itunes.impl.model.FileTrackTO;
import be.sonck.itunes.impl.service.Scripts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by johansonck on 30/01/16.
 */
@Service
public class GetTrackExecutor {

    @Autowired
    private ClasspathAppleScriptExecutor executor;

    @Autowired
    private FileTrackTOFactory fileTrackTOFactory;

    @Autowired
    private FileTrackFactory fileTrackFactory;


    public FileTrack getTrack(String name, String album, String artist) {
        List<Object> result = (List<Object>) executor.execute(Scripts.GET_TRACK, name, album, artist);

        FileTrackTO to = fileTrackTOFactory.createFromSingleTrackInfo(result);

        return fileTrackFactory.create(to);
    }
}
