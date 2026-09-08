package examples.observer.SimpleObserver;

public class ObserverDemo {
    public static void main(String[] args) {
        System.out.println("Enter Text: ");
        EventSource eventSource = new EventSource();
        Observer cObserver = new ConctreteObserver();
        eventSource.addObserver(cObserver);

        eventSource.scanSystemIn();
    }
}
