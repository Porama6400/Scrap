package net.otlg.scrap.task;

import org.bukkit.scheduler.BukkitTask;

public class BukkitTaskClosableAdapter implements AutoCloseable {
    private final BukkitTask task;

    public BukkitTaskClosableAdapter(BukkitTask task) {
        this.task = task;
    }

    public BukkitTask getTask() {
        return task;
    }

    @Override
    public void close() throws Exception {
        if (!task.isCancelled()) task.cancel();
    }
}
