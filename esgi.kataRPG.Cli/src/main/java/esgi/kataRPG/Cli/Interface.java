package esgi.kataRPG.Cli;

import esgi.kataRPG.Core.classes.CharacterRPG;
import esgi.kataRPG.Core.classes.WarriorRPG;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Interface {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int tour = 0 ;

        WarriorRPG Warrior1 = new WarriorRPG("Warrior1", "Bijoutier");
        Warrior1.joinFaction("Horde");
        WarriorRPG Warrior2 = new WarriorRPG("Warrior2", "Tailleur");
        Warrior2.joinFaction("Alliance");

        System.out.println("-----\n" + Warrior1.toString());
        System.out.println(Warrior2.toString()+ "\n-----\n");

        while(Warrior1.isAlive() && Warrior2.isAlive())
        {
            if(tour%2 == 0)
            {
                FunctionsMenu.printActions(Warrior1);
                try {
                    FunctionsMenu.CharacterAction(Warrior1, Warrior2, sc.nextInt());
                    tour++;
                } catch (InputMismatchException e) {
                    System.err.println("An integer is required.");
                    sc.nextLine();
                }
            }
            else
            {
                FunctionsMenu.printActions(Warrior2);
                try {
                    FunctionsMenu.CharacterAction(Warrior2, Warrior1, sc.nextInt());
                    tour++;
                }catch(InputMismatchException e){
                    System.err.println("An integer is required.");
                    sc.nextLine();
                }
            }
        }

        System.out.println("Game is over !");


    }
}
