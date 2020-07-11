package sample;

import java.lang.management.PlatformLoggingMXBean;
import java.util.*;

public class CharacterManager {
    public final List<AllCharacterProperties>PLAYER=new ArrayList<>();
    public final List<AllCharacterProperties>COllIDE=new ArrayList<>();
    private final Set<AllCharacterProperties>REMOVED_CHARACTERS=new HashSet<>();

    public List<AllCharacterProperties> getPLAYER() {
        return PLAYER;
    }

    public List<AllCharacterProperties> getCOllIDE() {
        return COllIDE;
    }

    public Set<AllCharacterProperties> getREMOVED_CHARACTERS() {
        return REMOVED_CHARACTERS;
    }

    //addingPlayer
    public void addPlayer(AllCharacterProperties...obj){
       PLAYER.addAll(Arrays.asList(obj));
    }
    //RemovingPlayer
    public void removePlayer(AllCharacterProperties...obj){
        PLAYER.removeAll(Arrays.asList(obj));
    }

    public Set getRemovedActors() {
        return REMOVED_CHARACTERS;
    }

}
