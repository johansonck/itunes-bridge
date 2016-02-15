package be.sonck.itunes.bridge.api.model;

public class Playlist extends Item {

	public Playlist(PlaylistBuilder playlistBuilder) {
		super(playlistBuilder);
	}

    protected Playlist(GenericItemBuilder<?> builder) {
        super(builder);
    }
}
