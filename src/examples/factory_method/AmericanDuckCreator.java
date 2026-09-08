package examples.factory_method;

public class AmericanDuckCreator extends DuckCreator {
    // Only one kind of american Duck
    public Duck createDuck(){
        Duck duck = new MallardDuck();

        return duck;
    }
}
