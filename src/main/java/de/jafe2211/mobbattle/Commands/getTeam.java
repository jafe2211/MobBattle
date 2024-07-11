package de.jafe2211.mobbattle.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class getTeam implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command command, String s, String[] strings) {
        String teamName = "NEEE";
        Player p = (Player)cs;

        Scoreboard sb = Bukkit.getScoreboardManager().getMainScoreboard();
        for(Team team : sb.getTeams()){
            if(team.hasEntry(String.valueOf(p.getName()))){
                teamName = team.getName();
            }
        }

        cs.sendMessage(teamName);
            return false;
    }
}
