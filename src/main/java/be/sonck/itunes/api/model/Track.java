package be.sonck.itunes.api.model;

public class Track extends Item {

	private final String album;
	private final String artist;
	private final int trackNumber;
	private final int discNumber;

	public Track(String persistentId, String name, String album, String artist, int trackNumber,
			int discNumber) {
		super(persistentId, name);
		this.album = album;
		this.artist = artist;
		this.trackNumber = trackNumber;
		this.discNumber = discNumber;
	}

	public String getAlbum() {
		return album;
	}

	public String getArtist() {
		return artist;
	}

	public int getTrackNumber() {
		return trackNumber;
	}

	public int getDiscNumber() {
		return discNumber;
	}
}
