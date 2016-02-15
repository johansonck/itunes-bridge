package be.sonck.itunes.bridge.api.model;

import java.util.SortedSet;

public class FolderPlaylist extends Playlist {

	private final SortedSet<Playlist> children;
	
	
	public FolderPlaylist(FolderPlaylistBuilder builder) {
		this((GenericFolderPlaylistBuilder<?>) builder);
	}

	protected FolderPlaylist(GenericFolderPlaylistBuilder<?> builder) {
		super(builder);

		this.children = builder.children;
	}

	public SortedSet<Playlist> getChildren() {
		return children;
	}
}
