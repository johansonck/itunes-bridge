package be.sonck.itunes.api.model;

/**
 * Created by johansonck on 13/12/15.
 */
public class TrackBuilder extends GenericTrackBuilder<TrackBuilder> {

    public Track build() {
        return new Track(this);
    }
}
