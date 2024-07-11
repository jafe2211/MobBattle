package de.jafe2211.mobbattle.menu;

import de.jafe2211.mobbattle.Main;
import de.jafe2211.mobbattle.Utility.Entity.KilledEntitys;
import de.jafe2211.mobbattle.Utility.Entity.KilledEntitysWave;
import de.jafe2211.mobbattle.Utility.ItemGenerator;
import de.jafe2211.mobbattle.Utility.Menu.Button;
import de.jafe2211.mobbattle.Utility.Menu.Menu;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ConfigWaveEditWave extends Menu {

    public ConfigWaveEditWave(EntityType type, int wave){
        this.setSize(9*4);
        this.setTite(ChatColor.DARK_AQUA.toString() + ChatColor.BOLD + "Edit Wave " + wave);
        this.addButton(new Button(11) {
            @Override
            public ItemStack getItem(Player p) {
                return new ItemGenerator().generateItem(Material.RED_DYE, ChatColor.DARK_RED + "[-]");
            }

            @Override
            public void onClick(Player p, InventoryClickEvent event) {
                KilledEntitysWave.removeWaveEntity(type, wave, Main.getPlayerTeam(p));
                new ConfigWaveEditWave(type, wave).showToPlayer(p);
            }
        });
        this.addButton(new Button(13) {
            @Override
            public ItemStack getItem(Player p) {
                return new ItemGenerator().generateItem(Material.PAPER,ChatColor.AQUA + String.valueOf(KilledEntitysWave.getWaveCountExsact(type,wave, Main.getPlayerTeam(p))));
            }

            @Override
            public void onClick(Player p, InventoryClickEvent event) {

            }
        });
        this.addButton(new Button(15) {
            @Override
            public ItemStack getItem(Player p) {
                return new ItemGenerator().generateItem(Material.LIME_DYE, ChatColor.GREEN + "[+] " + type.name());
            }

            @Override
            public void onClick(Player p, InventoryClickEvent event) {
                KilledEntitysWave.addWaveEntity(type, wave, Main.getPlayerTeam(p));
                new ConfigWaveEditWave(type, wave).showToPlayer(p);
            }
        });
        this.addButton(new Button(31) {
            @Override
            public ItemStack getItem(Player p) {
                return new ItemGenerator().generateItem(Material.ARROW, ChatColor.AQUA + "Back");
            }

            @Override
            public void onClick(Player p, InventoryClickEvent event) {
                new ConfigWaveSelectWave(type).showToPlayer(p);
            }
        });
        this.addButton(new Button(0) {
            @Override
            public ItemStack getItem(Player p) {
                return new ItemGenerator().generateItem(Material.PAPER , String.valueOf(KilledEntitys.getSpecificEntity(type, Main.getPlayerTeam(p)).getCount() - KilledEntitysWave.getWaveCount(type, Main.getPlayerTeam(p))));
            }

            @Override
            public void onClick(Player p, InventoryClickEvent event) {

            }
        });
    }
}
