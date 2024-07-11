package de.jafe2211.mobbattle.menu;

import de.jafe2211.mobbattle.Main;
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

public class ConfigWaveSelectWave extends Menu {
    public ConfigWaveSelectWave(EntityType entityType){
        this.setSize(9*4);
        this.setTite(ChatColor.DARK_AQUA.toString() + ChatColor.BOLD + "Wave select");
        this.addButton(new Button(13) {
            @Override
            public ItemStack getItem(Player p) {
                return new ItemGenerator().generateItem(Material.IRON_SWORD, ChatColor.AQUA + "Wave 2");
            }

            @Override
            public void onClick(Player p, InventoryClickEvent event) {
                new ConfigWaveEditWave(entityType, 2).showToPlayer(p);
            }
        });
        this.addButton(new Button( 22) {
            @Override
            public ItemStack getItem(Player p) {
                return new ItemGenerator().generateItem(Material.PAPER, ChatColor.DARK_AQUA + String.valueOf(KilledEntitysWave.getWaveCountExsact(entityType, 2, Main.getPlayerTeam(p))));
            }

            @Override
            public void onClick(Player p, InventoryClickEvent event) {

            }
        });
        this.addButton(new Button(11) {
            @Override
            public ItemStack getItem(Player p) {
                return new ItemGenerator().generateItem(Material.WOODEN_SWORD, ChatColor.AQUA + "Wave 1");
            }

            @Override
            public void onClick(Player p, InventoryClickEvent event) {
                new ConfigWaveEditWave(entityType, 1).showToPlayer(p);
            }
        });
        this.addButton(new Button( 20) {
            @Override
            public ItemStack getItem(Player p) {
                return new ItemGenerator().generateItem(Material.PAPER, ChatColor.DARK_AQUA + String.valueOf(KilledEntitysWave.getWaveCountExsact(entityType, 1, Main.getPlayerTeam(p))));
            }

            @Override
            public void onClick(Player p, InventoryClickEvent event) {

            }
        });
        this.addButton(new Button(15) {
            @Override
            public ItemStack getItem(Player p) {
                return new ItemGenerator().generateItem(Material.NETHERITE_SWORD, ChatColor.AQUA + "Wave 3");
            }

            @Override
            public void onClick(Player p, InventoryClickEvent event) {
                new ConfigWaveEditWave(entityType, 3).showToPlayer(p);
            }
        });
        this.addButton(new Button( 24) {
            @Override
            public ItemStack getItem(Player p) {
                return new ItemGenerator().generateItem(Material.PAPER, ChatColor.DARK_AQUA + String.valueOf(KilledEntitysWave.getWaveCountExsact(entityType, 3, Main.getPlayerTeam(p))));
            }

            @Override
            public void onClick(Player p, InventoryClickEvent event) {

            }
        });
        this.addButton(new Button(27) {
            @Override
            public ItemStack getItem(Player p) {
                return new ItemGenerator().generateItem(Material.ARROW, ChatColor.AQUA + "Back");
            }

            @Override
            public void onClick(Player p, InventoryClickEvent event) {
                new ConfigWaveStart(p).showToPlayer(p);
            }
        });
    }
}
