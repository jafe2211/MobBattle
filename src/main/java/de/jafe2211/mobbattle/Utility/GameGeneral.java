package de.jafe2211.mobbattle.Utility;

import de.jafe2211.mobbattle.Main;
import de.jafe2211.mobbattle.Utility.Entity.EntityKilled;
import de.jafe2211.mobbattle.Utility.Entity.KilledEntitysWave;
import org.bukkit.*;
import org.bukkit.block.structure.Mirror;
import org.bukkit.block.structure.StructureRotation;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class GameGeneral {
    static Scoreboard sb = Bukkit.getScoreboardManager().getMainScoreboard();
    public static void TeleportTeams(){
        for (Player p : Bukkit.getOnlinePlayers()){
            int min = 0;
            int max = 5;

            int xRandom = (int) (Math.random() * (max - min)) + min;
            int yRandom = (int) (Math.random() * (max-min)) + min;

            int x = 50000;
            int y = 50000;
            int z = 180;

            if(Main.team1.hasEntry(p.getName())){
                Location location = new Location(p.getWorld(), (x+xRandom) * -1,  z,(y+yRandom) * -1);
                p.teleport(location);
                p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20*2, 1));
                p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 20*20, 1));
            }
            if(Main.team2.hasEntry(p.getName())){
                Location location = new Location(p.getWorld(), x+xRandom ,  z,y+yRandom);
                p.teleport(location);
                p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20*2, 1));
                p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 20*20, 1));
            }
            placeArenas(p);
        }
    }
    public static void placeArenas(Player p){
        Location location1 = new Location(p.getWorld(), 0,130,0);
        Location location2 = new Location(p.getWorld(), 48,130,0);
        Location location3 = new Location(p.getWorld(), 96,130,0);
        Location location4 = new Location(p.getWorld(), 0,130,48);
        Location location5 = new Location(p.getWorld(), 48,130,48);
        Location location6 = new Location(p.getWorld(), 96,130,48);
        Location location7 = new Location(p.getWorld(), 0,130,96);
        Location location8 = new Location(p.getWorld(), 48,130,96);
        Location location9 = new Location(p.getWorld(), 96,130,96);
        Location location10 = new Location(p.getWorld(), 0,130,144);
        Location location11 = new Location(p.getWorld(), 48,130,144);
        Location location12 = new Location(p.getWorld(), 96,130,144);

        Location location1a = new Location(p.getWorld(), 0,200,0);
        Location location2a = new Location(p.getWorld(), 48,200,0);
        Location location3a = new Location(p.getWorld(), 96,200,0);
        Location location4a = new Location(p.getWorld(), 0,200,48);
        Location location5a = new Location(p.getWorld(), 48,200,48);
        Location location6a = new Location(p.getWorld(), 96,200,48);
        Location location7a = new Location(p.getWorld(), 0,200,96);
        Location location8a = new Location(p.getWorld(), 48,200,96);
        Location location9a = new Location(p.getWorld(), 96,200,96);
        Location location10a = new Location(p.getWorld(), 0,200,144);
        Location location11a = new Location(p.getWorld(), 48,200,144);
        Location location12a = new Location(p.getWorld(), 96,200,144);

        Location locationPlayer = new Location(p.getWorld(), 0,131,0);

        File myStructures = new File(Main.getInstance().getDataFolder(), "structures");
        File siteFile1 = new File(myStructures, "a1.nbt");
        File siteFile2 = new File(myStructures, "a2.nbt");
        File siteFile3 = new File(myStructures, "a3.nbt");
        File siteFile4 = new File(myStructures, "a1a.nbt");
        File siteFile5 = new File(myStructures, "a2a.nbt");
        File siteFile6 = new File(myStructures, "a3a.nbt");
        File siteFile7 = new File(myStructures, "a1b.nbt");
        File siteFile8 = new File(myStructures, "a2b.nbt");
        File siteFile9 = new File(myStructures, "a3b.nbt");
        File siteFile10 = new File(myStructures, "a1c.nbt");
        File siteFile11 = new File(myStructures, "a2c.nbt");
        File siteFile12 = new File(myStructures, "a3c.nbt");

        Bukkit.getLogger().info(siteFile1.getAbsolutePath());
        try {
            Bukkit.getStructureManager().loadStructure(siteFile1).place(location1,
                    true, StructureRotation.NONE, Mirror.NONE, -1, 1, new Random());
            Bukkit.getStructureManager().loadStructure(siteFile2).place(location2,
                    true, StructureRotation.NONE, Mirror.NONE, -1, 1, new Random());
            Bukkit.getStructureManager().loadStructure(siteFile3).place(location3,
                    true, StructureRotation.NONE, Mirror.NONE, -1, 1, new Random());
            Bukkit.getStructureManager().loadStructure(siteFile4).place(location4,
                    true, StructureRotation.NONE, Mirror.NONE, -1, 1, new Random());
            Bukkit.getStructureManager().loadStructure(siteFile5).place(location5,
                    true, StructureRotation.NONE, Mirror.NONE, -1, 1, new Random());
            Bukkit.getStructureManager().loadStructure(siteFile6).place(location6,
                    true, StructureRotation.NONE, Mirror.NONE, -1, 1, new Random());
            Bukkit.getStructureManager().loadStructure(siteFile7).place(location7,
                    true, StructureRotation.NONE, Mirror.NONE, -1, 1, new Random());
            Bukkit.getStructureManager().loadStructure(siteFile8).place(location8,
                    true, StructureRotation.NONE, Mirror.NONE, -1, 1, new Random());
            Bukkit.getStructureManager().loadStructure(siteFile9).place(location9,
                    true, StructureRotation.NONE, Mirror.NONE, -1, 1, new Random());
            Bukkit.getStructureManager().loadStructure(siteFile10).place(location10,
                    true, StructureRotation.NONE, Mirror.NONE, -1, 1, new Random());
            Bukkit.getStructureManager().loadStructure(siteFile11).place(location11,
                    true, StructureRotation.NONE, Mirror.NONE, -1, 1, new Random());
            Bukkit.getStructureManager().loadStructure(siteFile12).place(location12,
                    true, StructureRotation.NONE, Mirror.NONE, -1, 1, new Random());


            Bukkit.getStructureManager().loadStructure(siteFile1).place(location1a,
                    true, StructureRotation.NONE, Mirror.NONE, -1, 1, new Random());
            Bukkit.getStructureManager().loadStructure(siteFile2).place(location2a,
                    true, StructureRotation.NONE, Mirror.NONE, -1, 1, new Random());
            Bukkit.getStructureManager().loadStructure(siteFile3).place(location3a,
                    true, StructureRotation.NONE, Mirror.NONE, -1, 1, new Random());
            Bukkit.getStructureManager().loadStructure(siteFile4).place(location4a,
                    true, StructureRotation.NONE, Mirror.NONE, -1, 1, new Random());
            Bukkit.getStructureManager().loadStructure(siteFile5).place(location5a,
                    true, StructureRotation.NONE, Mirror.NONE, -1, 1, new Random());
            Bukkit.getStructureManager().loadStructure(siteFile6).place(location6a,
                    true, StructureRotation.NONE, Mirror.NONE, -1, 1, new Random());
            Bukkit.getStructureManager().loadStructure(siteFile7).place(location7a,
                    true, StructureRotation.NONE, Mirror.NONE, -1, 1, new Random());
            Bukkit.getStructureManager().loadStructure(siteFile8).place(location8a,
                    true, StructureRotation.NONE, Mirror.NONE, -1, 1, new Random());
            Bukkit.getStructureManager().loadStructure(siteFile9).place(location9a,
                    true, StructureRotation.NONE, Mirror.NONE, -1, 1, new Random());
            Bukkit.getStructureManager().loadStructure(siteFile10).place(location10a,
                    true, StructureRotation.NONE, Mirror.NONE, -1, 1, new Random());
            Bukkit.getStructureManager().loadStructure(siteFile11).place(location11a,
                    true, StructureRotation.NONE, Mirror.NONE, -1, 1, new Random());
            Bukkit.getStructureManager().loadStructure(siteFile12).place(location12a,
                    true, StructureRotation.NONE, Mirror.NONE, -1, 1, new Random());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void TeleportTeamsInArena(){
        for (Player p : Bukkit.getOnlinePlayers()){
            int xRandom = (int) (Math.random() * (80 - 65)) + 65;
            int yRandom = (int) (Math.random() * (70-66)) + 66;

            if(Main.team1.hasEntry(p.getName())){
                Location location = new Location(p.getWorld(), xRandom,  134,yRandom);
                p.teleport(location);
                p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, PotionEffect.INFINITE_DURATION, 250));
            }
            if(Main.team2.hasEntry(p.getName())){
                Location location = new Location(p.getWorld(), xRandom ,  204,yRandom);
                p.teleport(location);
                p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, PotionEffect.INFINITE_DURATION, 250));
            }
        }
    }
    public static void playerReady(Player p){
       p.addScoreboardTag("ReadyWaveSelect");
       for(Player player : Bukkit.getOnlinePlayers()){
           if(!(Main.getPlayerTeam(player) == -1)){
               if(player.getPersistentDataContainer().get(new NamespacedKey(Main.getInstance(), "MobBattle.config.GameState"), PersistentDataType.INTEGER) == 2) {
                   player.getPersistentDataContainer().set(new NamespacedKey(Main.getInstance(), "MobBattle.config.GameState"), PersistentDataType.INTEGER, 3);
               }
           }
       }
    }
    public static void spawnWave(Player p, int wave){
        Main.setGamestate(3);


       // Location loc = new Location(p.getWorld(), 31, 131, 35);
       // for (EntityKilled entity : KilledEntitysWave.getWave(wave, Main.getPlayerTeam(p))){
        //    for(int i = 0; i <= entity.getCount() - 1; i++){
      //          Entity entity1 = loc.getWorld().spawnEntity(loc, entity.getEntityType());
       //         entity1.addScoreboardTag("WaveEntity");
      //      }
      //  }
    }
    public static void startSpawning(){
        new BukkitRunnable(){

            @Override
            public void run() {
                for(Player p : Bukkit.getOnlinePlayers()){
                    if(Main.getPlayerTeam(p) == -1) return;
                    if(p.getPersistentDataContainer().get(new NamespacedKey(Main.getInstance(), "MobBattle.config.GameState"), PersistentDataType.INTEGER) == 2) return;

                    p.sendMessage(Main.prefix() + " Viel Erfolg!");
                }
            }
        }.runTaskTimer(Main.getInstance(), 20, 20);
    }
}
