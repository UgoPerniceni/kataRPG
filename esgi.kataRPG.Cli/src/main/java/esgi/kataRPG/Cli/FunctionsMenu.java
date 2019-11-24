package esgi.kataRPG.Cli;

import esgi.kataRPG.Core.classes.CharacterRPG;
import esgi.kataRPG.Core.classes.EntitieRPG;

public class FunctionsMenu {
    public static void printActions(CharacterRPG character) {
        System.out.println(
                character.toString() + " play : \n" +
                "1:Attack\n" +
                "2:Heal\n" +
                "0:Quit game");
    }

    public static void CharacterAction(CharacterRPG character, CharacterRPG ennemy, int numberAction){
        switch(numberAction){
            case 1:
                character.attack(ennemy);
                break;
            case 2:
                character.heal(character);
                break;
            case 0:
                System.exit(0);
                break;
        }
    }
}
