package be.sonck.itunes.bridge.impl.executor;

import be.sonck.itunes.bridge.BasicSpringTest;
import be.sonck.itunes.bridge.impl.service.Scripts;
import org.fest.assertions.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
import java.util.List;

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

        Assert.assertTrue(iterator.hasNext());
        Assertions.assertThat(iterator.next()).isEqualTo("566EB371EEFB5DA7");
        Assert.assertTrue(iterator.hasNext());
        Assertions.assertThat(iterator.next()).isEqualTo("When Doves Cry");
        Assert.assertTrue(iterator.hasNext());
        Assertions.assertThat(iterator.next()).isEqualTo("Purple Rain");
        Assert.assertTrue(iterator.hasNext());
        Assertions.assertThat(iterator.next()).isEqualTo("Prince & The Revolution");
        Assert.assertTrue(iterator.hasNext());
        Assertions.assertThat(iterator.next()).isEqualTo(Long.valueOf(6));
        Assert.assertTrue(iterator.hasNext());
        Assertions.assertThat(iterator.next()).isEqualTo(Long.valueOf(0));
        Assert.assertTrue(iterator.hasNext());
        Assertions.assertThat(iterator.next()).isEqualTo(Long.valueOf(100));
        Assert.assertTrue(iterator.hasNext());
        Assertions.assertThat(iterator.next()).isEqualTo(Long.valueOf(80));
        Assert.assertTrue(iterator.hasNext());
        Assertions.assertThat(iterator.next()).isEqualTo("computed");
        Assert.assertTrue(iterator.hasNext());
        Assertions.assertThat(iterator.next()).isEqualTo("Macintosh HD 2:iTunes:iTunes Music:Music:Prince:Purple Rain:06 When Doves Cry.mp3");
        Assert.assertFalse(iterator.hasNext());
    }
}