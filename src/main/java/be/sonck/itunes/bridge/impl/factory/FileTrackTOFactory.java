package be.sonck.itunes.bridge.impl.factory;

import be.sonck.itunes.bridge.impl.model.FileTrackTO;
import be.sonck.itunes.bridge.interpreter.ForcedListInterpreter;
import be.sonck.itunes.bridge.interpreter.ListInterpreter;
import be.sonck.itunes.bridge.interpreter.StringInterpreter;
import be.sonck.itunes.bridge.interpreter.StringListInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class FileTrackTOFactory {

    @Autowired
    private ListInterpreter listInterpreter;

    @Autowired
    private StringListInterpreter stringListInterpreter;

    @Autowired
    private StringInterpreter stringInterpreter;

    @Autowired
    private ForcedListInterpreter forcedListInterpreter;


    public List<FileTrackTO> createFromTrackInfos(List<?> trackInfoList) {
        int i = 0;

        List<String> ids = (List<String>) trackInfoList.get(i++);
        List<String> names = (List<String>) trackInfoList.get(i++);
        List<String> albums = (List<String>) trackInfoList.get(i++);
        List<String> artists = (List<String>) trackInfoList.get(i++);
        List<Long> trackNumbers = (List<Long>) trackInfoList.get(i++);
        List<Long> discNumbers = (List<Long>) trackInfoList.get(i++);
        List<Long> ratings = (List<Long>) trackInfoList.get(i++);
        List<Long> albumRatings = (List<Long>) trackInfoList.get(i++);
        List<String> albumRatingKinds = stringToList(trackInfoList.get(i++));
        List<String> locations = stringToList(trackInfoList.get(i++));

        return create(ids, names, albums, artists, trackNumbers, discNumbers, ratings, albumRatings, albumRatingKinds, locations);
    }

    private List<String> stringToList(Object stringValue) {
        return forcedListInterpreter.interpret((String) stringValue);
    }

    public FileTrackTO createFromSingleTrackInfo(List<Object> trackInfoList) {
        Iterator<Object> iterator = trackInfoList.iterator();

        String persistentId = (String) iterator.next();
        String name = (String) iterator.next();
        String album = (String) iterator.next();
        String artist = (String) iterator.next();
        String trackNumber = toString((Long) iterator.next());
        String discNumber = toString((Long) iterator.next());
        String rating = toString((Long) iterator.next());
        String albumRating = toString((Long) iterator.next());
        String albumRatingKind = (String) iterator.next();
        String location = (String) iterator.next();

        return new FileTrackTO(persistentId, name, album, artist, trackNumber, discNumber, rating, albumRating,
                albumRatingKind, location);
    }

    private List<FileTrackTO> create(List<String> ids, List<String> names, List<String> albums, List<String> artists,
            List<Long> trackNumbers, List<Long> discNumbers, List<Long> ratings, List<Long> albumRatings,
            List<String> albumRatingKinds, List<String> locations) {

        List<FileTrackTO> list = new ArrayList<FileTrackTO>();

        for (int j = 0; j < ids.size(); j++) {
            list.add(new FileTrackTO(stringInterpreter.interpret(ids.get(j)),
                    stringInterpreter.interpret(names.get(j)),
                    stringInterpreter.interpret(albums.get(j)),
                    stringInterpreter.interpret(artists.get(j)),
                    toString(trackNumbers.get(j)),
                    toString(discNumbers.get(j)),
                    toString(ratings.get(j)),
                    toString(albumRatings.get(j)),
                    stringInterpreter.interpret(albumRatingKinds.get(j)),
                    locations.get(j)));
        }

        return list;
    }

    private String toString(Long value) {
        return value == null ? "" : value.toString();
    }
}
