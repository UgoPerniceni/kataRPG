package esgi.kataRPG.Core.classes;

import java.util.Random;

public class WarriorRPG extends CharacterRPG {
    public WarriorRPG(String name, String jobName) {
        super(name, jobName);
    }

    @Override
    public void attack(CharacterRPG character){

        if(character.isAlive())
            {
                if(!this.sameFaction(character))
                {
                    int randomDamage = new Random().nextInt(9);

                    character.setHealth(character.getHealth() - randomDamage);
                }
                else
                    throw new IllegalArgumentException("Character must not be on the same faction");

            }
            else{
                throw new IllegalStateException("Character is dead.");
            }
    }

    @Override
    public void heal(CharacterRPG character)
    {
        if(character.equals(this))
        {
            this.setHealth(character.getHealth() + 1);
        }
        else{
            throw new IllegalStateException("Character can only heal himself.");
        }

    }

    @Override
    public String toString() {
        return "WarriorRPG{} " + super.toString();
    }
}
