package exams.finalexam;

import java.util.Scanner;

public class OubliettesOfPeril {
    private static final int totalTextWidth = 80;
    private static boolean notEscaped = true;
    private static boolean moreDungeonToGo = true;
    private static boolean alwaysLookWhenMoving = true;
    private static boolean alwaysMapWhenMoving = true;

    public static void main(String[] args) {
        // This code should be refacted but there should be no difference for the end user
        // There are several "necessary updates and changes"
        // You should identify where design patterns will improve the architecture
        // in addition there are updates that should happen that are just base Object Oriented Design best practices and
        // and do not necessarily fall into a design pattern.
        boolean playGame = true;
        Scanner userInputScanner = new Scanner(System.in);
        while(playGame){
            greeting();
            playGame = enterTheDungeon(userInputScanner);
            if (playGame){                
                Player player = new Player();
                Dungeon dungeon = new Dungeon();
                notEscaped = true;
                moreDungeonToGo = true;
                System.out.println("Input 'commands' to see a list of commands");
                while(player.alive() && moreDungeonToGo && notEscaped){
                    
                    playerDecision(player, dungeon, userInputScanner);
                    moreDungeonToGo = !dungeon.beaten();
                }

                if(!moreDungeonToGo){
                    congratualtionsOnWinning(player);
                }

                if(!player.alive()){
                    playGame = sorryAboutLosing(userInputScanner, player);
                }
            }
        }

        userInputScanner.close();
    }

    private static void greeting(){
        lineOfText("*");
        displayTextWithStars("Welcome to the Oubliettes Of Peril (OOP)!");
        displayTextWithStars("In this oubliette you will find monsters, loot, and... peril!");
        displayTextWithStars("If you make it to the end, you can defeat the boss and escape!");
        displayTextWithStars(" ");
        lineOfText("*");
        displayTextWithStars("Each floor contains monsters, a boss, and a key.");
        displayTextWithStars("To advance you need to find the key and defeat the boss.");
        displayTextWithStars("Then you will be able to go to the next floor using the key in the boss room.");
        displayTextWithStars(" ");
        lineOfText("*");
    }

    private static void lineOfText(String text){
        char[] charArry = new char[totalTextWidth];
        String line = new String(charArry).replace("\0", text);
        System.out.println(line);
    }

    public static void commands(){
        System.out.println("You may use the following commands:");
        System.out.println("  - commands:     Shows this menu");
        System.out.println("  - look:         Looks around the room");
        System.out.println("  - al:           Toggle always look, when moving");
        System.out.println("  - check:        Look yourself");
        System.out.println("  - attack or a:  Attack an enemy if there is one");
        System.out.println("  - run or r:     Try to run from an enemy");
        System.out.println("  - map:          Look the map");
        System.out.println("  - am:           Toggle always map, when moving");
        System.out.println("  - bag:          Look in your bag");
        System.out.println("  - take:         Take an item if there is one");
        System.out.println("  - potion or p:  Use a health potion if you have one");
        System.out.println("  - equip:        Check your inventory and try to equip a new item");
        System.out.println("  - north or n:   Try to move north");
        System.out.println("  - south or s:   Try to move south");
        System.out.println("  - east or e:    Try to move east");
        System.out.println("  - west or w:    Try to move west");
        System.out.println("  - key:          Use the key on the dungeon trap door");
        System.out.println("  - rest:         Get some rest and heal. But be careful a monster can appear");
        System.out.println("  - exit:         Immediately escape the dungeon  dropping all your loot");
    }

    public static void displayTextWithStars(String displayText){
        String textFormat = "* %-" + (totalTextWidth -3) + "s*\n";
        System.out.printf(textFormat, displayText);
    }

    public static boolean enterTheDungeon(Scanner userInputScanner){
        String userInput;
        boolean shouldEnter = false;
        System.out.println("Do you wish to enter the oubliette?");
        userInput = userInputScanner.nextLine().trim();
        System.out.println("");
        if(yesChoice(userInput)){
            shouldEnter = true;
        } else {
            System.out.println("You never enter the oubliette, and you go home.");
            System.out.println("There was no peril, but also no riches.");
        }

        return shouldEnter;
    }

