package de.jafe2211.mobbattle.menu;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command command, String s, String[] strings) {
        Player p = (Player) cs;
        new ConfigStartMenu().showToPlayer(p);
        return false;
    }
}
