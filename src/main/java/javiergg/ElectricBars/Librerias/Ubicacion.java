package javiergg.ElectricBars.Librerias;

import org.bukkit.Location;

public class Ubicacion {
    public static boolean compareLocations(Location l1, Location l2){
        boolean salida = false;
        if (l1.getWorld().equals(l2.getWorld())){
            if ((int) l1.getX() == (int) l2.getX()){
                if ((int) l1.getY() == (int) l2.getY()){
                    if ((int) l1.getZ() == (int) l2.getZ()){
                        salida = true;
                    }
                }
            }
        }

        return salida;
    }
}
