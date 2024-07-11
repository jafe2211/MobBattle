package de.jafe2211.mobbattle.Listeners;

import de.jafe2211.mobbattle.Main;
import de.jafe2211.mobbattle.menu.ConfigWaveStart;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Collections;

import static de.jafe2211.mobbattle.Main.prefix;

public class JoinLeve implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        e.setJoinMessage(""+ ChatColor.DARK_GRAY + "[" + ChatColor.DARK_GREEN + ChatColor.BOLD + "+" + ChatColor.RESET + ChatColor.DARK_GRAY + "] " + ChatColor.WHITE + p.getName());

        ItemStack clock = new ItemStack(Material.CLOCK);
        ItemMeta clockMeta = clock.getItemMeta();
        clockMeta.setDisplayName("" + ChatColor.AQUA + ChatColor.BOLD + "Config");
        clockMeta.setLore(Collections.singletonList(ChatColor.DARK_PURPLE + "Linksklicken um Menü zu öffnen!"));
        clock.setItemMeta(clockMeta);

        if(!(p.getPersistentDataContainer().has(new NamespacedKey(Main.getInstance(), "MobBattle.config.GameState"), PersistentDataType.INTEGER))){
            p.getPersistentDataContainer().set(new NamespacedKey(Main.getInstance(), "MobBattle.config.GameState"), PersistentDataType.INTEGER, 0);
        }
        if(p.getPersistentDataContainer().has(new NamespacedKey(Main.getInstance(), "MobBattle.config.GameState"), PersistentDataType.INTEGER)){
            if(p.getPersistentDataContainer().get(new NamespacedKey(Main.getInstance(), "MobBattle.config.GameState"), PersistentDataType.INTEGER) == 0){
                p.getInventory().clear();
                p.getInventory().setItem(4, clock);
                p.setGameMode(GameMode.SURVIVAL);
            }
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        Player p = e.getPlayer();
        e.setQuitMessage(""+ ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + ChatColor.BOLD + "-" + ChatColor.RESET + ChatColor.DARK_GRAY + "] " + ChatColor.WHITE + p.getName());
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        Player p = e.getPlayer();

        ItemStack clock = new ItemStack(Material.CLOCK);
        ItemMeta clockMeta = clock.getItemMeta();
        clockMeta.setDisplayName("" + ChatColor.AQUA + ChatColor.BOLD + "Config");
        clockMeta.setLore(Collections.singletonList(ChatColor.DARK_PURPLE + "Linksklicken um Menü zu öffnen!"));
        clock.setItemMeta(clockMeta);

        if(p.getPersistentDataContainer().get(new NamespacedKey(Main.getInstance(), "MobBattle.config.GameState"), PersistentDataType.INTEGER) == 0) {
            p.getInventory().setItem(4, clock);
            p.setHealth(20);
            p.setSaturation(10);
        }
        if(p.getPersistentDataContainer().get(new NamespacedKey(Main.getInstance(), "MobBattle.config.GameState"), PersistentDataType.INTEGER) == 2) {
            new ConfigWaveStart(p).showToPlayer(p);
            p.setHealth(20);
            p.setSaturation(10);
           // e.setCancelled(true);
        }
        if(p.getPersistentDataContainer().get(new NamespacedKey(Main.getInstance(), "MobBattle.config.GameState"), PersistentDataType.INTEGER) == 3) {
            if(!(p.getGameMode() == GameMode.CREATIVE)){
                e.setCancelled(true);
            }
        }

    }
}
