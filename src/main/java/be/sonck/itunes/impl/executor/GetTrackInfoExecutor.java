package be.sonck.itunes.impl.executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by johansonck on 30/01/16.
 */
@Service
public class GetTrackInfoExecutor {

    @Autowired
    private ClasspathAppleScriptExecutor executor;


}
