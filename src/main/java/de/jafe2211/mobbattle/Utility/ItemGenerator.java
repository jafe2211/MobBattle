package de.jafe2211.mobbattle.Utility;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ItemGenerator extends ItemStack {

    public ItemStack generateItem(Material material){
        ItemStack item = new ItemStack(material);
        return item;
    }

    public ItemStack generateItem(Material material, String DisplayName){
        ItemStack item = new ItemStack(material);

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(DisplayName);

        item.setItemMeta(meta);
        return  item;
    }
    public ItemStack generateItem(Material material, String displayName, ArrayList<String> lore){
        ItemStack item = new ItemStack(material);

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(displayName);
        meta.setLore(lore);

        item.setItemMeta(meta);
        return  item;
    }
}
