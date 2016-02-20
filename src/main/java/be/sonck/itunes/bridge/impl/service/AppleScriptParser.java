package be.sonck.itunes.bridge.impl.service;

import org.springframework.stereotype.Service;

/**
 * Created by johansonck on 27/12/15.
 */
@Service
public class AppleScriptParser {

    public String parseScript(String script, String... args) {
        if (script == null || args.length == 0) return script;

        String parsedScript = script;

        for (int i = 1; i <= args.length; i++) {
            String value = args[i - 1];

            String target = "item " + i + " of argv";
            String replacement = "\"" + value.replace("\"", "\\\"") + "\"";

            parsedScript = parsedScript.replace(target, replacement);
        }

        return parsedScript;
    }
}
