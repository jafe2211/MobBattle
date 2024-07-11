package de.jafe2211.mobbattle.Listeners;

import de.jafe2211.mobbattle.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.persistence.PersistentDataType;

public class Chat implements Listener {

    @EventHandler
    public void onChatMessage(AsyncPlayerChatEvent e){
        String message = e.getMessage();

        if(e.getPlayer().getPersistentDataContainer().get(new NamespacedKey(Main.getInstance(), "MobBattle.config.GameState"), PersistentDataType.INTEGER) == 0) {

            if (e.getPlayer().isOp()) {
                e.setFormat("" + ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + ChatColor.BOLD + "Admin" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_AQUA + ChatColor.BOLD + e.getPlayer().getName() + ChatColor.RESET + ChatColor.DARK_GRAY + " | " + ChatColor.WHITE + message);
            } else {
                e.setFormat("" + ChatColor.DARK_AQUA + e.getPlayer().getName() + ChatColor.DARK_GRAY + " | " + ChatColor.GRAY + message);
            }
        } else {
            for (Player p : Bukkit.getOnlinePlayers()){
                if(Main.team1.hasEntry(e.getPlayer().getName()) && Main.team1.hasEntry(p.getName())){
                    if (e.getPlayer().isOp()) {
                        e.setFormat("" + ChatColor.DARK_AQUA + ChatColor.BOLD + e.getPlayer().getName() + ChatColor.RESET + ChatColor.DARK_GRAY + " | " + ChatColor.WHITE + message);
                    } else {
                        e.setFormat("" + ChatColor.DARK_AQUA + e.getPlayer().getName() + ChatColor.DARK_GRAY + " | " + ChatColor.WHITE + message);
                    }

                }
                if(Main.team2.hasEntry(e.getPlayer().getName()) && Main.team2.hasEntry(p.getName())){
                    if (e.getPlayer().isOp()) {
                        e.setFormat(""+ ChatColor.DARK_AQUA + ChatColor.BOLD + e.getPlayer().getName() + ChatColor.RESET + ChatColor.DARK_GRAY + " | " + ChatColor.WHITE + message);
                    } else {
                        e.setFormat("" + ChatColor.DARK_AQUA + e.getPlayer().getName() + ChatColor.DARK_GRAY + " | " + ChatColor.WHITE + message);
                    }
                }
            }
        }

    }


}
