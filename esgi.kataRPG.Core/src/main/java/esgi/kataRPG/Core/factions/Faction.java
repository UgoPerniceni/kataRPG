package esgi.kataRPG.Core.factions;

import java.util.List;
import java.util.Objects;

public class Faction {
    private String name;

    private List<Faction> friends;

    public Faction() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addFactionAsFriend(Faction faction){
        if(friends.contains(faction) && !this.equals(faction))
            this.friends.add(faction);
        else
            throw new IllegalArgumentException("Faction doesn't exist");
    }

    public void deleteFactionAsFriend(Faction faction){
        if(friends.contains(faction) && !this.equals(faction))
            this.friends.remove(faction);
        else
            throw new IllegalArgumentException("Faction doesn't exist");
    }

    public List<Faction> getFriends(){
        return this.friends;
    }
    public boolean sameFaction(Faction faction){
        if(this.equals(faction) || this.friends.contains(faction))
            return false;
        else
            return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faction faction = (Faction) o;
        return Objects.equals(name, faction.name) &&
                Objects.equals(friends, faction.friends);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, friends);
    }
}
