package de.jafe2211.mobbattle.Listeners;

import de.jafe2211.mobbattle.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class Advantsments implements Listener {
    @EventHandler
    public void onAdvantsment(PlayerAdvancementDoneEvent event){
        Player p = event.getPlayer();
        Team playerTeam = null;
        if(Main.team1.hasEntry(p.getName())){
            playerTeam = Main.team1;
        }
        if(Main.team2.hasEntry(p.getName())){
            playerTeam = Main.team2;
        }
        for (Player player : Bukkit.getOnlinePlayers()){
            if(playerTeam.hasEntry(player.getName())) {
                player.sendMessage(Main.prefix() + " " + ChatColor.GOLD + ChatColor.BOLD + p.getName() + ChatColor.GRAY +  " Hat den Fortschrit "+ ChatColor.GOLD + ChatColor.BOLD + event.getAdvancement().getDisplay().getTitle() + ChatColor.GRAY + " erziehlt !");
            }
        }


    }
}
