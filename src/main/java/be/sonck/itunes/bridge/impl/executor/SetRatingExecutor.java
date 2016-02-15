package be.sonck.itunes.bridge.impl.executor;

import be.sonck.itunes.bridge.impl.service.Scripts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by johansonck on 04/02/16.
 */
@Service
public class SetRatingExecutor {

    @Autowired
    private ClasspathAppleScriptExecutor executor;


    public void setRating(String persistentId, int rating) {
        executor.execute(Scripts.SET_RATING, persistentId, Integer.toString(rating));
    }
}
