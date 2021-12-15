package me.iapetus11;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomRecipes {
    private static String[] recipeKeys = {"smelt_rotten_flesh", "craft_wool_to_string"};

    public static void registerRecipes(JavaPlugin plugin) {
        var server = plugin.getServer();

        var smeltRottenFlesh = new FurnaceRecipe(
                new NamespacedKey(plugin, "smelt_rotten_flesh"),
                new ItemStack(Material.LEATHER),
                Material.ROTTEN_FLESH,
                0.25f,
                20);

        var craftWoolToString = new ShapelessRecipe(
                new NamespacedKey(plugin, "craft_wool_to_string"),
                new ItemStack(Material.STRING, 4));
        craftWoolToString.addIngredient(Material.WHITE_WOOL);

        server.addRecipe(smeltRottenFlesh);
        server.addRecipe(craftWoolToString);
    }

    public static void unregisterRecipes(JavaPlugin plugin) {
        var server = plugin.getServer();

        for (String key : recipeKeys) {
            server.removeRecipe(new NamespacedKey(plugin, key));
        }
    }
}
