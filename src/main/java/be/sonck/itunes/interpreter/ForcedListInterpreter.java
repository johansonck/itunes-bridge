package be.sonck.itunes.interpreter;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by johansonck on 28/12/15.
 */
public class ForcedListInterpreter implements Interpreter<List<String>> {

    private static final String SEPARATOR = "\\|";

    @Override
    public List<String> interpret(String string) {
        if (string == null) return null;

        String[] split = string.split(SEPARATOR);

        return asList(split);
    }
}
