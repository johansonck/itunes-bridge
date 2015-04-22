package be.sonck.itunes.api.model;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public class FolderPlaylist extends Playlist {

	private final SortedSet<Playlist> children;
	
	
	public FolderPlaylist(String persistentId, String name, SortedSet<Playlist> children) {
		super(persistentId, name);
		this.children = new TreeSet<Playlist>(children);
	}

	public SortedSet<Playlist> getChildren() {
		return Collections.unmodifiableSortedSet(children);
	}
}
