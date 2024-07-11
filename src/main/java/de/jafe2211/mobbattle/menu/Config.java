package de.jafe2211.mobbattle.menu;

import de.jafe2211.mobbattle.Main;
import de.jafe2211.mobbattle.Utility.ItemGenerator;
import de.jafe2211.mobbattle.Utility.Menu.Button;
import de.jafe2211.mobbattle.Utility.Menu.Menu;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.Scoreboard;

public class Config extends Menu {

    String teamName = "NEEE";

    Scoreboard sb = Bukkit.getScoreboardManager().getMainScoreboard();

    public Config() {
        this.setTite("" + ChatColor.DARK_AQUA + ChatColor.BOLD + "Join Team");
        this.addButton(new Button(11) {
            @Override
            public ItemStack getItem(Player p) {
                return new ItemGenerator().generateItem(Material.RED_CONCRETE, ChatColor.DARK_RED + "Join RedTeam");
            }

            @Override
            public void onClick(Player p, InventoryClickEvent event) {
                Main.team2.addEntry(p.getName());
                p.sendMessage(Main.prefix() + " Du bist dem " + ChatColor.DARK_RED + "Roten Team " + ChatColor.GRAY + "beigetreten");
                new Config().showToPlayer(p);
            }
        });
        this.addButton(new Button(13) {

            @Override
            public ItemStack getItem(Player p) {
                if(Main.team1.hasEntry(p.getName())) return new ItemGenerator().generateItem(Material.BLUE_CONCRETE, ChatColor.WHITE + "Your Team");
                if(Main.team2.hasEntry(p.getName())) return new ItemGenerator().generateItem(Material.RED_CONCRETE, ChatColor.WHITE + "Your Team");
                return new ItemGenerator().generateItem(Material.WHITE_CONCRETE, ChatColor.WHITE + "Your Team");
            }

            @Override
            public void onClick(Player p, InventoryClickEvent event) {

            }

        });
        this.addButton(new Button(15) {
            @Override
            public ItemStack getItem(Player p) {
                return new ItemGenerator().generateItem(Material.BLUE_CONCRETE, ChatColor.DARK_BLUE + "Join BlueTeam");
            }

            @Override
            public void onClick(Player p, InventoryClickEvent event) {
                Main.team1.addEntry(p.getName());
                p.sendMessage(Main.prefix() + " Du bist dem " + ChatColor.DARK_BLUE + "Blauen Team " + ChatColor.GRAY + "beigetreten");
                new Config().showToPlayer(p);
            }
        });
    }
}
