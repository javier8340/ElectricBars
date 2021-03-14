package javiergg.ElectricBars.Class;

import javiergg.ElectricBars.Myapp;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GuardaBloques {

    private File data;
    private YamlConfiguration dataConfig;

    private List<Location> bloques;


    public GuardaBloques() throws IOException, InvalidConfigurationException {
        Myapp plugin = Myapp.get();
        File data = new File(plugin.getDataFolder(), "bloques.yml");
        this.data = data;
        if (!data.exists()){
            data.createNewFile();
        }
        YamlConfiguration dataConf = new YamlConfiguration();
        dataConf.load(this.data);
        this.dataConfig = dataConf;

//        if (!this.dataConfig.isConfigurationSection("bloques")){
//            this.dataConfig.createSection("bloques");
//        }
        if (!this.dataConfig.isSet("bloques")){
            this.dataConfig.set("bloques", new ArrayList<Location>());
            bloques = new ArrayList<Location>();
            dataConfig.save(data);
        }else{
            bloques = (List<Location>) this.dataConfig.getList("bloques");
        }


    }

    public boolean guarda(Block block) throws IOException {

        List lista;

        lista = dataConfig.getList("bloques");
        lista.add(block.getLocation());
        dataConfig.set("bloques", lista);
        dataConfig.save(data);
        this.bloques = lista;

        return false;
    }

    public boolean elimina(Location location) throws IOException {

        bloques.remove(location);
        dataConfig.set("bloques", bloques);
        dataConfig.save(data);
        return false;
    }
    public List<Location> getBloques(){
        return this.bloques;
    }
}
