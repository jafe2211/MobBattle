package de.jafe2211.mobbattle.Commands;

import de.jafe2211.mobbattle.Utility.Entity.EntityKilled;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class test implements CommandExecutor {

    ArrayList<EntityKilled> entityKilledsTeam2 = new ArrayList();
    ArrayList<EntityKilled> entityKilledsTeam1 = new ArrayList();
    @Override
    public boolean onCommand(CommandSender cs, Command command, String s, String[] strings) {
    /*
        Player p = (Player)cs;
        String teamName = "";

        Scoreboard sb = Bukkit.getScoreboardManager().getMainScoreboard();

        for(Team team : sb.getTeams()){
            if(team.hasEntry(String.valueOf(p.getName()))){
                teamName = team.getName();
            }
        }

        if(strings.length == 0) {
            for (EntityType entity : EntityType.values()) {
                try {
                    if (p.getStatistic(Statistic.KILL_ENTITY, entity) != 0) {
                        //cs.sendMessage(String.valueOf(entity + " " + String.valueOf(p.getStatistic(Statistic.KILL_ENTITY, entity))));
                        if(teamName.equals("Team1")) {
                            entityKilledsTeam1.add(new EntityKilled(String.valueOf(entity), p.getStatistic(Statistic.KILL_ENTITY, entity)));
                        } else {
                            entityKilledsTeam2.add(new EntityKilled(String.valueOf(entity), p.getStatistic(Statistic.KILL_ENTITY, entity)));
                        }
                    }
                } catch (Exception ignored) {

                }

            }
                if(teamName.equals("Team1")) {
                    for (EntityKilled entity : entityKilledsTeam1) {
                        cs.sendMessage(entity.name + " " + entity.Count);
                    }
                } else {
                    for (EntityKilled entity : entityKilledsTeam2) {
                        cs.sendMessage(entity.name);
                    }
                }

        }
        if (strings.length == 1){
            try {
                if(teamName.equals("Team1")){
                    if (strings[0].equalsIgnoreCase("up")) {
                        for (EntityKilled entity : entityKilledsTeam1) {
                            cs.sendMessage("Aktuell " + entity.name + " " + entity.getWaveCount(1));
                            int test = entity.getWaveCount(1) + 1;
                            entity.setWaveCount(1, test);
                            cs.sendMessage("Später " + entity.name + " " + entity.getWaveCount(1));
                        }
                    }
                    if (strings[0].equalsIgnoreCase("down")) {
                        for (EntityKilled entity : entityKilledsTeam1) {
                            if (entity.getWaveCount(1) > 0) {
                                cs.sendMessage("Aktuell " + entity.name + " " + entity.getWaveCount(1));
                                int test = entity.getWaveCount(1) - 1;
                                entity.setWaveCount(1, test);
                                cs.sendMessage("Später " + entity.name + " " + entity.getWaveCount(1));
                            } else {
                                cs.sendMessage("oiusadfohisegfoöiuhbsdg");
                            }
                        }
                    }

                }
            } catch (Exception e){

            }

        }

     */
        Player p = (Player) cs;
        p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 20*10, 1));
        return false;


    }


}