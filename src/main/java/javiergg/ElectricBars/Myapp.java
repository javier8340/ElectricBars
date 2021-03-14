package javiergg.ElectricBars;

import javiergg.ElectricBars.Class.GuardaBloques;
import javiergg.ElectricBars.Class.Tocar;
import javiergg.ElectricBars.Events.BlockEvent;
import javiergg.ElectricBars.Events.Death;
import javiergg.ElectricBars.Events.Move;
import javiergg.ElectricBars.Librerias.ElectricBar;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class Myapp extends JavaPlugin {
    public Tocar danno;
    private static Myapp plugin;
    public String rutaConfig;

    public ConfigurationSection opciones;
    public ConfigurationSection mensajes;

    public GuardaBloques guardaBloques;


    public static Myapp get(){
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;

        registerConfig();

        this.opciones = this.getConfig().getConfigurationSection("opciones");
        this.mensajes = this.getConfig().getConfigurationSection("mensajes");
        registerEvents();
        registerRecipes();
        danno = new Tocar(this);
        try {
            guardaBloques = new GuardaBloques();
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }


    }

    public void registerRecipes(){
        ItemStack item = ElectricBar.getItem();

        NamespacedKey namespacedKey = new NamespacedKey(this, "barras_electricas");
        ShapedRecipe shapedRecipe = new ShapedRecipe(namespacedKey, item);
        shapedRecipe.shape("III","III", "RRR");
        shapedRecipe.setIngredient('I', Material.IRON_INGOT);
        shapedRecipe.setIngredient('R', Material.REDSTONE);
        Bukkit.addRecipe(shapedRecipe);
    }
    public void registerEvents() {
        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(new Move(),this);
        pm.registerEvents(new Death(),this);
        pm.registerEvents(new BlockEvent(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        opciones = null;
        mensajes = null;
    }


    public void registerConfig() {
        File config = new File(this.getDataFolder(), "config.yml");
        rutaConfig = config.getPath();
        if(!config.exists()) {
            this.getConfig().options().copyDefaults(true);
            saveConfig();
        }

    }
}
