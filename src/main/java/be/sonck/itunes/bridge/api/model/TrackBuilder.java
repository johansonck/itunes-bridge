package be.sonck.itunes.bridge.api.model;

/**
 * Created by johansonck on 13/12/15.
 */
public class TrackBuilder extends GenericTrackBuilder<TrackBuilder> {

    public TrackBuilder() {
        super();
    }

    public TrackBuilder(Track track) {
        super(track);
    }

    public Track build() {
        return new Track(this);
    }
}
