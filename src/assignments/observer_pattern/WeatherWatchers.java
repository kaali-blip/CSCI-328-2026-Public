package assignments.observer_pattern;

import java.util.Scanner;

public class WeatherWatchers {
    public static void main(String[] args) {
        String stargazer = "Stargazer";
        String birdwatcher = "Birdwatcher";
        String meteorologist = "Meteorologist";
        String hiker = "Hiker";
        
        String time_of_day = "0";
        String temperature = "0";
        String clouds = "0";

        String userInput = "";

        Scanner scnr = new Scanner(System.in);
        System.out.println("Hello! If you tell me the weather outside I can tell you what The Weather Watchers are doing!");
        System.out.println("To quit, type quit.");

        while(!userInput.equalsIgnoreCase("quit")){
            while(!userInput.equalsIgnoreCase("quit")){
                time_of_day = "0";
                System.out.println("\nWhat time of day is it? Enter the number");
                System.out.println("1) Morning");
                System.out.println("2) Noon");
                System.out.println("3) Evening");
                System.out.println("4) Night");
                
                userInput = scnr.nextLine().trim();
                if(userInput.equals("1") || userInput.equals("2") || userInput.equals("3") || userInput.equals("4") || userInput.equalsIgnoreCase("quit")){
                    time_of_day = userInput;
                    break;
                }
            }

            while(!userInput.equalsIgnoreCase("quit")){
                temperature = "0";
                System.out.println("\nWhat is the temperature out? Enter the number");
                System.out.println("1) Greater than 100F: VERY HOT!!!");
                System.out.println("2) 87F - 99F: Hot");
                System.out.println("3) 59F - 86F: Nice");
                System.out.println("4) 40F - 58F Cold");
                System.out.println("5) Below 39F: VERY COLD!");
                
                userInput = scnr.nextLine().trim();
                if(userInput.equals("1") || userInput.equals("2") || userInput.equals("3") || userInput.equals("4") || userInput.equals("5") || userInput.equalsIgnoreCase("quit")){
                    temperature = userInput;
                    break;
                }
            }

            while(!userInput.equalsIgnoreCase("quit")){
                clouds = "0";
                System.out.println("\nWhat are the clouds like? Enter the number");
                System.out.println("1) Clear skies!");
                System.out.println("2) Some nice clouds.");
                System.out.println("3) Cloudy.");
                System.out.println("4) Thunderstorm Clouds!");
                
                userInput = scnr.nextLine().trim();
                if(userInput.equals("1") || userInput.equals("2") || userInput.equals("3") || userInput.equals("4") || userInput.equalsIgnoreCase("quit")){
                    clouds = userInput;
                    break;
                }
            }

            System.out.println("");
            if (!userInput.equalsIgnoreCase("quit")){
                whatDoesEveryoneDo(time_of_day, temperature, clouds);
                System.out.println("\nType quit to quit and anything else to continue:");
                userInput = scnr.nextLine().trim();
            }
        }
    }

    public static void whatDoesEveryoneDo(String time_of_day, String  temperature, String  clouds){
        //TODO: Make event driven
        //TODO: Add other people
        // Stargazer
        if (time_of_day.equalsIgnoreCase("4")){
            if (temperature.equals("4") || temperature.equals("5")){
             System.out.println("The Stargazer is putting on a jacket.");
            }

            if(clouds.equals("1") || clouds.equals("2")){
                System.out.println("The Stargazer is enjoying the night sky");
            } else {
                System.out.println("The Stargazer is waiting for the clouds to clear");
            } 
           
        } else {
             System.out.println("The Stargazer is sleeping.");
        }

        // Birdwatcher
        if (!time_of_day.equalsIgnoreCase("4")){
            if (temperature.equals("4") || temperature.equals("5")){
             System.out.println("The Birdwatcher is putting on a jacket.");
            }

            if(clouds.equals("4")){
                System.out.println("The Birdwatcher is waiting inside for the storm to pass");
            } else {
                System.out.println("The Birdwatcher is excited to watch and record many birds!");
            } 
           
        } else {
             System.out.println("The Birdwatcher is sleeping.");
        }
    }
}
