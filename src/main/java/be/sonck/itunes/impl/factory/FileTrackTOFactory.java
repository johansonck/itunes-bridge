package be.sonck.itunes.impl.factory;

import be.sonck.itunes.impl.model.FileTrackTO;
import be.sonck.itunes.interpreter.*;

import java.util.ArrayList;
import java.util.List;

public class FileTrackTOFactory {

    private ListInterpreter listInterpreter = new ListInterpreter();
    private StringListInterpreter stringListInterpreter = new StringListInterpreter();
    private StringInterpreter stringInterpreter = new StringInterpreter();
    private AliasInterpreter aliasInterpreter = new AliasInterpreter();
    private ForcedListInterpreter forcedListInterpreter = new ForcedListInterpreter();


    public List<FileTrackTO> createList(String tracks) {
        List<FileTrackTO> list = new ArrayList<FileTrackTO>();

        List<String> entries = listInterpreter.interpret(tracks);
        for (String entry : entries) {
            list.add(create(stringListInterpreter.interpret(entry)));
        }

        return list;
    }

    public List<FileTrackTO> createFromTrackInfos(List<?> trackInfoList) {
        int i = 0;

        List<String> ids = (List<String>) trackInfoList.get(i++);
        List<String> names = (List<String>) trackInfoList.get(i++);
        List<String> albums = (List<String>) trackInfoList.get(i++);
        List<String> artists = (List<String>) trackInfoList.get(i++);
        List<Long> trackNumbers = (List<Long>) trackInfoList.get(i++);
        List<Long> discNumbers = (List<Long>) trackInfoList.get(i++);

        String locationsString = (String) trackInfoList.get(i++);
        List<String> locations = forcedListInterpreter.interpret(locationsString);

        return create(ids, names, albums, artists, trackNumbers, discNumbers, locations);
    }

    private List<FileTrackTO> create(List<String> ids, List<String> names, List<String> albums, List<String> artists,
                                     List<Long> trackNumbers, List<Long> discNumbers, List<String> locations) {

        List<FileTrackTO> list = new ArrayList<FileTrackTO>();

        for (int j = 0; j < ids.size(); j++) {
            list.add(new FileTrackTO(stringInterpreter.interpret(ids.get(j)),
                    stringInterpreter.interpret(names.get(j)),
                    stringInterpreter.interpret(albums.get(j)),
                    stringInterpreter.interpret(artists.get(j)),
                    toString(trackNumbers.get(j)),
                    toString(discNumbers.get(j)),
                    locations.get(j)));
        }

        return list;
    }

    private String toString(Long value) {
        return value == null ? "" : value.toString();
    }

    private FileTrackTO create(List<String> list) {
        int i = 0;

        String id = list.get(i++);
        String name = list.get(i++);
        String album = list.get(i++);
        String artist = list.get(i++);
        String trackNumber = list.get(i++);
        String discNumber = list.get(i++);
        String location = list.get(i++);

        return new FileTrackTO(id, name, album, artist, trackNumber, discNumber, location);
    }
}
