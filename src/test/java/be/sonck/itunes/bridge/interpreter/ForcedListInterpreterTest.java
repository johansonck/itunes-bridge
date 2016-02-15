package be.sonck.itunes.bridge.interpreter;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.matchers.JUnitMatchers;

import java.util.List;

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

        Assert.assertThat(result, JUnitMatchers.hasItem("1"));
        Assert.assertThat(result.size(), CoreMatchers.is(1));
    }

    private void validate(String input) {
        List<String> result = new ForcedListInterpreter().interpret(input);

        Assert.assertThat(result, JUnitMatchers.hasItem("1"));
        Assert.assertThat(result, JUnitMatchers.hasItem("2"));
        Assert.assertThat(result, JUnitMatchers.hasItem("3"));
        Assert.assertThat(result.size(), CoreMatchers.is(3));
    }
}