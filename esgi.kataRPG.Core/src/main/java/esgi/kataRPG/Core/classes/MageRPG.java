package esgi.kataRPG.Core.classes;

import java.util.Random;

public class MageRPG extends CharacterRPG{
    public MageRPG(String name, String jobName) {
        super(name, jobName);
    }
    @Override
    public void attack(CharacterRPG character){
        if(character.isAlive())
        {

            if(!this.sameFaction(character))
            {
                character.setHealth(character.getHealth() - 0);
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
        int randomHeal = new Random().nextInt((10 - 5) + 1) + 5;

        this.setHealth(character.getHealth() + randomHeal);
    }
}
