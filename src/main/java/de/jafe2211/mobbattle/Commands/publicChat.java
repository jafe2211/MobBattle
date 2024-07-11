package de.jafe2211.mobbattle.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.nio.Buffer;

public class publicChat implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command command, String s, String[] args) {
        if(!(cs instanceof Player)) return true;

        Player p = ((Player) cs);

        StringBuilder message = new StringBuilder();

        for(String arg : args){
            message.append(arg + " ");
        }

        for (Player player : Bukkit.getOnlinePlayers()){
            if (player.isOp()) {
                player.sendMessage(""+ ChatColor.DARK_AQUA + ChatColor.BOLD + p.getName() + ChatColor.RESET + ChatColor.DARK_GRAY + " | " + ChatColor.WHITE + message);
            } else {
                player.sendMessage("" + ChatColor.DARK_AQUA + p.getName() + ChatColor.DARK_GRAY + " | " + ChatColor.WHITE + message);
            }
        }
        return false;
    }
}
