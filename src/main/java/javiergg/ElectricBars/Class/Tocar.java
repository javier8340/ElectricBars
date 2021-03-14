package javiergg.ElectricBars.Class;


import javiergg.ElectricBars.Entity.Muerte;
import javiergg.ElectricBars.Myapp;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class Tocar {

    public ArrayList<Player> jugadores;
    private Plugin plugin;

    public Tocar(Plugin plugin){
        this.plugin = plugin;
        this.jugadores = new ArrayList<>();
        runner();
    }

    public void runner(){

        new BukkitRunnable(){

            @Override
            public void run() {
                for (Player p: jugadores) {
                    p.setHurtDirection(0);

                    p.damage(Myapp.get().opciones.getDouble("damage"), new Muerte());

                }
                runner();
            }
        }.runTaskLater(this.plugin, Myapp.get().opciones.getInt("delayDamage"));
    }
}
