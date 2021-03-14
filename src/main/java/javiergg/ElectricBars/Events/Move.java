package javiergg.ElectricBars.Events;

import javiergg.ElectricBars.Librerias.Ubicacion;
import javiergg.ElectricBars.Myapp;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;
import java.util.List;

public class Move  implements Listener {

    private final static BlockFace[] directions = {
            BlockFace.DOWN,
            BlockFace.UP,
            BlockFace.NORTH,
            BlockFace.SOUTH,
            BlockFace.WEST,
            BlockFace.EAST
    };

    @EventHandler
    public void move(PlayerMoveEvent event){
        Player p = event.getPlayer();
        Location l = event.getTo();
        World world = l.getWorld();

        boolean recibeDanno = false;
        ArrayList<Location> ubicaciones = new ArrayList<>();

        ubicaciones.add(l);

        Location l2 = l.clone();
        l2.setX(l.getX()+1);
        ubicaciones.add(l2);

        l2 = l.clone();
        l2.setX(l.getX()-1);
        ubicaciones.add(l2);

        l2 = l.clone();
        l2.setY(l.getY()+1);
        ubicaciones.add(l2);

        l2 = l.clone();
        l2.setY(l.getY()-1);
        ubicaciones.add(l2);

        l2 = l.clone();
        l2.setZ(l.getZ()+1);
        ubicaciones.add(l2);

        l2 = l.clone();
        l2.setZ(l.getZ()-1);
        ubicaciones.add(l2);

        for (Location location: ubicaciones) {
            Material m = world.getBlockAt(location).getBlockData().getMaterial();
            if (m == Material.IRON_BARS){

                List<Location> bloques = Myapp.get().guardaBloques.getBloques();
                for (Location bloque: bloques){
                    if (Ubicacion.compareLocations(location, bloque)){
                        recibeDanno = true;
                        if (!Myapp.get().danno.jugadores.contains(p)){
                            Myapp.get().danno.jugadores.add(p);
                        }
                    }
                }

            }
        }

        if (!recibeDanno){
            Myapp.get().danno.jugadores.remove(p);
        }


    }





}
