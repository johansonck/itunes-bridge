package be.sonck.itunes.bridge.impl.factory;

import be.sonck.itunes.bridge.BasicSpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import static java.util.Arrays.asList;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by johansonck on 27/02/16.
 */
public class TrackInfoListTransposerTest extends BasicSpringTest {

    @Autowired
    private TrackInfoListTransposer bean;

    @Test
    public void test() {
        String persistentId1 = "566EB371EEFB58A8";
        String name1 = "Bessie's Blues";
        String album1 = "Akoustic Band1";
        String artist1 = "Chick Corea1";
        long trackNumber1 = 1L;
        long discNumber1 = 3L;
        long rating1 = 0L;
        long albumRating1 = 40L;
        String albumRatingKind1 = "user";
        String location1 = "Macintosh HD 2:iTunes:iTunes Music:Music:Chick Corea:Akoustic Band:01 Bessie's Blues.mp3";
        String ratingKind1 = "computed";
        Object playedDate1 = GregorianCalendar.getInstance();

        String persistentId2 = "566EB371EEFB58A9";
        String name2 = "My One and Only Love";
        String album2 = "Akoustic Band2";
        String artist2 = "Chick Corea2";
        long trackNumber2 = 2L;
        long discNumber2 = 4L;
        long rating2 = 20L;
        long albumRating2 = 60L;
        String albumRatingKind2 = "computed";
        String location2 = "Macintosh HD 2:iTunes:iTunes Music:Music:Chick Corea:Akoustic Band:02 My One and Only Love.mp3";
        String ratingKind2 = "user";
        Object playedDate2 = randomAlphanumeric(10);

        List<Object> sourceList = new ArrayList<>();

        sourceList.add(asList(persistentId1, persistentId2));
        sourceList.add(asList(name1, name2));
        sourceList.add(asList(album1, album2));
        sourceList.add(asList(artist1, artist2));
        sourceList.add(asList(trackNumber1, trackNumber2)); // track number
        sourceList.add(asList(discNumber1, discNumber2)); // disc number
        sourceList.add(asList(rating1, rating2)); // ratings
        sourceList.add(asList(albumRating1, albumRating2)); // album ratings
        sourceList.add(concatenate(albumRatingKind1, albumRatingKind2));
        sourceList.add(concatenate(location1, location2));
        sourceList.add(concatenate(ratingKind1, ratingKind2));
        sourceList.add(asList(playedDate1, playedDate2));

        List<List<Object>> transposedList = bean.transpose(sourceList);

        Iterator<List<Object>> rowIterator = transposedList.iterator();

        assertTrue(rowIterator.hasNext());

        Iterator<Object> columnIterator = rowIterator.next().iterator();
        assertTrue(columnIterator.hasNext());
        assertThat(columnIterator.next()).isEqualTo(persistentId1);
        assertTrue(columnIterator.hasNext());
        assertThat(columnIterator.next()).isEqualTo(name1);
        assertTrue(columnIterator.hasNext());
        assertThat(columnIterator.next()).isEqualTo(album1);
        assertTrue(columnIterator.hasNext());
        assertThat(columnIterator.next()).isEqualTo(artist1);
        assertTrue(columnIterator.hasNext());
        assertThat(columnIterator.next()).isEqualTo(trackNumber1);
        assertTrue(columnIterator.hasNext());
        assertThat(columnIterator.next()).isEqualTo(discNumber1);
        assertTrue(columnIterator.hasNext());
        assertThat(columnIterator.next()).isEqualTo(rating1);
        assertTrue(columnIterator.hasNext());
        assertThat(columnIterator.next()).isEqualTo(albumRating1);
        assertTrue(columnIterator.hasNext());
        assertThat(columnIterator.next()).isEqualTo(albumRatingKind1);
        assertTrue(columnIterator.hasNext());
        assertThat(columnIterator.next()).isEqualTo(location1);
        assertTrue(columnIterator.hasNext());
        assertThat(columnIterator.next()).isEqualTo(ratingKind1);
        assertTrue(columnIterator.hasNext());
        assertThat(columnIterator.next()).isEqualTo(playedDate1);
        assertFalse(columnIterator.hasNext());

        assertTrue(rowIterator.hasNext());

        columnIterator = rowIterator.next().iterator();
        assertTrue(columnIterator.hasNext());
        assertThat(columnIterator.next()).isEqualTo(persistentId2);
        assertTrue(columnIterator.hasNext());
        assertThat(columnIterator.next()).isEqualTo(name2);
        assertTrue(columnIterator.hasNext());
        assertThat(columnIterator.next()).isEqualTo(album2);
        assertTrue(columnIterator.hasNext());
        assertThat(columnIterator.next()).isEqualTo(artist2);
        assertTrue(columnIterator.hasNext());
        assertThat(columnIterator.next()).isEqualTo(trackNumber2);
        assertTrue(columnIterator.hasNext());
        assertThat(columnIterator.next()).isEqualTo(discNumber2);
        assertTrue(columnIterator.hasNext());
        assertThat(columnIterator.next()).isEqualTo(rating2);
        assertTrue(columnIterator.hasNext());
        assertThat(columnIterator.next()).isEqualTo(albumRating2);
        assertTrue(columnIterator.hasNext());
        assertThat(columnIterator.next()).isEqualTo(albumRatingKind2);
        assertTrue(columnIterator.hasNext());
        assertThat(columnIterator.next()).isEqualTo(location2);
        assertTrue(columnIterator.hasNext());
        assertThat(columnIterator.next()).isEqualTo(ratingKind2);
        assertTrue(columnIterator.hasNext());
        assertThat(columnIterator.next()).isEqualTo(playedDate2);
        assertFalse(columnIterator.hasNext());

        assertFalse(rowIterator.hasNext());
    }

    private String concatenate(String value1, String value2) {
        return value1 + "|" + value2;
    }
}