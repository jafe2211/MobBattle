package de.jafe2211.mobbattle.Commands;

import com.github.shynixn.structureblocklib.api.bukkit.StructureBlockLibApi;
import de.jafe2211.mobbattle.Main;
import de.jafe2211.mobbattle.Utility.Entity.EntityKilled;
import de.jafe2211.mobbattle.Utility.Entity.KilledEntitys;
import de.jafe2211.mobbattle.Utility.Entity.KilledEntitysWave;
import de.jafe2211.mobbattle.Utility.GameGeneral;
import de.jafe2211.mobbattle.menu.ConfigWaveStart;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.block.structure.Mirror;
import org.bukkit.block.structure.StructureRotation;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.persistence.PersistentDataType;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;

public class MobBattleDebug implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
        Player p = ((Player) cs);
/*
        File myStructures = new File(Main.getInstance().getDataFolder(), "structures");
        File siteFile = new File(myStructures, "test.nbt");
        Bukkit.getLogger().info(siteFile.getAbsolutePath());
        try {
            Bukkit.getStructureManager().loadStructure(siteFile).place(p.getLocation(),
                    true, StructureRotation.NONE, Mirror.NONE, -1, 1, new Random());
        } catch (IOException e) {
            e.printStackTrace();
        }


 */
        if(args.length == 1) {
            if(args[0].equalsIgnoreCase("resetNbt")) {
                p.getPersistentDataContainer().set(new NamespacedKey(Main.getInstance(), "MobBattle.config.GameState"), PersistentDataType.INTEGER, 0);
            }
            if(args[0].equalsIgnoreCase("getKilledMobs")) {
                for(EntityKilled entity : KilledEntitys.getEntitys(0)){
                    p.sendMessage(entity.getEntityType().name() + " " + entity.getCount());
                }
            }
            if(args[0].equalsIgnoreCase("configurewave")) {
                new ConfigWaveStart(p).showToPlayer(p);
            }
            if(args[0].equalsIgnoreCase("Test")) {
              //  p.sendMessage(String.valueOf(KilledEntitys.getSpecificEntity(EntityType.ZOMBIE, 0).getCount() - KilledEntitysWave.getWaveCount(EntityType.ZOMBIE, 0)));
               // p.sendMessage(String.valueOf(KilledEntitys.getSpecificEntity(EntityType.ZOMBIE, 0).getCount()));
               // p.sendMessage(String.valueOf(KilledEntitysWave.getWaveCount(EntityType.ZOMBIE, 0)));
                GameGeneral.placeArenas(p);
                Location loc = new Location(p.getWorld(), 35, 132, 20);
                p.teleport(loc);
            }
            if(args[0].equalsIgnoreCase("startspawnig")) {
                GameGeneral.startSpawnig(p, 1);
            }
        }
        return false;
    }


    @Override
    public List<String> onTabComplete(CommandSender cs, Command command,String label, String[] args) {
        ArrayList<String> list = new ArrayList<>();
        if(args.length == 1){
            list.add("resetNbt");
            list.add("getKilledMobs");
            list.add("configureWave");
            list.add("getWave");
            list.add("startSpawnig");
        }
        if(args.length == 2){
            list.add("Wave1");
            list.add("Wave2");
            list.add("Wave3");
        }
        return list;
    }
}
