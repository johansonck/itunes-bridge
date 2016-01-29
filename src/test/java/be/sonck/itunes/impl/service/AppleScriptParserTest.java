package be.sonck.itunes.impl.service;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by johansonck on 27/12/15.
 */
public class AppleScriptParserTest {

    @Test
    public void parseScript() {
        String artist = "Prince & The Revolution";
        String album = "Purple Rain";
        String name = "When Doves Cry";

        String script = new AppleScriptParser().parseScript("some track whose name is item 1 of argv and album is item 2 of argv and artist is item 3 of argv",
                name, album, artist);

        assertThat(script, is("some track whose name is \"" + name + "\" and album is \"" + album + "\" and artist is \"" + artist + "\""));
    }
}