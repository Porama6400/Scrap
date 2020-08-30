package net.otlg.scrap;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.util.List;

public class ScrapCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Scrap scrap = Scrap.get();

        if (args.length > 0) {

            String arg0 = args[0];

            switch (arg0.toLowerCase()) {
                case "reload":
                    if (args.length > 1) {
                        String arg1 = args[1];
                        if (scrap.getManager().disable(arg1)) {
                            scrap.getManager().load(new File(scrap.getScriptFolder(), arg1));
                            sender.sendMessage(ChatColor.GREEN + "Reloaded " + arg1);
                        } else {
                            sender.sendMessage(ChatColor.RED + "Failed to disable " + arg1);
                        }
                    } else {
                        scrap.getManager().disableAll();
                        scrap.getManager().loadFolder(scrap.getScriptFolder());
                        sender.sendMessage(ChatColor.GREEN + "Reloaded all scripts");
                    }
                    break;
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }
}
