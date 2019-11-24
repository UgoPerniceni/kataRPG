package esgi.kataRPG.Core.classes;

import esgi.kataRPG.Core.factions.Alliance;
import esgi.kataRPG.Core.factions.Horde;
import esgi.kataRPG.Core.factions.Faction;
import esgi.kataRPG.Core.jobs.Job;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CharacterRPG extends EntitieRPG{
    private Job job;
    private List<Faction> factions;

    public CharacterRPG(String name, String jobName) {
        super(name);
        job = new Job(jobName);
        factions = new ArrayList<Faction>();
    }

    public List<Faction> getFactions() {
        return factions;
    }

    public void setFactions(List<Faction> factions) {
        this.factions = factions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacterRPG that = (CharacterRPG) o;
        return getHealth() == that.getHealth() &&
                isAlive() == that.isAlive() &&
                Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getHealth());
    }

    public void attack(CharacterRPG character)
    {
        if (!character.equals(this))
        {
            if(character.isAlive())
            {
                if(this.sameFaction(character))
                    character.setHealth(character.getHealth() - 1);
                else
                    throw new IllegalArgumentException("Character must not be on the same faction");
            }
            else{
                throw new IllegalStateException("Character is dead.");
            }
        }
        else{
            throw new IllegalStateException("Character can't attack himself.");
        }

    }

    public void heal(CharacterRPG character)
    {
        if(character.isAlive())
        {
            if(this.sameFaction(character))
                character.setHealth(character.getHealth() + 1);
            else
                throw new IllegalArgumentException("Character must be on the same faction");
        }
        else{
            throw new IllegalStateException("Character is dead.");
        }

    }

    public void joinFaction(String factionName){
        if(factionName.equals("Alliance")){
            factions.add(new Alliance());
        }else if(factionName.equals("Horde")){
            factions.add(new Horde());
        }
        else{
            throw new IllegalArgumentException("Faction doesn't exist");
        }
    }

    public void leaveFaction(String factionName){
        factions.remove(factionName);
    }

    public boolean sameFaction(CharacterRPG character){
        for(Faction faction : this.getFactions()){
            if(faction.compareFactionToListOfFaction(character.getFactions())){
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        String Stringfactions = "[";

        for(Faction faction : factions){
            Stringfactions = Stringfactions + faction.getName() + ", ";
        }

        Stringfactions = Stringfactions.substring(0, Stringfactions.length() - 2);
        Stringfactions = Stringfactions + "]";

        return super.toString() + ", " +
                "job=" + job.getJobName() +
                ", faction(s)=" + Stringfactions;
    }
}
