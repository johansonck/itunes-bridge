package be.sonck.itunes.bridge.api.model;

/**
 * Created by johansonck on 13/12/15.
 */
public class FolderPlaylistBuilder extends GenericFolderPlaylistBuilder<FolderPlaylistBuilder> {

    public FolderPlaylist build() {
        return new FolderPlaylist(this);
    }
}
