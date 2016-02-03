package be.sonck.itunes.impl.executor;

import be.sonck.itunes.BasicSpringTest;
import be.sonck.itunes.impl.service.Scripts;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
//        List<Object> result = (List<Object>) executor.execute(Scripts.GET_TRACK, "Feline", "Rehearsal Summer 1984", "Prince & The Revolution");
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
        assertThat(iterator.next()).isEqualTo(Long.valueOf(6));
        assertTrue(iterator.hasNext());
        assertThat(iterator.next()).isEqualTo(Long.valueOf(0));
        assertTrue(iterator.hasNext());
        assertThat(iterator.next()).isEqualTo(Long.valueOf(100));
        assertTrue(iterator.hasNext());
        assertThat(iterator.next()).isEqualTo(Long.valueOf(80));
        assertTrue(iterator.hasNext());
        assertThat(iterator.next()).isEqualTo("computed");
        assertTrue(iterator.hasNext());
        assertThat(iterator.next()).isEqualTo("Macintosh HD 2:iTunes:iTunes Music:Music:Prince:Purple Rain:06 When Doves Cry.mp3");
        assertFalse(iterator.hasNext());
    }
}