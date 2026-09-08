package examples.adapter;

public class BirdWatching {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        Turkey turkey = new WildTurkey();
        Duck TurkeyAdapter = new TurkeyAdapter(turkey);
        
        System.out.println("Turkey: ");
        turkey.gobble();
        turkey.fly();

        System.out.println("Duck:");
        testDuck(mallard);

        System.out.println("Adapter");
        testDuck(TurkeyAdapter);
    }

    public static void testDuck(Duck duck){
        duck.quack();
        duck.fly();
    }
}
