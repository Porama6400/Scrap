package net.otlg.scrap;

import net.otlg.scrap.logger.ScrapVolatileLogger;
import net.otlg.scrap.proxy.ProxyCompiler;
import net.otlg.scrap.script.ScrapManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Scrap extends JavaPlugin {
    private static Scrap instance;
    private ScrapManager manager = new ScrapManager(this);
    private ScrapEventListener eventListener = new ScrapEventListener(this, manager);
    private File scriptFolder;
    private File databaseFolder;

    public static Scrap get() {
        return instance;
    }

    public File getDatabaseFolder() {
        return databaseFolder;
    }

    @Override
    public void onLoad() {
        instance = this;

        ProxyCompiler.setClassLoader(this.getClassLoader());

        scriptFolder = new File(getDataFolder(), "script");
        scriptFolder.mkdirs();
        databaseFolder = new File(getDataFolder(), "db");
        databaseFolder.mkdirs();
        {
            File compilerLogFile = new File(getDataFolder(), "compiler.log.txt");
            File apiLogFile = new File(getDataFolder(), "api.txt");

            ScrapVolatileLogger compilerLogger = new ScrapVolatileLogger(compilerLogFile);
            ProxyCompiler.setLogger(compilerLogger);

            ScrapVolatileLogger apiLogger = new ScrapVolatileLogger(apiLogFile);
            ProxyCompiler.setApiLogger(apiLogger);
        }
    }

    @Override
    public void onEnable() {
        ScrapCommand command = new ScrapCommand();
        getCommand("scrap").setExecutor(command);
        getCommand("scrap").setTabCompleter(command);

        Bukkit.getPluginManager().registerEvents(eventListener, this);

        manager.loadFolder(scriptFolder);
    }

    @Override
    public void onDisable() {
        manager.disableAll();
    }

    public ScrapManager getManager() {
        return manager;
    }

    public ScrapEventListener getEventListener() {
        return eventListener;
    }

    public File getScriptFolder() {
        return scriptFolder;
    }
}
