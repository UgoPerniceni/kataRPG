package esgi.kataRPG.Cli;

import esgi.kataRPG.Core.classes.CharacterRPG;
import esgi.kataRPG.Core.classes.EntitieRPG;

public class FunctionsMenu {
    public static void printActions(CharacterRPG character) {
        System.out.println(
                character.getName() + " play : \n" +
                "1:Attack\n" +
                "2:Heal\n" +
                "3:Leave");
    }
}
