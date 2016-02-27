package be.sonck.itunes.bridge.impl.factory;

import be.sonck.itunes.bridge.api.model.FileTrack;
import be.sonck.itunes.bridge.api.model.FileTrackBuilder;
import be.sonck.itunes.bridge.api.model.FileTrackComparator;
import be.sonck.itunes.bridge.api.model.RatingKind;
import be.sonck.itunes.bridge.impl.model.FileTrackTO;
import be.sonck.itunes.bridge.interpreter.LocationInterpreter;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

@Service
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
                .rating(toInt(to.getRating()))
                .ratingKind(RatingKind.fromValue(to.getRatingKind()))
                .albumRating(toInt(to.getAlbumRating()))
                .albumRatingKind(RatingKind.fromValue(to.getAlbumRatingKind()))
                .location(toFile(to.getLocation()))
				.playedDate(to.getPlayedDate())
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
