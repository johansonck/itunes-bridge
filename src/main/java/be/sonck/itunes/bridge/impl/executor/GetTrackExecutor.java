package be.sonck.itunes.bridge.impl.executor;

import be.sonck.itunes.bridge.api.model.FileTrack;
import be.sonck.itunes.bridge.impl.factory.FileTrackFactory;
import be.sonck.itunes.bridge.impl.factory.FileTrackTOFactory;
import be.sonck.itunes.bridge.impl.model.FileTrackTO;
import be.sonck.itunes.bridge.impl.service.Scripts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.script.ScriptException;
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
        try {
            List<Object> result = (List<Object>) executor.execute(Scripts.GET_TRACK, name, album, artist);

            FileTrackTO to = fileTrackTOFactory.createFromSingleTrackInfo(result);

            return fileTrackFactory.create(to);

        } catch (RuntimeException e) {
            if (isTrackNotFoundException(e)) {
                return null;
            } else {
                throw e;
            }
        }
    }

    private boolean isTrackNotFoundException(RuntimeException e) {
        Throwable cause = e.getCause();
        if (!(cause instanceof ScriptException)) return false;

        String message = cause.getMessage();
        return message.contains("iTunes got an error: Can’t get persistent ID");
    }
}
