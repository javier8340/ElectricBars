package javiergg.ElectricBars.Librerias;

import javiergg.ElectricBars.Myapp;
import org.bukkit.entity.Player;

public class Mensajes {
    public static void enviar(String mensaje, Player player){
        player.sendMessage(Myapp.get().mensajes.getString("prefijo") + " " + Myapp.get().mensajes.getString(mensaje));
    }
}
