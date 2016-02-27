package be.sonck.itunes.bridge.impl.factory;

import be.sonck.itunes.bridge.impl.model.FileTrackTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

@Service
public class FileTrackTOFactory {

    @Autowired
    private TrackInfoListTransposer trackInfoListTransposer;


    @SuppressWarnings("unchecked")
    public List<FileTrackTO> createFromTrackInfos(List<?> trackInfoList) {
        List<FileTrackTO> fileTrackTOs = new ArrayList<>();

        List<List<Object>> transposedList = trackInfoListTransposer.transpose(trackInfoList);
        for (List<Object> trackInfo : transposedList) {
            fileTrackTOs.add(createFromSingleTrackInfo(trackInfo));
        }

        return fileTrackTOs;
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
        String ratingKind = (String) iterator.next();
        Calendar playedDate = toCalendar(iterator.next());

        return FileTrackTO.newBuilder()
                .persistentId(persistentId)
                .name(name)
                .album(album)
                .artist(artist)
                .trackNumber(trackNumber)
                .discNumber(discNumber)
                .rating(rating)
                .ratingKind(ratingKind)
                .albumRating(albumRating)
                .albumRatingKind(albumRatingKind)
                .location(location)
                .playedDate(playedDate)
                .build();
    }

    private Calendar toCalendar(Object object) {
        return object instanceof Calendar ? (Calendar) object : null;
    }

    private String toString(Long value) {
        return value == null ? "" : value.toString();
    }
}
