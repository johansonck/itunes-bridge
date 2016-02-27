package be.sonck.itunes.bridge.impl.executor;

import be.sonck.itunes.bridge.BasicSpringTest;
import be.sonck.itunes.bridge.impl.service.Scripts;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by johansonck on 27/12/15.
 */
public class ClasspathAppleScriptExecutorTest extends BasicSpringTest {

    @Autowired
    private ClasspathAppleScriptExecutor executor;

    @Test
    public void test() {
        List<Object> result = (List<Object>) executor.execute(Scripts.GET_TRACK, "When Doves Cry", "Purple Rain", "Prince & The Revolution");

        Iterator<Object> iterator = result.iterator();

        assertTrue(iterator.hasNext());
        assertThat(iterator.next()).isEqualTo("566EB371EEFB5DA7");
        assertTrue(iterator.hasNext());
        assertThat(iterator.next()).isEqualTo("When Doves Cry");
        assertTrue(iterator.hasNext());
        assertThat(iterator.next()).isEqualTo("Purple Rain");
        assertTrue(iterator.hasNext());
        assertThat(iterator.next()).isEqualTo("Prince & The Revolution");
        assertTrue(iterator.hasNext());
        assertThat(iterator.next()).isEqualTo(6L);
        assertTrue(iterator.hasNext());
        assertThat(iterator.next()).isEqualTo(0L);
        assertTrue(iterator.hasNext());
        assertThat(iterator.next()).isEqualTo(100L);
        assertTrue(iterator.hasNext());
        assertThat(iterator.next()).isEqualTo(80L);
        assertTrue(iterator.hasNext());
        assertThat(iterator.next()).isEqualTo("computed");
        assertTrue(iterator.hasNext());
        assertThat(iterator.next()).isEqualTo("Macintosh HD 2:iTunes:iTunes Music:Music:Prince:Purple Rain:06 When Doves Cry.mp3");
        assertTrue(iterator.hasNext());
        assertThat(iterator.next()).isEqualTo("user");
        assertTrue(iterator.hasNext());
        assertThat(iterator.next()).isInstanceOf(Calendar.class);
        assertFalse(iterator.hasNext());
    }
}