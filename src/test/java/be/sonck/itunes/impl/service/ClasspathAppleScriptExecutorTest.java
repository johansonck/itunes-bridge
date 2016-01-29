package be.sonck.itunes.impl.service;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by johansonck on 27/12/15.
 */
public class ClasspathAppleScriptExecutorTest {

    @Test
    public void test() {
        Object result = executor().execute("getTrackInfo.applescript", "When Doves Cry", "Purple Rain", "Prince & The Revolution");
        System.out.println(result);

        assertThat(result, is("{\"566EB371EEFB5DA7\", \"When Doves Cry\", \"Purple Rain\", \"Prince & The Revolution\", 6, 0, 100}"));
    }

    @Test
    public void getAllPlaylists() {
        Object result = executor().execute(Scripts.GET_ALL_PLAYLISTS);
        System.out.println(result);
    }

    private ClasspathAppleScriptExecutor executor() {
        return new ClasspathAppleScriptExecutor();
    }
}