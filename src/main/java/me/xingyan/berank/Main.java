package me.xingyan.berank;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("berank").setExecutor(new berank());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
