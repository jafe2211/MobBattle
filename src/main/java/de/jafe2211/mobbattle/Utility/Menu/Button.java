package de.jafe2211.mobbattle.Utility.Menu;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public abstract class Button {

    private final int slot;

    public Button(int slot){
        this.slot = slot;
    }

    public abstract ItemStack getItem(Player p);

    public final int getSlot() {
        return slot;
    }

    public abstract void onClick(Player p, InventoryClickEvent event);


}
