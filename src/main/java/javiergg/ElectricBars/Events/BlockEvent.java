package javiergg.ElectricBars.Events;

import javiergg.ElectricBars.Class.GuardaBloques;
import javiergg.ElectricBars.Librerias.ElectricBar;
import javiergg.ElectricBars.Librerias.Ubicacion;
import javiergg.ElectricBars.Myapp;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import java.io.IOException;
import java.util.List;

public class BlockEvent implements Listener {

    @EventHandler
    public void blockPlace(BlockPlaceEvent blockPlaceEvent) throws IOException {
        ItemStack item = blockPlaceEvent.getItemInHand();
        ItemMeta meta = item.getItemMeta();
        if (meta.isUnbreakable()){
            if (meta.getDisplayName().equals(ElectricBar.getNombre())){
                if (item.getType().equals(Material.IRON_BARS)){
//                    añadir a lista
                    Myapp.get().guardaBloques.guarda(blockPlaceEvent.getBlock());
                }
            }
        }

    }

    @EventHandler
    public void blockBreak(BlockBreakEvent blockBreakEvent) throws IOException {
        List<Location> bloques = Myapp.get().guardaBloques.getBloques();
        Block bloque = blockBreakEvent.getBlock();
        if (!bloques.isEmpty()){
            for (Location ironBar: bloques) {
                if (bloque.getLocation().equals(ironBar)){
                    blockBreakEvent.setCancelled(true);
                    bloque.setType(Material.AIR);
                    ItemStack electricBar = ElectricBar.getItem();
                    electricBar.setAmount(1);
                    bloque.getLocation().getWorld().dropItem(bloque.getLocation(), electricBar);
                    Myapp.get().guardaBloques.elimina(bloque.getLocation());
                    return;
                }
            }
        }

    }
}
