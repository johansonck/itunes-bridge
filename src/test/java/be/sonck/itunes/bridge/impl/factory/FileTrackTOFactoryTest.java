package be.sonck.itunes.bridge.impl.factory;

import be.sonck.itunes.bridge.BasicSpringTest;
import be.sonck.itunes.bridge.impl.model.FileTrackTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.fail;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class FileTrackTOFactoryTest extends BasicSpringTest {

    @Autowired
    private FileTrackTOFactory factory;

    @Test
    public void test() {
        Calendar currentTime = GregorianCalendar.getInstance();

        List<Object> trackInfoList = new ArrayList<>();

        trackInfoList.add(asList("566EB371EEFB58A8", "566EB371EEFB58A9"));
        trackInfoList.add(asList("Bessie's Blues", "My One and Only Love"));
        trackInfoList.add(asList("Akoustic Band1", "Akoustic Band2"));
        trackInfoList.add(asList("Chick Corea1", "Chick Corea2"));
        trackInfoList.add(asList(1L, 2L)); // track number
        trackInfoList.add(asList(3L, 4L)); // disc number
        trackInfoList.add(asList(0L, 20L)); // ratings
        trackInfoList.add(asList(40L, 60L)); // album ratings
        trackInfoList.add("user|computed");
        trackInfoList.add("Macintosh HD 2:iTunes:iTunes Music:Music:Chick Corea:Akoustic Band:01 Bessie's Blues.mp3" +
                "|Macintosh HD 2:iTunes:iTunes Music:Music:Chick Corea:Akoustic Band:02 My One and Only Love.mp3");
        trackInfoList.add("computed|user");
        trackInfoList.add(asList(currentTime, "blah"));

        List<FileTrackTO> fileTrackTOs = factory.createFromTrackInfos(trackInfoList);

        validate(findTrack(fileTrackTOs, "566EB371EEFB58A8"),
                FileTrackTO.newBuilder()
                        .persistentId("566EB371EEFB58A8")
                        .name("Bessie's Blues")
                        .album("Akoustic Band1")
                        .artist("Chick Corea1")
                        .trackNumber("1")
                        .discNumber("3")
                        .rating("0")
                        .ratingKind("computed")
                        .albumRating("40")
                        .albumRatingKind("user")
                        .location("Macintosh HD 2:iTunes:iTunes Music:Music:Chick Corea:Akoustic Band:01 Bessie's Blues.mp3")
                        .playedDate(currentTime)
                        .build());

        validate(findTrack(fileTrackTOs, "566EB371EEFB58A9"),
                FileTrackTO.newBuilder()
                        .persistentId("566EB371EEFB58A9")
                        .name("My One and Only Love")
                        .album("Akoustic Band2")
                        .artist("Chick Corea2")
                        .trackNumber("2")
                        .discNumber("4")
                        .rating("20")
                        .ratingKind("user")
                        .albumRating("60")
                        .albumRatingKind("computed")
                        .location("Macintosh HD 2:iTunes:iTunes Music:Music:Chick Corea:Akoustic Band:02 My One and Only Love.mp3")
                        .build());
    }

    private void validate(FileTrackTO actual, FileTrackTO expected) {
        assertReflectionEquals(expected, actual);
    }

    private FileTrackTO findTrack(List<FileTrackTO> list, String id) {
        for (FileTrackTO track : list) {
            if (id.equals(track.getPersistentId())) {
                return track;
            }
        }

        fail("no track found with id '" + id + "'");
        return null;
    }
}
