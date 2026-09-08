package examples.factory_method;

public abstract class DuckCreator {
    //Creator

    // This is the creation logic specific to the type of creator
    // Can be public or private depending on the need
    public abstract Duck createDuck();

    // In the factory method, creator's primary responsiblity is not exactly
    // object creation, but rather the deligation of that creation so that a sublcass
    // can change the logic of creation depending on different factors. 
    public void watchDucksFly(){
        Duck duck = createDuck();
        duck.fly();
    }
}
