package be.sonck.itunes.impl.factory;

import be.sonck.itunes.api.model.FileTrack;
import be.sonck.itunes.api.model.FileTrackBuilder;
import be.sonck.itunes.api.model.FileTrackComparator;
import be.sonck.itunes.impl.model.FileTrackTO;
import be.sonck.itunes.interpreter.LocationInterpreter;

import java.io.File;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class FileTrackFactory {

	private LocationInterpreter locationInterpreter = new LocationInterpreter();

	public FileTrack create(FileTrackTO to) {
		return new FileTrackBuilder()
                .persistentId(to.getPersistentId())
                .name(to.getName())
                .album(to.getAlbum())
                .artist(to.getArtist())
                .trackNumber(toInt(to.getTrackNumber()))
                .discNumber(toInt(to.getDiscNumber()))
                .location(toFile(to.getLocation()))
                .build();
	}
	
	public SortedSet<FileTrack> createFileTracks(List<FileTrackTO> toList) {
		SortedSet<FileTrack> set = new TreeSet<FileTrack>(new FileTrackComparator());

		for (FileTrackTO to : toList) {
			set.add(create(to));
		}
		
		return set;
	}

	private int toInt(String string) {
		try {
			return Integer.parseInt(string);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	private File toFile(String location) {
		return locationInterpreter.interpret(location);
	}
}
