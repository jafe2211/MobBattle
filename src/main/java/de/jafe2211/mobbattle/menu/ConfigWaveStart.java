package de.jafe2211.mobbattle.menu;

import de.jafe2211.mobbattle.Main;
import de.jafe2211.mobbattle.Utility.Entity.EntityKilled;
import de.jafe2211.mobbattle.Utility.Entity.KilledEntitys;
import de.jafe2211.mobbattle.Utility.GameGeneral;
import de.jafe2211.mobbattle.Utility.ItemGenerator;
import de.jafe2211.mobbattle.Utility.Menu.Button;
import de.jafe2211.mobbattle.Utility.Menu.Menu;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ConfigWaveStart extends Menu {
    public ConfigWaveStart(Player p){
        int i = 0;
        this.setSize(9*6);
        this.setTite(ChatColor.DARK_AQUA.toString() + ChatColor.BOLD + "Select Mob");
        this.addButton(new Button(51) {
            @Override
            public ItemStack getItem(Player p) {
                return new ItemGenerator().generateItem(Material.ARROW, ChatColor.DARK_AQUA + "Next Page");
            }

            @Override
            public void onClick(Player p, InventoryClickEvent event) {

            }
        });
        this.addButton(new Button(47) {
            @Override
            public ItemStack getItem(Player p) {
                return new ItemGenerator().generateItem(Material.ARROW, ChatColor.DARK_AQUA + "Previous Page");
            }

            @Override
            public void onClick(Player p, InventoryClickEvent event) {

            }
        });
        this.addButton(new Button(49) {
            @Override
            public ItemStack getItem(Player p) {
                return new ItemGenerator().generateItem(Material.LIME_DYE, ChatColor.DARK_AQUA + "Ready");
            }

            @Override
            public void onClick(Player p, InventoryClickEvent event) {
                GameGeneral.playerReady(p);
            }
        });
        for(EntityKilled entity : KilledEntitys.getEntitys(Main.getPlayerTeam(p))){
            if(i <= 45) {
                this.addButton(new Button(i) {
                    @Override
                    public ItemStack getItem(Player p) {
                        return new ItemGenerator().generateItem(Material.PLAYER_HEAD, ChatColor.AQUA +  entity.getEntityType().name());
                    }

                    @Override
                    public void onClick(Player p, InventoryClickEvent event) {
                        new ConfigWaveSelectWave(entity.getEntityType()).showToPlayer(p);
                    }
                });
            }
           // if(i > 45) {

           // }
            i++;
        }
    }
}
