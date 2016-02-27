package be.sonck.itunes.bridge.api.model;

import java.util.Comparator;
import java.util.Objects;


public class FileTrackComparator implements Comparator<FileTrack> {

	@Override
	public int compare(FileTrack track1, FileTrack track2) {
		String album1 = track1.getAlbum();
		String album2 = track2.getAlbum();

        if (!Objects.equals(album1, album2)) return album1.compareTo(album2);
		
		int discNumber1 = track1.getDiscNumber();
		int discNumber2 = track2.getDiscNumber();
		
		if (discNumber1 != discNumber2) return discNumber1 - discNumber2;
		
		int trackNumber1 = track1.getTrackNumber();
		int trackNumber2 = track2.getTrackNumber();
		
		if (trackNumber1 != trackNumber2) return trackNumber1 - trackNumber2;

        String name1 = track1.getName();
        String name2 = track2.getName();

        if (!Objects.equals(name1, name2)) return name1.compareTo(name2);

        return track1.getPersistentId().compareTo(track2.getPersistentId());
	}
}
