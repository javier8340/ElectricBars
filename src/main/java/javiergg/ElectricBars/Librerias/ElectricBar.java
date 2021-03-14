package javiergg.ElectricBars.Librerias;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ElectricBar {
    private String asd;


    public static ItemStack getItem(){
        ItemStack item = new ItemStack(Material.IRON_BARS);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aBarras eléctricas");
        meta.setUnbreakable(true);
        item.setItemMeta(meta);
        item.setAmount(16);
        return  item;
    }

    public static String getNombre(){
        return getItem().getItemMeta().getDisplayName();
    }
}
