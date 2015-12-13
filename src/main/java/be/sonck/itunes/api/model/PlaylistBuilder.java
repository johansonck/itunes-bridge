package be.sonck.itunes.api.model;

/**
 * Created by johansonck on 13/12/15.
 */
public class PlaylistBuilder extends GenericItemBuilder<PlaylistBuilder> {

    public Playlist build() {
        return new Playlist(this);
    }
}
