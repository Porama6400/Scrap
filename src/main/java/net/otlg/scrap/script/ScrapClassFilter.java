package net.otlg.scrap.script;

import jdk.nashorn.api.scripting.ClassFilter;

public class ScrapClassFilter implements ClassFilter {
    private boolean locked;

    @Override
    public boolean exposeToScripts(String path) {
        if (locked) {
            System.out.println("Denied access to " + path);
            return false;
        }

        switch (path) {
            case "java.lang.String":
            case "java.lang.Integer":
            case "java.lang.Double":
            case "java.lang.Long":

            case "org.bukkit.Location":
            case "org.bukkit.util.Vector":

            case "org.bukkit.ChatColor":
            case "org.bukkit.Material":
            case "org.bukkit.block.Biome":
            case "org.bukkit.Particle":

            case "java.util.ArrayList":
            case "java.util.LinkedList":
            case "java.util.HashMap":

                System.out.println("Allowed access to " + path);
                return true;
        }

//        System.out.println("Denied access to " + path);
//        return false;

        System.out.println("Allowed access to " + path);
        return true;
    }

    public void lock() {
        this.locked = true;
    }
}
