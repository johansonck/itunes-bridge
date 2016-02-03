package be.sonck.itunes.impl.factory;

import be.sonck.itunes.BasicSpringTest;
import be.sonck.itunes.impl.model.FileTrackTO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.unitils.reflectionassert.ReflectionAssert;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class FileTrackTOFactoryTest extends BasicSpringTest {

    @Autowired
    private FileTrackTOFactory factory;

    @Test
    public void test() {
        List<Object> trackInfoList = new ArrayList<>();

        trackInfoList.add(asList("566EB371EEFB58A8", "566EB371EEFB58A9"));
        trackInfoList.add(asList("Bessie's Blues", "My One and Only Love"));
        trackInfoList.add(asList("Akoustic Band1", "Akoustic Band2"));
        trackInfoList.add(asList("Chick Corea1", "Chick Corea2"));
        trackInfoList.add(asList(Long.valueOf(1), Long.valueOf(2))); // track number
        trackInfoList.add(asList(Long.valueOf(3), Long.valueOf(4))); // disc number
        trackInfoList.add(asList(Long.valueOf(0), Long.valueOf(20))); // ratings
        trackInfoList.add("Macintosh HD 2:iTunes:iTunes Music:Music:Chick Corea:Akoustic Band:01 Bessie's Blues.mp3" +
                "|Macintosh HD 2:iTunes:iTunes Music:Music:Chick Corea:Akoustic Band:02 My One and Only Love.mp3");

        List<FileTrackTO> fileTrackTOs = factory.createFromTrackInfos(trackInfoList);

        validate(findTrack(fileTrackTOs, "566EB371EEFB58A8"),
                new FileTrackTO("566EB371EEFB58A8", "Bessie's Blues", "Akoustic Band1", "Chick Corea1", "1", "3", "0",
                        "Macintosh HD 2:iTunes:iTunes Music:Music:Chick Corea:Akoustic Band:01 Bessie's Blues.mp3"));

        validate(findTrack(fileTrackTOs, "566EB371EEFB58A9"),
                new FileTrackTO("566EB371EEFB58A9", "My One and Only Love", "Akoustic Band2", "Chick Corea2", "2", "4", "20",
                        "Macintosh HD 2:iTunes:iTunes Music:Music:Chick Corea:Akoustic Band:02 My One and Only Love.mp3"));
    }

    private void validate(FileTrackTO actual, FileTrackTO expected) {
        ReflectionAssert.assertReflectionEquals(expected, actual);
    }

    private FileTrackTO findTrack(List<FileTrackTO> list, String id) {
		for (FileTrackTO track : list) {
			if (id.equals(track.getPersistentId())) { return track; }
		}
		
		Assert.fail("no track found with id '" + id + "'");
		return null;
	}
}
