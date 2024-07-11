package de.jafe2211.mobbattle.Commands;

import de.jafe2211.mobbattle.menu.Config;
import de.jafe2211.mobbattle.menu.ConfigAdmin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JoinTeam implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command command, String s, String[] strings) {
        if(!(cs instanceof Player)) return true;

        Player p = (Player) cs;
        if(p.isOp()){
            new ConfigAdmin().showToPlayer(p);
        }

        if(p.hasPermission("mobbattle.config.player") && !(p.isOp())) {
            new Config().showToPlayer(p);
        }


        return false;
    }
}
