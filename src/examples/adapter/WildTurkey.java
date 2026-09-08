package examples.adapter;

// Adaptee
public class WildTurkey implements Turkey {
    public void gobble(){
        System.out.println("Gobble gobble");
    }

    public void fly(){
        System.out.println("I can fly!!!! But only short distances");
    }
}
