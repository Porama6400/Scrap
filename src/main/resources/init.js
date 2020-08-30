/* ================================================================
                             INTERNAL
 ================================================================*/

var __scrap_eventList = {}

function __scrap_execEvent(name, event) {
    var handler = __scrap_eventList[name];
    if (handler === null || handler === undefined) return;
    handler(event);
}

/* ================================================================
                              API
 ================================================================*/
var ArrayList = Java.type("java.util.ArrayList");
var LinkedList = Java.type("java.util.LinkedList");
var HashMap = Java.type("java.util.HashMap");

var Location = Java.type("org.bukkit.Location");
var Vector = Java.type("org.bukkit.util.Vector");
var ChatColor = Java.type("org.bukkit.ChatColor");
var Material = Java.type("org.bukkit.Material");
var Biome = Java.type("org.bukkit.block.Biome");
var Particle = Java.type("org.bukkit.Particle");

var event = {
    on: function (name, func) {
        Scrap.enableEvent(name);
        __scrap_eventList[name] = func;
    }
}