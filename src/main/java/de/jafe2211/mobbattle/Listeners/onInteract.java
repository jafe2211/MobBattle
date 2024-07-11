package de.jafe2211.mobbattle.Listeners;

import de.jafe2211.mobbattle.Main;
import de.jafe2211.mobbattle.Utility.ItemGenerator;
import de.jafe2211.mobbattle.Utility.openInventory;
import de.jafe2211.mobbattle.menu.Config;
import de.jafe2211.mobbattle.menu.ConfigAdmin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.persistence.PersistentDataType;

public class onInteract implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent e){
        Player p = e.getPlayer();
        if(p.getItemInHand().getType() == Material.CLOCK && p.getItemInHand().getItemMeta().getDisplayName().equals("" + ChatColor.AQUA + ChatColor.BOLD + "Config")){
            if(p.isOp()){
                new ConfigAdmin().showToPlayer(p);
            }

            if(p.hasPermission("mobbattle.config.player") && !(p.isOp())) {
                new Config().showToPlayer(p);
            }
        }
    }

    @EventHandler
    public void inventoryClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if(p.getPersistentDataContainer().get(new NamespacedKey(Main.getInstance(), "MobBattle.config.GameState"), PersistentDataType.INTEGER) == 0 && e.getSlot() == 4){
            e.setCancelled(true);
        }
    }


}
