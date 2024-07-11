package de.jafe2211.mobbattle.Utility.Entity;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import static java.sql.Types.NULL;

public class EntityKilled {
    public EntityType entityType;
    public Entity entity;
    public int Count = 1;

    public EntityKilled(EntityType entityType){
        this.entityType = entityType;
    }
    public EntityType getEntityType() {
        return entityType;
    }

    public void setCount(int count) {
        Count = count;
    }

    public int getCount() {
        return Count;
    }
}
