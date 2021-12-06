package global.minecraft;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomRecipes {
    public static void registerRecipes(JavaPlugin plugin) {
        var server = plugin.getServer();
        var smeltRottenFlesh = new FurnaceRecipe(
                new NamespacedKey(plugin, "smelt_rotten_flesh"),
                new ItemStack(Material.LEATHER),
                Material.ROTTEN_FLESH,
                0.0f,
                15);

        server.addRecipe(smeltRottenFlesh);
    }

    public static void unregisterRecipes(JavaPlugin plugin) {
        var server = plugin.getServer();
        server.removeRecipe(new NamespacedKey(plugin, "smelt_rotten_flesh"));
    }
}