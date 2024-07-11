package de.jafe2211.mobbattle.Utility.Menu;

import de.jafe2211.mobbattle.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class MenuListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        int slot = e.getSlot();
        if(p.hasMetadata("MobBattle.Menu")){
           Menu menu = (Menu) p.getMetadata("MobBattle.Menu").get(0).value();
           for(Button btn: menu.getBtns()){
               if(btn.getSlot() == e.getSlot()){
                    btn.onClick(p, e);
                    e.setCancelled(true);
               }
           }
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e){
        Player p = (Player) e.getPlayer();

        if(p.hasMetadata("MobBattle.Menu")) {
            Menu menu = (Menu) p.getMetadata("MobBattle.Menu").get(0).value();
        }
        p.removeMetadata("MobBattle.Menu", Main.getInstance());
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e){
    }
}
