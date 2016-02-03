package be.sonck.itunes.impl.factory;

import be.sonck.itunes.impl.model.FileTrackTO;
import be.sonck.itunes.interpreter.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        String locationsString = (String) trackInfoList.get(i++);
        List<String> locations = forcedListInterpreter.interpret(locationsString);

        return create(ids, names, albums, artists, trackNumbers, discNumbers, ratings, locations);
    }

    private List<FileTrackTO> create(List<String> ids, List<String> names, List<String> albums, List<String> artists,
            List<Long> trackNumbers, List<Long> discNumbers, List<Long> ratings, List<String> locations) {

        List<FileTrackTO> list = new ArrayList<FileTrackTO>();

        for (int j = 0; j < ids.size(); j++) {
            list.add(new FileTrackTO(stringInterpreter.interpret(ids.get(j)),
                    stringInterpreter.interpret(names.get(j)),
                    stringInterpreter.interpret(albums.get(j)),
                    stringInterpreter.interpret(artists.get(j)),
                    toString(trackNumbers.get(j)),
                    toString(discNumbers.get(j)),
                    toString(ratings.get(j)),
                    locations.get(j)));
        }

        return list;
    }

    private String toString(Long value) {
        return value == null ? "" : value.toString();
    }
}
