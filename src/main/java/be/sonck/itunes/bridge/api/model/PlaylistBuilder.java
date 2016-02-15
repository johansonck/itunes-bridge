package be.sonck.itunes.bridge.api.model;

/**
 * Created by johansonck on 13/12/15.
 */
public class PlaylistBuilder extends GenericItemBuilder<PlaylistBuilder> {

    public Playlist build() {
        return new Playlist(this);
    }
}
