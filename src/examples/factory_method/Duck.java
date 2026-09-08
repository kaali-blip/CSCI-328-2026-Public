package examples.factory_method;

public abstract class Duck {
    // Product
    // This could be an abstract class or an interface depending
    String duckName;
    public Duck(){
        duckName = "plane";
    }

    public void fly(){
        System.out.printf("Look a %s is flying!!\n", duckName);
    }

    
}
