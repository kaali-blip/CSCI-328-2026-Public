import java.util.Scanner;

public class TemplateMethodRecipe {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String userChoice;

        System.out.println("Hello! We are going to learn how to make breakfast!");
        System.out.println("What do you want for breakfast?");
        System.out.println("Choose eggs or pancakes.");

        userChoice = userInput.nextLine();
        
        if(userChoice.equalsIgnoreCase("eggs")) {
            
            System.out.println("Gather your ingredients.");
            System.out.println("Get 2 eggs.");
            System.out.println("Get 1 tablespoon of butter.");
            System.out.println("Get salt.");
            System.out.println("Get pepper.");

            System.out.println("Prepare your food.");
            System.out.println("Crack the eggs into a bowl.");
            System.out.println("Wisk the eggs.");
            System.out.println("Melt butter in pan on medium heat.");
            System.out.println("When the butter is melted and hot, pour in eggs.");
            System.out.println("Fold eggs as they cook.");
            System.out.println("When eggs are cooked through turn off stove.");
            System.out.println("Add salt and pepper to taste.");
            
            System.out.println("Serve the food.");
            System.out.println("Serve on plate with any condiments you want.");
            System.out.println("Enjoy!");


        } else if (userChoice.equalsIgnoreCase("pancakes")) {
            System.out.println("Gather your ingredients.");
            System.out.println("Get 1 and 1/2 cups flour.");
            System.out.println("Get 3 and 1/2 teaspoons baking powder.");
            System.out.println("Get 2 tablespoon sugar.");
            System.out.println("Get 1 1/4 cups milk.");
            System.out.println("Get 3 tablespoons of melted butter.");
            System.out.println("Get 1 egg.");

            System.out.println("Prepare your food.");
            System.out.println("Sift flour, baking powder, sugar, and salt together in a large bowl.");
            System.out.println("Make a well in the center and add milk, melted butter, and egg.");
            System.out.println("Mix until smooth.");
            System.out.println("Heat a lightly oiled griddle or pan over medium-high heat.");
            System.out.println("Pour or scoop the batter onto the griddle, using approximately 1/4 cup for each pancake.");
            System.out.println("Cook until bubbles form and the edges are dry, about 2 to 3 minutes.");
            System.out.println("Flip and cook until browned on the other side.");
            System.out.println("Repeat with remaining batter.");

            System.out.println("Serve the food.");
            System.out.println("Serve on plate with any condiments you want.");
            System.out.println("Enjoy!");
        }

        System.out.println("Would you like coffee or tea as well?");
        userChoice = userInput.nextLine();
        
        if(userChoice.equalsIgnoreCase("coffee")) {
            System.out.println("Boil Water.");
            System.out.println("Drip hot water through filter and ground coffee.");
            System.out.println("Pour into cup.");
            
            System.out.println("Would you like milk and sugar with your coffee (y/n)?");
            
            userChoice = userInput.nextLine();
            
            if(userChoice.equalsIgnoreCase("y") || userChoice.equalsIgnoreCase("yes")) {
                System.out.println("Add milk and sugar.");
            }

        } else if (userChoice.equalsIgnoreCase("tea")) {
            System.out.println("Boil Water.");
            System.out.println("Steep the tea.");
            System.out.println("Pour into cup.");
        }

        System.out.println("Enjoy your Breakfast!");

        userInput.close();
    }
}
