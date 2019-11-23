package esgi.kataRPG.Core.classes;

import esgi.kataRPG.Core.factions.Alliance;
import esgi.kataRPG.Core.factions.Horde;
import esgi.kataRPG.Core.factions.Faction;
import esgi.kataRPG.Core.jobs.Job;

import java.util.Objects;

public class CharacterRPG extends EntitieRPG{
    private Job job;
    private Faction faction = null;

    public CharacterRPG(String name, String jobName) {
        super(name);
        job = new Job(jobName);
    }

    public Faction getFaction() {
        return faction;
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
                if(!this.getFaction().sameFaction(character.getFaction()))
                    character.setHealth(character.getHealth() - 1);
                else
                    throw new IllegalArgumentException("Character is on the same faction.");
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
            if(this.getFaction().sameFaction(character.getFaction()))
                character.setHealth(character.getHealth() + 1);
            else
                throw new IllegalStateException("Character must be on the same faction.");
        }
        else{
            throw new IllegalStateException("Character is dead.");
        }

    }

    public void joinFaction(String factionName){
        if(factionName.equals("Alliance")){
            this.faction = new Alliance();
        }else if(factionName.equals("Horde")){
            this.faction = new Horde();
        }
        else{
            throw new IllegalArgumentException("Faction doesn't exist");
        }
    }

    public void leaveFaction(String factionName){
        this.faction = null;
    }
}
