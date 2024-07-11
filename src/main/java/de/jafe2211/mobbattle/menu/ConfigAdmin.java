package de.jafe2211.mobbattle.menu;

import de.jafe2211.mobbattle.Main;
import de.jafe2211.mobbattle.Utility.ItemGenerator;
import de.jafe2211.mobbattle.Utility.Menu.Button;
import de.jafe2211.mobbattle.Utility.Menu.Menu;
import de.jafe2211.mobbattle.Utility.Timer.Timer;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ConfigAdmin extends Menu {
    public ConfigAdmin() {
        this.setTite("" + ChatColor.DARK_AQUA + ChatColor.BOLD + "Config");
        this.addButton(new Button(12) {

            @Override
            public ItemStack getItem(Player p) {
                return new ItemGenerator().generateItem(Material.PLAYER_HEAD, ChatColor.AQUA + "Player Settings");
            }

            @Override
            public void onClick(Player p, InventoryClickEvent event) {
                new Config().showToPlayer(p);
            }
        });
        this.addButton(new Button(14) {

            @Override
            public ItemStack getItem(Player p) {
                return new ItemGenerator().generateItem(Material.COMMAND_BLOCK, "" + ChatColor.RED + ChatColor.BOLD + "Admin Settings");
            }

            @Override
            public void onClick(Player p, InventoryClickEvent event) {
                new ConfigAdminAdmin().showToPlayer(p);
            }
        });
    }

    private class ConfigAdminAdmin extends Menu{
        public ConfigAdminAdmin(){
            this.setTite("" + ChatColor.DARK_AQUA + ChatColor.BOLD + "Admin Config");
            this.addButton(new Button(13) {

                @Override
                public ItemStack getItem(Player p) {
                    return new ItemGenerator().generateItem(Material.LIME_DYE, ChatColor.GREEN + "Start Game");
                }

                @Override
                public void onClick(Player p, InventoryClickEvent event) {
                    Timer timer = Main.getInstance().getTimer();
                    timer.start();
                    p.closeInventory();
                }
            });
        }
    }
}