    private static void playerDecision(Player player, Dungeon dungeon, Scanner userInputScanner){
        lineOfText("-");
        System.out.println("What do you want to do?");
        String userInput = userInputScanner.nextLine().trim();
        System.out.println("");
        boolean advanceBattle = false; 
        
        if(userInput.equalsIgnoreCase("commands") || userInput.equalsIgnoreCase("command")){
            commands();
        } else if(userInput.equalsIgnoreCase("look")){
            System.out.println(dungeon.getCurrentRoom());
        } else if(userInput.equalsIgnoreCase("al")){
            alwaysLookWhenMoving = !alwaysLookWhenMoving;
        } else if(userInput.equalsIgnoreCase("am")){
            alwaysMapWhenMoving = !alwaysMapWhenMoving;
        } else if(userInput.equalsIgnoreCase("check")){
            System.out.println(player);
        } else if(userInput.equalsIgnoreCase("attack") || 
                  userInput.equalsIgnoreCase("a") ||
                  userInput.equalsIgnoreCase("run") ||
                  userInput.equalsIgnoreCase("r")){
            if(dungeon.getCurrentRoom().isEnemyInRoom()){
                 advanceBattle = true;
                 battle(player, dungeon, userInput);
            } else {
                System.out.println("There is no enemy alive in here. So you dont need to do that.");
            }
        } else if(userInput.equalsIgnoreCase("map")){
            dungeon.map();
        } else if(userInput.equalsIgnoreCase("bag")){
            player.checkBag();
        } else if(userInput.equalsIgnoreCase("take")){
            advanceBattle = true;
            if(dungeon.getCurrentRoom().isEnemyInRoom()){
                System.out.println("You foolishly try to grab the item right in front of the enemy.");
                System.out.println("It attacks you!");
            } else {
                if(dungeon.getCurrentRoom().itemInRoom()){
                    player.addItemToBag(dungeon.getCurrentRoom().takeRoomItem());
                } else {
                    System.out.println("There is no item in here.");
                }
            }
        } else if(userInput.equalsIgnoreCase("p") || userInput.equalsIgnoreCase("potion")){
            player.useHealthPotion();
            advanceBattle = true;
        } else if(userInput.equalsIgnoreCase("equip")){
            advanceBattle = true;
            System.out.println("What would you like to equip?");
            System.out.println("(Choose something from your bag)");
            String equipInput = userInputScanner.nextLine().trim();
            player.equipItem(equipInput);
        } else if(userInput.equalsIgnoreCase("north") || 
                  userInput.equalsIgnoreCase("n") || 
                  userInput.equalsIgnoreCase("south") || 
                  userInput.equalsIgnoreCase("s") || 
                  userInput.equalsIgnoreCase("east") || 
                  userInput.equalsIgnoreCase("e") ||
                  userInput.equalsIgnoreCase("west") ||  
                  userInput.equalsIgnoreCase("w")){
            if(dungeon.getCurrentRoom().isEnemyInRoom()){
                System.out.println("You cannot move while an enemy is in the room unless you run");
            } else {
                dungeon.movePlayer(userInput);
                if(alwaysMapWhenMoving){
                    dungeon.map();
                }
                if(alwaysLookWhenMoving){
                    System.out.println(dungeon.getCurrentRoom());
                }
            }
        } else if(userInput.equalsIgnoreCase("key")){
            if(dungeon.getCurrentRoom().getCanUseKey()){
                if(player.useKey()){
                    dungeon.newFloor();
                }
            } else {
                System.out.println("You cannot use a dungeon key in this room.");
            }

        } else if(userInput.equalsIgnoreCase("rest")){
            if(dungeon.getCurrentRoom().isEnemyInRoom()){
                System.out.println("You cannot rest while an enemy is in the room.");
            } else {
                player.rest();
                dungeon.getCurrentRoom().spawnNewEnemy();
            }

        } else if(userInput.equalsIgnoreCase("exit")){
            exitGame();
        } else {
            System.out.println("That was an invalid command.");
            System.out.println("Input the command - 'commands' to see a list of commands");
        } 

        if(advanceBattle && dungeon.getCurrentRoom().isEnemyInRoom() && !dungeon.getCurrentRoom().getEnemy().isDefeated()){
                int enemyDamage = dungeon.getCurrentRoom().getEnemy().getDamage();
                player.reduceHealth(enemyDamage);
        }      
    }

    private static void congratualtionsOnWinning(Player player){
        System.out.println("You have conquered the Oubliettes Of Peril!!");
        System.out.println("Congratulations!!!!");
        System.out.println("Score:");
        System.out.println(player.stats());
    }

    private static boolean sorryAboutLosing(Scanner userInputScanner, Player player){
        String userInput;
        boolean playAgain = false;
        System.out.println("Sorry. You have been defeated.");
        System.out.println("Would you like to play again?");
        userInput = userInputScanner.nextLine().trim();
        System.out.println("");
        if(yesChoice(userInput)){
            playAgain = true;
        } else {
            System.out.println("Thank you for playing! I hope you try again!");
            System.out.println("Goodbye!!");
        }

        return playAgain;
    }

    public static boolean yesChoice(String choice){
        boolean result = false;
        if(choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")){
            result = true;
        }
        return result;
    }

    public static boolean noChoice(String choice){
        boolean result = false;
        if(choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("no")){
            result = true;
        }
        return result;
    }

    private static void battle(Player player, Dungeon dungeon, String userInput){
        Enemy enemy = dungeon.getCurrentRoom().getEnemy();

        if(userInput.equalsIgnoreCase("attack") || userInput.equalsIgnoreCase("a")){
            int playerDamage = player.getDamage();
            player.gainXP(enemy.reduceHealth(playerDamage));
        } else if(userInput.equalsIgnoreCase("run") || userInput.equalsIgnoreCase("r")) {
            dungeon.playerRuns();
        }
    }

    private static void exitGame(){
        System.out.println("Using your escape rope you immediately leave the dungeon!");
        System.out.println("Sadly you had to leave all of your loot.\n\n");
        notEscaped = false;        
    }

}
