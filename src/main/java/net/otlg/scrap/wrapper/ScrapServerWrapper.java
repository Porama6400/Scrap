package net.otlg.scrap.wrapper;

import net.otlg.scrap.proxy.ProxyCompiler;
import org.bukkit.Bukkit;
import org.bukkit.Server;

import java.util.UUID;

public class ScrapServerWrapper {
    private final Server server = Bukkit.getServer();

    public Object getPlayer(String name) {
        return ProxyCompiler.construct(server.getPlayer(name));
    }

    public Object getPlayer(UUID uuid) {
        return ProxyCompiler.construct(server.getPlayer(uuid));
    }
}
