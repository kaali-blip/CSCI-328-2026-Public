import java.util.ArrayList;
import java.util.Scanner;

public class StrategyGame {
    public static void main(String[] args) {
        String knight = "Knight";
        String archer = "Archer";
        String mage = "Mage";
        Scanner userInput = new Scanner(System.in);
        String chosenCharacter;

        ArrayList<String> playerCharacters = new ArrayList<>();

        playerCharacters.add(knight);
        playerCharacters.add(archer);
        playerCharacters.add(mage);

        System.out.println("Hello!");
        System.out.println("What class are you?");
        System.out.println("Choose:");
        System.out.print("\t");
        for (String playerChar : playerCharacters) {
            System.out.print(playerChar + " ");
        }
        System.out.println("");

        chosenCharacter = userInput.nextLine();

        System.out.println("Oh no! A Dragon!!!");
        System.out.println("           ,  ,");
        System.out.println("           \\\\ \\\\");
        System.out.println("           ) \\\\ \\\\    _p_");
        System.out.println("           )^\\))\\))  /  *\\");
        System.out.println("            \\_|| || / /^`-'");
        System.out.println("   __       -\\ \\\\--/ /");
        System.out.println(" <'  \\___/   ___. )'");
        System.out.println("      `====\\ )___/\\\\");
        System.out.println("           //     `\"");
        System.out.println("           \\    /  \\");

        System.out.println("Attack it!!");

        if(chosenCharacter.equalsIgnoreCase(knight)) {
            System.out.println("The " + knight + " swings a sword!");

        } else if  (chosenCharacter.equalsIgnoreCase(archer)) {
            System.out.println("The " + archer + " shoots an arrow!");


        } else if  (chosenCharacter.equalsIgnoreCase(mage)) {

            System.out.println("The " + mage + " casts a fireball!");
            
        } else {
            System.out.println("You did not choose a character we have!");
        }
        // TODO Add more characters like a rogue and a barbarian
        // And implement a way to change weapons

        userInput.close();
    }
}
