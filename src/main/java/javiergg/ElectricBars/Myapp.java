package javiergg.ElectricBars;

import javiergg.ElectricBars.Class.Tocar;
import javiergg.ElectricBars.Events.Death;
import javiergg.ElectricBars.Events.Move;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Myapp extends JavaPlugin {
    public Tocar danno;
    private static Myapp plugin;
    public String rutaConfig;
    public ConfigurationSection opciones;
    public ConfigurationSection mensajes;



    public static Myapp get(){
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
        danno = new Tocar(this);
        registerConfig();
        registerEvents();

        this.opciones = this.getConfig().getConfigurationSection("opciones");
        this.mensajes = this.getConfig().getConfigurationSection("mensajes");



    }

    public void registerEvents() {
        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(new Move(),this);
        pm.registerEvents(new Death(),this);
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
