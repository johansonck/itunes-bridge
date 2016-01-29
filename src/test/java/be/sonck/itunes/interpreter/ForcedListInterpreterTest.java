package be.sonck.itunes.interpreter;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItem;

/**
 * Created by johansonck on 28/12/15.
 */
public class ForcedListInterpreterTest {

    @Test
    public void normalInput() {
        validate("1|2|3");
    }

    @Test
    public void endsWithSeparator() {
        validate("1|2|3|");
    }

    @Test
    public void noSeparator() {
        List<String> result = new ForcedListInterpreter().interpret("1");

        assertThat(result, hasItem("1"));
        assertThat(result.size(), is(1));
    }

    private void validate(String input) {
        List<String> result = new ForcedListInterpreter().interpret(input);

        assertThat(result, hasItem("1"));
        assertThat(result, hasItem("2"));
        assertThat(result, hasItem("3"));
        assertThat(result.size(), is(3));
    }
}