package be.sonck.itunes.impl.factory;

import java.io.File;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import be.sonck.itunes.api.model.FileTrack;
import be.sonck.itunes.api.model.FileTrackComparator;
import be.sonck.itunes.impl.model.FileTrackTO;
import be.sonck.itunes.interpreter.LocationInterpreter;

public class FileTrackFactory {

	private LocationInterpreter locationInterpreter = new LocationInterpreter();

	public FileTrack create(FileTrackTO to) {
		return new FileTrack(to.getPersistentId(), to.getName(), to.getAlbum(), to.getArtist(),
				toInt(to.getTrackNumber()), toInt(to.getDiscNumber()), toFile(to.getLocation()));
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
