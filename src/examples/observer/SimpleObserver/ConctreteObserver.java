package examples.observer.SimpleObserver;

public class ConctreteObserver implements Observer{
    public void update(String event){
       System.out.printf("Received response: %s%n", event);
    }

}
