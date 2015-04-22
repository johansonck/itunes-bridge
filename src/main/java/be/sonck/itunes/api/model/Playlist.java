package be.sonck.itunes.api.model;

public class Playlist extends Item {

	public Playlist(String persistentId, String name) {
		super(persistentId, name);
	}

	@Override
	public String toString() {
		return "Playlist [persistentId=" + getPersistentId() + ", name=" + getName() + "]";
	}
}
