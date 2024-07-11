package de.jafe2211.mobbattle.Listeners;

import de.jafe2211.mobbattle.Main;
import de.jafe2211.mobbattle.Utility.Entity.EntityKilled;
import de.jafe2211.mobbattle.Utility.Entity.KilledEntitys;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class KillEvent implements Listener {

    @EventHandler
    public void onEntityKill(EntityDeathEvent event){

        EntityType killedEntityType = event.getEntityType();
        Player p = event.getEntity().getKiller();

        try {
            if (Main.team1.hasEntry(p.getName())) {
                KilledEntitys.addEntity(new EntityKilled(killedEntityType), 1);
            }
            if (Main.team2.hasEntry(p.getName())) {
                KilledEntitys.addEntity(new EntityKilled(killedEntityType), 0);
            }
        } catch (Exception e){

        }
    }
}
