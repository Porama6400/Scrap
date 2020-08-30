package net.otlg.scrap.script;

import net.otlg.scrap.Scrap;
import net.otlg.scrap.proxy.ProxyCompiler;
import org.bukkit.event.Event;

import javax.script.ScriptException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class ScrapManager {


    private final Scrap scrap;
    private Map<String, ScrapScript> scripts = new HashMap<>();
    private HashMap<String, Object> enabledEventMap = new HashMap<>();

    public ScrapManager(Scrap scrap) {
        this.scrap = scrap;
    }

    public static String loadInitScript(Class aClass) throws IOException {
        InputStream stream = aClass.getResourceAsStream("/init.js");
        if (stream == null) return null;
        byte[] bytes = new byte[stream.available()];
        stream.read(bytes);
        return new String(bytes, StandardCharsets.UTF_8);
    }

    public Map<String, ScrapScript> getScripts() {
        return scripts;
    }

    public void loadFolder(File folder) {
        for (File file : folder.listFiles()) {
            String name = file.getName();
            if (!name.endsWith(".js")) continue;
            load(file.getAbsoluteFile());
        }
    }

    public void load(File file) {
        System.out.println("Loading " + file.getName());
        scripts.put(file.getName(), new ScrapScript(file));
    }

    public void handleEvent(String name, Event event) {
        if (!enabledEventMap.containsKey(name)) return;
        Object proxiedEvent = ProxyCompiler.construct(event);
        for (ScrapScript scrapScript : scripts.values()) {
            try {
                scrapScript.getEngine().invokeFunction("__scrap_execEvent", name, proxiedEvent);
            } catch (ScriptException | NoSuchMethodException e) {
                System.err.println("Failed to execute event " + name);
                e.printStackTrace();
            }
        }
    }

    public void enableEvent(String name) {
        enabledEventMap.put(name, null);
    }

    public boolean disable(String name) {
        ScrapScript script = scripts.get(name);
        if (script == null) return false;
        script.disable();
        return true;
    }


    public void disableAll() {
        for (ScrapScript value : scripts.values()) {
            value.disable();
        }
    }
}
