package labs.oop_review;

import java.util.Scanner;

public class AnimalProgram {
    public static void main(String[] args) {
        String animalType1;
        String animalType1name = "capybara";
        String animalType1FoodBehavior = "herbivore";
        String animalType1Sound = "Squeak";

        String animalType2;
        String animalType2name = "lion";
        String animalType2FoodBehavior = "carnivore";
        String animalType2Sound = "Roar!!";
        Scanner scnr = new Scanner(System.in);
        
        System.out.println("Enter two kinds of animals you want to know about:");
        animalType1 = scnr.nextLine();
        animalType2 = scnr.nextLine();

        if (animalType1.equals("capybara")) {
            System.out.println("Capybaras are a kind of " + animalType1FoodBehavior);
            System.out.println("They make a " + animalType1Sound);
        }

        if (animalType2.equals("lion")) {
            System.out.println("Lions are a kind of" + animalType2FoodBehavior);
            System.out.println("They make a " + animalType2Sound);
        }

        //TODO: Add Alligator and Hawk
    }
}
