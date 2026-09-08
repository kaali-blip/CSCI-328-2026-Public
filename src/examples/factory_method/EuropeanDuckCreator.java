package examples.factory_method;
import java.util.Random;


public class EuropeanDuckCreator extends DuckCreator {
    // This is where the benefit of the Factory method lies. 
    // If object creation is complex, and you only need one group of objects
    // This extracts away the object creation logic from the client
    public Duck createDuck(){
        Random randomDuck = new Random(System.currentTimeMillis());
        int duckChoice = randomDuck.nextInt(2);

        Duck duck;
        if (duckChoice == 1){
            duck = new OrpingtonDuck();
        } else {
            duck = new RouenDuck();
        }
        
        return duck;
    }

}
