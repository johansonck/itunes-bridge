package be.sonck.itunes.api.model;

import java.io.File;

/**
 * Created by johansonck on 13/12/15.
 */
public class GenericFileTrackBuilder<B extends GenericFileTrackBuilder<B>> extends GenericTrackBuilder<B> {

    File location;

    public B location(File location) {
        this.location = location;
        return (B) this;
    }
}
