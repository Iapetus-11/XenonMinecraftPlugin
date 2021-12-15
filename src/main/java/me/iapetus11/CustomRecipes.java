package me.iapetus11;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomRecipes {
    private static final Material[] woodenSlabMaterials = new Material[]{
            Material.ACACIA_SLAB, Material.BIRCH_SLAB, Material.CRIMSON_SLAB, Material.OAK_SLAB,
            Material.DARK_OAK_SLAB, Material.JUNGLE_SLAB, Material.SPRUCE_SLAB, Material.WARPED_SLAB};

    public static void registerRecipes(JavaPlugin plugin) {
        var server = plugin.getServer();

        var smeltRottenFlesh = new FurnaceRecipe(
                new NamespacedKey(plugin, "smelt_rotten_flesh"),
                new ItemStack(Material.LEATHER),
                Material.ROTTEN_FLESH,
                0.25f,
                20);
        server.addRecipe(smeltRottenFlesh);

        var craftWoolToString = new ShapelessRecipe(
                new NamespacedKey(plugin, "craft_wool_to_string"),
                new ItemStack(Material.STRING, 4));
        craftWoolToString.addIngredient(Material.WHITE_WOOL);
        server.addRecipe(craftWoolToString);

        for (Material woodenSlabType : woodenSlabMaterials) {
            var woodPlanksOfSlabsType = Material.getMaterial(woodenSlabType.name().replaceAll("_SLABS", "_PLANKS"));

            var recipeKey = "craft_" + woodenSlabType.name().toLowerCase() + "_to_planks";
            var recipe = new ShapedRecipe(new NamespacedKey(plugin, recipeKey), new ItemStack(woodPlanksOfSlabsType));
            recipe.shape("S", "S");
            recipe.setIngredient('S', woodenSlabType);

            server.addRecipe(recipe);
        }
    }

    public static void unregisterRecipes(JavaPlugin plugin) {
        var server = plugin.getServer();

        server.removeRecipe(new NamespacedKey(plugin, "smelt_rotten_flesh"));
        server.removeRecipe(new NamespacedKey(plugin, "craft_wool_to_string"));

        for (Material woodenSlabType : woodenSlabMaterials) {
            server.removeRecipe(new NamespacedKey(plugin, "craft_" + woodenSlabType.name().toLowerCase() + "_to_planks"));
        }
    }
}
