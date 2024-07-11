package de.jafe2211.mobbattle.Utility.Entity;

import org.bukkit.entity.EntityType;

import java.util.ArrayList;

public class KilledEntitys {

    static ArrayList<EntityKilled> KilledEntitysRed = new ArrayList<>();
    static ArrayList<EntityKilled> KilledEntitysBlue = new ArrayList<>();

    public static void addEntity(EntityKilled entity, int team){
        if(team == 0){
            if(!(hasEntry(entity.getEntityType(), team))){
                KilledEntitysRed.add(entity);
                return;
            }
            addOne(entity.getEntityType(), team);
        }
        if(team == 1){
            if(!(hasEntry(entity.getEntityType(), team))){
                KilledEntitysBlue.add(entity);
                return;
            }
            addOne(entity.getEntityType(), team);
        }
    }
    public static ArrayList<EntityKilled> getEntitys(int team){
        if(team == 0) {
            return KilledEntitysRed;
        }
        if(team == 1) {
            return KilledEntitysBlue;
        }
        return null;
    }
    public static Boolean hasEntry(EntityType entityType, int team){
        for (EntityKilled entity : getEntitys(team)){
            if(entity.getEntityType().equals(entityType)){
                return true;
            }
        }
        return false;
    }
    public static int hasEntryAtPlace(EntityType entityType, int team){
        int count = 0;
        for (EntityKilled entity : getEntitys(team)){
            if(entity.getEntityType().equals(entityType)){
                return count;
            }
            count++;
        }

        return -1;
    }
    public static void addOne(EntityType entityType, int team){
        if(team == 0) {
            int Entry = hasEntryAtPlace(entityType, team);
            EntityKilled entity = KilledEntitysRed.get(Entry);
            entity.Count = entity.Count + 1;
            KilledEntitysRed.set(Entry, entity);
        }
        if(team == 1) {
            int Entry = hasEntryAtPlace(entityType, team);
            EntityKilled entity = KilledEntitysBlue.get(Entry);
            entity.Count = entity.Count + 1;
            KilledEntitysBlue.set(Entry, entity);
        }
    }
    public static EntityKilled getSpecificEntity(EntityType type, int team){
        for(EntityKilled entity : getEntitys(team)){
            if(entity.getEntityType() == type){
                return entity;
            }
        }
        return null;
    }


}
