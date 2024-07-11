package de.jafe2211.mobbattle.Utility;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class openInventory {

    public static int currentInventory;

    public static void open(Player p, int Inventory){
        if(Inventory == 0){
            org.bukkit.inventory.Inventory inventory = Bukkit.createInventory(null,9*3, ""+ ChatColor.DARK_AQUA + ChatColor.BOLD + "Config");

            inventory.setItem(11, new ItemGenerator().generateItem(Material.PLAYER_HEAD, ChatColor.AQUA + "Spieler config"));
            inventory.setItem(13, new ItemGenerator().generateItem(Material.LECTERN, ChatColor.AQUA + "Team config"));
            inventory.setItem(15, new ItemGenerator().generateItem(Material.COMMAND_BLOCK, "" + ChatColor.DARK_RED + ChatColor.BOLD + "Admin config"));
            currentInventory = 0;
            p.openInventory(inventory);
        }
        if(Inventory == 1){
                org.bukkit.inventory.Inventory inventory = Bukkit.createInventory(null,9*3, ""+ ChatColor.DARK_AQUA + ChatColor.BOLD + "Config");

                inventory.setItem(12, new ItemGenerator().generateItem(Material.PLAYER_HEAD, ChatColor.AQUA + "Spieler config"));
                inventory.setItem(14, new ItemGenerator().generateItem(Material.LECTERN, ChatColor.AQUA + "Team config"));
                currentInventory = 1;
                p.openInventory(inventory);
        }
        if(Inventory == 2){
                org.bukkit.inventory.Inventory inventory = Bukkit.createInventory(null,9*3, ""+ ChatColor.DARK_AQUA + ChatColor.BOLD + "Config");

                inventory.setItem(13, new ItemGenerator().generateItem(Material.PLAYER_HEAD, ChatColor.AQUA + "Spieler config"));
                currentInventory = 2;
                p.openInventory(inventory);
        }
        if(Inventory == 3){
                org.bukkit.inventory.Inventory inventory = Bukkit.createInventory(null,9*3, ""+ ChatColor.DARK_AQUA + ChatColor.BOLD + "Join Team");

                inventory.setItem(11, new ItemGenerator().generateItem(Material.BLUE_CONCRETE, ChatColor.BLUE + "Join Blue Team"));
                inventory.setItem(13, new ItemGenerator().generateItem(Material.WHITE_CONCRETE, ChatColor.AQUA + "Your Team"));
                inventory.setItem(15, new ItemGenerator().generateItem(Material.RED_CONCRETE, ChatColor.RED + "Join Red Team"));
                currentInventory = 3;
                p.openInventory(inventory);
        }
           /* case 4: {
                org.bukkit.inventory.Inventory inventory = Bukkit.createInventory(null,9*3, ""+ ChatColor.DARK_AQUA + ChatColor.BOLD + "Join Team");

                inventory.setItem(11, new ItemGenerator().generateItem(Material.BLUE_CONCRETE, ChatColor.BLUE + "Join Blue Team"));
                inventory.setItem(13, new ItemGenerator().generateItem(Material.BLUE_CONCRETE, ChatColor.AQUA + "Your Team"));
                inventory.setItem(15, new ItemGenerator().generateItem(Material.RED_CONCRETE, ChatColor.RED + "Join Red Team"));
                currentInventory = 4;
                p.openInventory(inventory);
            }
            case 5: {
                org.bukkit.inventory.Inventory inventory = Bukkit.createInventory(null,9*3, ""+ ChatColor.DARK_AQUA + ChatColor.BOLD + "Join Team");

                inventory.setItem(11, new ItemGenerator().generateItem(Material.BLUE_CONCRETE, ChatColor.BLUE + "Join Blue Team"));
                inventory.setItem(13, new ItemGenerator().generateItem(Material.RED_CONCRETE, ChatColor.AQUA + "Your Team"));
                inventory.setItem(15, new ItemGenerator().generateItem(Material.RED_CONCRETE, ChatColor.RED + "Join Red Team"));
                currentInventory = 5;
                p.openInventory(inventory);
            }

            */
        }

    public static void setCurrentInventory(int Inventory){
        currentInventory = Inventory;
    }
    public static int getCurrentInventory(){
        return  currentInventory;
    }
}
