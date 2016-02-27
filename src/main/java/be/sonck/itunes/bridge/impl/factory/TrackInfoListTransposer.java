package be.sonck.itunes.bridge.impl.factory;

import be.sonck.itunes.bridge.interpreter.ForcedListInterpreter;
import be.sonck.itunes.bridge.interpreter.StringInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by johansonck on 27/02/16.
 */
@Service
public class TrackInfoListTransposer {

    @Autowired
    private StringInterpreter stringInterpreter;

    @Autowired
    private ForcedListInterpreter forcedListInterpreter;


    @SuppressWarnings("unchecked")
    public List<List<Object>> transpose(List<?> source) {
        int i = 0;

        List<String> peristendIds     = (List<String>) source.get(i++);
        List<String> names            = (List<String>) source.get(i++);
        List<String> albums           = (List<String>) source.get(i++);
        List<String> artists          = (List<String>) source.get(i++);
        List<Long>   trackNumbers     = (List<Long>)   source.get(i++);
        List<Long>   discNumbers      = (List<Long>)   source.get(i++);
        List<Long>   ratings          = (List<Long>)   source.get(i++);
        List<Long>   albumRatings     = (List<Long>)   source.get(i++);
        List<String> albumRatingKinds = stringToList(source.get(i++));
        List<String> locations        = stringToList(source.get(i++));
        List<String> ratingKinds      = stringToList(source.get(i++));
        List<Object> playedDates      = (List<Object>) source.get(i++);

        List<List<Object>> transposedList = new ArrayList<>();

        for (int j = 0; j < peristendIds.size(); j++) {
            String persistentId    = stringInterpreter.interpret(peristendIds.get(j));
            String name            = stringInterpreter.interpret(names.get(j));
            String album           = stringInterpreter.interpret(albums.get(j));
            String artist          = stringInterpreter.interpret(artists.get(j));
            Long trackNumber       = trackNumbers.get(j);
            Long discNumber        = discNumbers.get(j);
            Long rating            = ratings.get(j);
            String ratingKind      = stringInterpreter.interpret(ratingKinds.get(j));
            Long albumRating       = albumRatings.get(j);
            String albumRatingKind = stringInterpreter.interpret(albumRatingKinds.get(j));
            String location        = locations.get(j);
            Object playedDate      = playedDates.get(j);

            transposedList.add(asList(
                    persistentId,
                    name,
                    album,
                    artist,
                    trackNumber,
                    discNumber,
                    rating,
                    albumRating,
                    albumRatingKind,
                    location,
                    ratingKind,
                    playedDate
            ));
        }

        return transposedList;
    }

    private List<String> stringToList(Object stringValue) {
        return forcedListInterpreter.interpret((String) stringValue);
    }
}
