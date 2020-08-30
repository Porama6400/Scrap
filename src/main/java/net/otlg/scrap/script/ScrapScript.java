package net.otlg.scrap.script;

import jdk.nashorn.api.scripting.NashornScriptEngine;
import jdk.nashorn.api.scripting.NashornScriptEngineFactory;
import net.otlg.scrap.Scrap;
import net.otlg.scrap.wrapper.JsonType;
import net.otlg.scrap.wrapper.ScrapDriver;
import net.otlg.scrap.wrapper.ScrapUtil;

import javax.script.CompiledScript;
import javax.script.ScriptException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ScrapScript {
    private final File file;
    private ScrapDriver driver = new ScrapDriver(this, Scrap.get());
    private NashornScriptEngine engine;
    private CompiledScript compiledScript;
    private ScrapClassFilter classFilter = new ScrapClassFilter();

    public ScrapScript(File file) {
        this.file = file;
        try (FileReader fileReader = new FileReader(file)) {

            NashornScriptEngineFactory factory = new NashornScriptEngineFactory();
            engine = (NashornScriptEngine) factory.getScriptEngine(new String[]{""}, this.getClass().getClassLoader(), classFilter);

            compiledScript = engine.compile(fileReader);
            init();

        } catch (IOException | ScriptException e) {
            e.printStackTrace();
        }
    }

    public File getFile() {
        return file;
    }

    public void eval(String script) {
        try {
            engine.eval(script);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

    public void init() {
        try {
            // Register interfaces
            engine.put("Scrap", driver);
            engine.put("Util", new ScrapUtil());
            engine.put("JsonType", JsonType.class);

            // Run initialization script
            String preloadScript = ScrapManager.loadInitScript(this.getClass());
            CompiledScript compiledInitScript = engine.compile(preloadScript);
            compiledInitScript.eval();
            classFilter.lock();

            // Remove dangerous builtins
            engine.put("quit", null);
            engine.put("exit", null);
            engine.put("Java", null);

            // Run user script
            compiledScript.eval();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public NashornScriptEngine getEngine() {
        return engine;
    }

    public CompiledScript getCompiledScript() {
        return compiledScript;
    }

    public void disable() {
        driver.close();
    }
}
