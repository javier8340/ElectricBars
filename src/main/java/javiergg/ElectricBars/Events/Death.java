package javiergg.ElectricBars.Events;

import javiergg.ElectricBars.Myapp;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;


public class Death implements Listener {

    @EventHandler
    public void muerte(PlayerDeathEvent e){
        if(e.getEntity().getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.CUSTOM){
            if (Myapp.get().danno.jugadores.add(e.getEntity())){
//
                e.setDeathMessage(Myapp.get().mensajes.getString("muerte").replace("%player%", e.getEntity().getDisplayName()));
                Myapp.get().danno.jugadores.remove(e.getEntity());
            }
        }


    }
}
