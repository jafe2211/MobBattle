package de.jafe2211.mobbattle.menu;

import de.jafe2211.mobbattle.Utility.ItemGenerator;
import de.jafe2211.mobbattle.Utility.Menu.Button;
import de.jafe2211.mobbattle.Utility.Menu.Menu;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;


public class ConfigStartMenu extends Menu {

    public ConfigStartMenu(){
        this.addButton(new Button(14) {

            @Override
            public ItemStack getItem(Player p) {
                return new ItemGenerator().generateItem(Material.PLAYER_HEAD, ChatColor.AQUA + "Players Online");
            }

            @Override
            public void onClick(Player p, InventoryClickEvent event) {
                new playerOnline().showToPlayer(p);
            }

        });
    }


    private class playerOnline extends Menu{
        int startingSlot = 0;
        public playerOnline(){
            for (Player p : Bukkit.getOnlinePlayers()){
                this.addButton(new Button(startingSlot++) {
                    @Override
                    public ItemStack getItem(Player p) {
                        return new ItemGenerator().generateItem(Material.PLAYER_HEAD, "" + ChatColor.AQUA + p);
                    }

                    @Override
                    public void onClick(Player p, InventoryClickEvent event) {

                    }
                });
            }
        }
    }
}
