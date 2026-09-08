import java.util.Iterator;

// The Client
public class Waiter {
    
    public Waiter(){}

    public void printMenu(){
        System.out.println("------ Breakfast ------");
        System.out.println("Pancake Breakfast, 2.99 -- Pancakes, eggs, & toast");
        System.out.println("Sausage and Pancakes, 2.99 -- Pancakes, eggs, and sausage");
        System.out.println("Waffles, 2.99 -- Three waffles.");
        System.out.println("Cereal, 1.49 -- Not frosted flakes...");
        System.out.println("------ Dinner ------");
        System.out.println("Vegetarian BLT, 2.99 -- Fake 'N bacon, lettuce, & tomato on whole wheat.");
        System.out.println("BLT, 2.99 -- Bacon, lettuce, & tomato on whole wheat.");
        System.out.println("Soup  of the Day, 3.49 -- Our wonderful soup of the day, it's usually chili.      ");
        System.out.println("Hot Dog, 1.49 -- A hot dog on a bun, not very interesting.");
    }

    private void printMenu(MyIterator myIterator){
    }

    private void printMenu(Iterator iterator){
    }
}
