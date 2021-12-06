package global.minecraft;

import org.bukkit.plugin.java.JavaPlugin;

public class XenonMinecraftPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        CustomRecipes.registerRecipes(this);
    }

    @Override
    public void onDisable() {
        CustomRecipes.unregisterRecipes(this);
    }
}
