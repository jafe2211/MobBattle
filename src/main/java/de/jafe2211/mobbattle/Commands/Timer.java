package de.jafe2211.mobbattle.Commands;

import de.jafe2211.mobbattle.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class Timer implements CommandExecutor , TabCompleter {
    @Override
    public boolean onCommand(CommandSender cs, Command command, String label, String[] args) {
        de.jafe2211.mobbattle.Utility.Timer.Timer timer = Main.getInstance().getTimer();
        if(args.length == 0){
            cs.sendMessage(Main.prefix() + ChatColor.DARK_RED + " Falsche verwendung");
            return true;
        }
        if(args.length == 1){
            if(args[0].equalsIgnoreCase("start")){
                if(timer.isRunning()) {
                    cs.sendMessage(Main.prefix() + ChatColor.DARK_RED + " Timer läuft bereits");
                    return true;
                }

                timer.setRunning(true);
                cs.sendMessage(Main.prefix() + " Der Timer wurde gestartet");
            }
            if(args[0].equalsIgnoreCase("pause")){
                if(!(timer.isRunning())) {
                    cs.sendMessage(Main.prefix() + ChatColor.DARK_RED + " Timer läuft nicht");
                    return true;
                }

                timer.setRunning(false);
                cs.sendMessage(Main.prefix() + " Der Timer wurde pausiert");
            }
            if(args[0].equalsIgnoreCase("reset")){

                timer.setTime(0);
                cs.sendMessage(Main.prefix() + " Der Timer wurde resetet");
            }
        }
        if(args.length == 2){
            if(args[0].equalsIgnoreCase("set")){
                try{
                    timer.setTime(Integer.parseInt(args[1]));
                    cs.sendMessage(Main.prefix() + " Der Timer wurde auf " + args[1] + " gesetzt");
                } catch (Exception e){
                    cs.sendMessage(Main.prefix() + ChatColor.DARK_RED + " Gib eine Zahl ein");
                }
            }
        }
        return false;




    }

    @Override
    public List<String> onTabComplete(CommandSender cs, Command cmd, String label, String[] args) {
        ArrayList<String> list = new ArrayList<>();
        if(args.length == 1){
            list.add("start");
            list.add("pause");
            list.add("reset");
            list.add("set");
        }

        return list;
    }
}
