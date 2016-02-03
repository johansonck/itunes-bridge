package be.sonck.itunes.impl.executor;

import be.sonck.itunes.impl.service.AppleScriptParser;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by johansonck on 06/12/15.
 */
@Service
public class ClasspathAppleScriptExecutor {

    private static final String SCRIPT_ENGINE = "AppleScriptEngine";

    @Autowired
    private AppleScriptParser appleScriptParser;

    private ScriptEngine scriptEngine;


    public Object execute(String scriptName, String... args) {
        String unparsedScript = getScriptContents(scriptName);
        String script = appleScriptParser.parseScript(unparsedScript, args);
        return executeScript(script);
    }

    private Object executeScript(String script) {
        try {
            return getScriptEngine().eval(script);

        } catch (ScriptException ex) {
            throw new RuntimeException(ex);
        }
    }

    private ScriptEngine getScriptEngine() {
        if (scriptEngine == null) {
            scriptEngine = findScriptEngine();
        }

        return scriptEngine;
    }

    private ScriptEngine findScriptEngine() {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName(SCRIPT_ENGINE);
        if (engine == null) {
            throw new IllegalStateException("script engine '" + SCRIPT_ENGINE + "' not found");
        }

        return engine;
    }

    private String getScriptContents(String scriptName) {
        try {
            return IOUtils.toString(getResourceAsStream("/scripts/" + scriptName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private InputStream getResourceAsStream(String scriptName) {
        InputStream inputStream = getClass().getResourceAsStream(scriptName);
        if (inputStream == null) {
            throw new IllegalArgumentException("resource '" + scriptName + "' not found");
        }
        return inputStream;
    }
}
