package de.jafe2211.mobbattle.Utility.Menu;

import de.jafe2211.mobbattle.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private final List<Button> btns = new ArrayList<>();
    private int size = 9*3;
    private String tite = "Custom Title";

    protected final void addButton(Button btn){
        this.btns.add(btn);
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setTite(String tite) {
        this.tite = tite;
    }

    public final void showToPlayer(Player p){
       Inventory inventory =  Bukkit.createInventory(p.getPlayer(),this.size, ChatColor.translateAlternateColorCodes('&', this.tite));

       for (Button btn :this.btns){
           inventory.setItem(btn.getSlot(), btn.getItem(p));
       }
       p.openInventory(inventory);
       p.setMetadata("MobBattle.Menu", new FixedMetadataValue(Main.getInstance(), this));
    }

    public final List<Button> getBtns() {
        return btns;
    }
}
