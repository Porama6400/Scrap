package net.otlg.scrap.wrapper;

import javassist.CannotCompileException;
import javassist.NotFoundException;
import net.otlg.scrap.Scrap;
import net.otlg.scrap.proxy.ProxyCompiler;
import net.otlg.scrap.script.ScrapScript;
import net.otlg.scrap.script.SqliteManager;
import net.otlg.scrap.task.BukkitTaskClosableAdapter;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

import javax.script.ScriptException;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ScrapDriver {
    private final ScrapScript scrapScript;
    private final Scrap scrap;
    private List<AutoCloseable> closeableList = new LinkedList<>();

    public ScrapDriver(ScrapScript scrapScript, Scrap scrap) {
        this.scrapScript = scrapScript;
        this.scrap = scrap;
    }

    public boolean compile(String name) {
        try {
            ProxyCompiler.compile(Class.forName(name));
            return true;
        } catch (CannotCompileException | NotFoundException | NoSuchMethodException | ClassNotFoundException e) {
            return false;
        }
    }

    public boolean isClassExist(String name) {
        try {
            Class.forName(name);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public Connection getSqlite() throws SQLException {
        String URL = "jdbc:sqlite:" + new File(scrap.getDatabaseFolder(), scrapScript.getFile().getName().replaceAll("\\.js", "\\.db")).getAbsolutePath();

        Connection connection = DriverManager.getConnection(URL);
        closeableList.add(connection);
        return connection;
    }

    public SqliteManager getSqliteManager() throws SQLException {
        return new SqliteManager(getSqlite());
    }

    public void runTaskAsync(String functionName, Object... data) {
        Bukkit.getScheduler().runTaskAsynchronously(scrap, () -> {
            try {
                scrapScript.getEngine().invokeFunction(functionName, data);
            } catch (ScriptException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        });
    }

    public void runTask(String functionName, Object... data) {
        Bukkit.getScheduler().runTask(scrap, () -> {
            try {
                scrapScript.getEngine().invokeFunction(functionName, data);
            } catch (ScriptException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        });
    }

    public void submitSchedule(String functionName, long delay, long period, Object... data) {
        BukkitTask task = Bukkit.getScheduler().runTaskTimer(scrap, () -> {
            try {
                scrapScript.getEngine().invokeFunction(functionName, data);
            } catch (ScriptException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }, delay, period);

        closeableList.add(new BukkitTaskClosableAdapter(task));
    }

    public void enableEvent(String name) {
        scrap.getManager().enableEvent(name);
    }

    public void broadcastMessage(String message) {
        Bukkit.broadcastMessage(message);
    }

    public void broadcast(String message, String permission) {
        Bukkit.broadcast(message, permission);
    }

    public void close() {
        for (AutoCloseable closeable : closeableList) {
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
