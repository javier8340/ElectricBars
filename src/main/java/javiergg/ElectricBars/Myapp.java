package javiergg.ElectricBars;

import javiergg.ElectricBars.Class.Tocar;
import javiergg.ElectricBars.Events.Death;
import javiergg.ElectricBars.Events.Move;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Myapp extends JavaPlugin {
    public Tocar danno;
    private static Myapp plugin;
    public static Myapp get(){
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
        // Plugin startup logic
        registerEvents();
        danno = new Tocar(this);


    }

    public void registerEvents() {
        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(new Move(),this);
        pm.registerEvents(new Death(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
