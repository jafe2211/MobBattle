package de.jafe2211.mobbattle.Utility.Entity;

import org.bukkit.entity.EntityType;

import java.util.ArrayList;

public class KilledEntitysWave {

    static ArrayList<EntityKilled> RedWave1 = new ArrayList<>();
    static ArrayList<EntityKilled> RedWave2 = new ArrayList<>();
    static ArrayList<EntityKilled> RedWave3 = new ArrayList<>();
    static ArrayList<EntityKilled> BlueWave1 = new ArrayList<>();
    static ArrayList<EntityKilled> BlueWave2 = new ArrayList<>();
    static ArrayList<EntityKilled> BlueWave3 = new ArrayList<>();

    public static ArrayList<EntityKilled> getWave(int wave, int team) {
        if (team == 0) {
            switch (wave) {
                case 1:
                    return RedWave1;
                case 2:
                    return RedWave2;
                case 3:
                    return RedWave3;
            }
        }
        if (team == 1) {
            switch (wave) {
                case 1:
                    return BlueWave1;
                case 2:
                    return BlueWave2;
                case 3:
                    return BlueWave3;
            }
        }


        return null;
    }
    public static int getWaveCount(EntityType entityType, int team) {
        int count = 0;
        for (int i = 1; i < 4; i++) {
            for(EntityKilled entity : getWave(i, team)){
                if(entity.getEntityType() == entityType){
                    count = count + entity.getCount();
                }
            }
            i++;
        }
        return count                       ;
    }
    public static int getWaveCountExsact(EntityType type, int wave, int team) {
        for (EntityKilled entity : getWave(wave, team)) {
            if(entity.getEntityType().equals(type)){
                return entity.getCount();
            }
        }
        return 0;
    }
    public static boolean hasEntry(EntityType type, int wave, int team){
        for (EntityKilled entity : getWave(wave, team)) {
            if(entity.getEntityType() == type) return true;
        }
        return false;
    }
    public static int hasEntryAtPlace(EntityType type, int wave, int team){
        int count = 0;
        for(EntityKilled entity : getWave(wave, team)){
            if(entity.getEntityType() == type) return count;
            count++;
        }
        return -1;
    }
    public static void addWaveEntity(EntityType type, int wave, int team){
        if(!(hasEntry(type,wave, team))){
            getWave(wave,team).add(new EntityKilled(type));
        } else {
            EntityKilled entityKilled = getWave(wave, team).get(hasEntryAtPlace(type, wave, team));
            entityKilled.Count = entityKilled.Count + 1;
            getWave(wave, team).set(hasEntryAtPlace(type, wave, team), entityKilled);
        }
    }
    public static void removeWaveEntity(EntityType type, int wave, int team){
        if(hasEntry(type,wave, team)){
            EntityKilled entityKilled = getWave(wave,team).get(hasEntryAtPlace(type, wave, team));
            if(entityKilled.getCount() > 0) {
                entityKilled.Count = entityKilled.Count - 1;
                getWave(wave, team).set(hasEntryAtPlace(type, wave, team), entityKilled);

            }

        }

    }

}