package be.sonck.itunes.impl.service;

import org.apache.commons.io.IOUtils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by johansonck on 06/12/15.
 */
public class ClasspathAppleScriptExecutor {

    private static final String SCRIPT_ENGINE = "AppleScriptEngine";
    private AppleScriptParser appleScriptParser = new AppleScriptParser();


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
        ScriptEngineManager manager = new ScriptEngineManager();
        List<ScriptEngineFactory> factories = manager.getEngineFactories();
        for (ScriptEngineFactory factory : factories) {
            if (factory.getEngineName().indexOf(SCRIPT_ENGINE) != -1) {
                return factory.getScriptEngine();
            }
        }

        throw new IllegalStateException("script engine \"" + SCRIPT_ENGINE + "\" not found");
    }

    private String getScriptContents(String scriptName) {
        try {
            return IOUtils.toString(getResourceAsStream(scriptName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private InputStream getResourceAsStream(String scriptName) {
        InputStream inputStream = getClass().getResourceAsStream("/scripts/" + scriptName);
        if (inputStream == null) {
            throw new IllegalArgumentException("resource '/scripts/" + scriptName + "' could not be found");
        }
        return inputStream;
    }
}
