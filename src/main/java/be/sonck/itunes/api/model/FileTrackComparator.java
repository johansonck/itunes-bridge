package be.sonck.itunes.api.model;

import java.util.Comparator;


public class FileTrackComparator implements Comparator<FileTrack> {

	@Override
	public int compare(FileTrack track1, FileTrack track2) {
		String album1 = track1.getAlbum();
		String album2 = track2.getAlbum();
		
		if (!album1.equals(album2)) { return album1.compareTo(album2); }
		
		int discNumber1 = track1.getDiscNumber();
		int discNumber2 = track2.getDiscNumber();
		
		if (discNumber1 != discNumber2) { return discNumber1 - discNumber2; }
		
		int trackNumber1 = track1.getTrackNumber();
		int trackNumber2 = track2.getTrackNumber();
		
		if (trackNumber1 != trackNumber2) { return trackNumber1 - trackNumber2; }
		
		return track1.getName().compareTo(track2.getName());
	}
}
