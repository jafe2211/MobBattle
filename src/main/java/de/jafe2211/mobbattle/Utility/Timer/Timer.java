package de.jafe2211.mobbattle.Utility.Timer;

import de.jafe2211.mobbattle.Main;
import de.jafe2211.mobbattle.Utility.GameGeneral;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Set;

public class Timer {

    private Boolean running;
    private int time;

    private int countDownTime = 5;
    private int countDownTime2 = 10;

    public Timer(boolean running, int time) {
        this.running = running;
        this.time = time;

        run();
    }

    public boolean isRunning() {
        return running;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setRunning(Boolean running) {
        this.running = running;
    }

    public void sendActionBar() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (!running) continue;
            if (Main.team1.hasEntry(p.getName()) || Main.team2.hasEntry(p.getName())) {
                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("" + ChatColor.GOLD + ChatColor.BOLD + shortIntiger(getTime())));
            }
        }
    }

    public static String shortIntiger(int duration) {
        String string = "";
        int houers = 0;
        int minutes = 0;
        int seconds = 0;

        if (duration / 60 / 60 >= 1) {
            houers = duration / 60 / 60;
            duration = duration - ((duration / 60 / 60) * 60 * 60);
        }
        if (duration / 60 >= 1) {
            minutes = duration / 60;
            duration = duration - ((duration / 60) * 60);
        }
        if (duration >= 1) {
            seconds = duration;
        }

        if (houers <= 9) {
            string = string + "0" + houers + ":";
        } else {
            string = string + houers + ":";
        }

        if (minutes <= 9) {
            string = string + "0" + minutes + ":";
        } else {
            string = string + minutes + ":";
        }
        if (seconds <= 9) {
            string = string + "0" + seconds;
        } else {
            string = string + seconds;
        }

        return string;
    }

    private void run() {
        new BukkitRunnable() {
            @Override
            public void run() {
                sendActionBar();
                if (running) {

                    setTime(getTime() - 1);
                    if (getTime() == 0) {
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            if(p.getPersistentDataContainer().get(new NamespacedKey(Main.getInstance(), "MobBattle.config.GameState"), PersistentDataType.INTEGER) == 1) {
                                p.getPersistentDataContainer().set(new NamespacedKey(Main.getInstance(), "MobBattle.config.GameState"), PersistentDataType.INTEGER, 2);
                            }
                        }
                        GameGeneral.TeleportTeamsInArena();
                    }
                    if (getTime() == 10) {
                        for (Player p : Bukkit.getOnlinePlayers()) {

                        }
                    }
                }
                if(Main.getGamestate() == 3){
                    Boolean test = false;
                    for (Entity entity : Bukkit.getWorld("world").getEntities()){
                        for(String tag : entity.getScoreboardTags()){
                            if(tag == "WaveEntity"){
                                test = true;
                            }
                        }
                    }
                    if(!test){
                        for (Player p : Bukkit.getOnlinePlayers()){
                            p.sendMessage("test");
                        }
                    }
                }
            }

        }.runTaskTimer(Main.getInstance(), 20, 20);
    }

    public void start() {

        BukkitRunnable runnable = new BukkitRunnable() {
            @Override
            public void run() {
                if (countDownTime == -1) {
                    countDownTime = 5;
                    setRunning(true);
                    cancel();
                    return;
                }
                for (Player p : Bukkit.getOnlinePlayers()) {
                    p.setExp(countDownTime / 5F);
                    p.setLevel(countDownTime);
                    p.sendMessage(Main.prefix() + " Die Challange beginnt in " + ChatColor.GOLD + ChatColor.BOLD + countDownTime);
                    p.playSound(p.getLocation(), Sound.BLOCK_AMETHYST_BLOCK_STEP, 2, 2);
                    if (countDownTime == 0) {
                        if (Main.team1.hasEntry(p.getName()) || Main.team2.hasEntry(p.getName())) {
                            p.setGameMode(GameMode.SURVIVAL);
                            p.setLevel(0);
                            p.setExp(0F);
                            p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_AMBIENT, 2, 2);
                            p.getPersistentDataContainer().set(new NamespacedKey(Main.getInstance(), "MobBattle.config.GameState"), PersistentDataType.INTEGER, 1);
                            p.getInventory().clear();
                            GameGeneral.TeleportTeams();
                            GameGeneral.placeArenas(p);
                        }
                    }
                }
                countDownTime--;
            }
        };
        runnable.runTaskTimer(Main.getInstance(), 20, 20);


    }

    public void countDown() {

        BukkitRunnable runnable = new BukkitRunnable() {
            @Override
            public void run() {
                if (countDownTime2 == -1) {
                    countDownTime2 = 10;
                    setRunning(true);
                    cancel();
                    return;
                }
                for (Player p : Bukkit.getOnlinePlayers()) {
                    p.setExp(countDownTime2 / 5F);
                    p.setLevel(countDownTime2);
                    p.sendMessage(Main.prefix() + " Die Zeit ist vorbei in " + ChatColor.GOLD + ChatColor.BOLD + countDownTime2);
                    p.playSound(p.getLocation(), Sound.BLOCK_AMETHYST_BLOCK_STEP, 2, 2);
                    if (countDownTime2 == 0) {
                        if (Main.team1.hasEntry(p.getName()) || Main.team2.hasEntry(p.getName())) {

                        }
                    }
                }
                countDownTime2--;
            }
        };
        runnable.runTaskTimer(Main.getInstance(), 20, 20);

    }
}
