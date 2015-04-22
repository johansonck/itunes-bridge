package be.sonck.itunes.api.model;

import java.io.File;

public class FileTrack extends Track {

	private final File location;

	public FileTrack(String persistentId, String name, String album, String artist,
			int trackNumber, int discNumber, File location) {
		super(persistentId, name, album, artist, trackNumber, discNumber);
		this.location = location;
	}

	public File getLocation() {
		return location;
	}

	@Override
	public String toString() {
		return "FileTrack [location=" + location + ", getAlbum()=" + getAlbum() + ", getArtist()="
				+ getArtist() + ", getTrackNumber()=" + getTrackNumber() + ", getDiscNumber()="
				+ getDiscNumber() + ", getPersistentId()=" + getPersistentId() + ", getName()="
				+ getName() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
}
