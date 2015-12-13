package be.sonck.itunes.impl.service;

import be.sonck.applescript.AppleScriptException;
import be.sonck.applescript.AppleScriptExecutor;

/**
 * Created by johansonck on 06/12/15.
 */
public class AppleScriptExecutorClasspathAdapter {

    private ScriptCopier scriptCopier = new ScriptCopier();
    private AppleScriptExecutor executor = new AppleScriptExecutor();


    public String execute(String scriptName, String... args) {
        try {
            return executor.execute(scriptCopier.copyScript(scriptName), args).trim();

        } catch (AppleScriptException e) {
            throw new RuntimeException(e);
        }
    }
}
