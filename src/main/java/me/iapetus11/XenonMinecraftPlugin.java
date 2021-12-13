package me.iapetus11;

import org.bukkit.plugin.java.JavaPlugin;

public class XenonMinecraftPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        CustomRecipes.registerRecipes(this);

        getCommand("shrug").setExecutor(new ShrugCommand());
    }

    @Override
    public void onDisable() {
        CustomRecipes.unregisterRecipes(this);
    }
}
