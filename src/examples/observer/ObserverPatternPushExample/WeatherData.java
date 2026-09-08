import java.util.ArrayList;
import java.util.List;

public class WeatherData implements WeatherSubject {
    private List<WeatherObserver> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList<WeatherObserver>();
    }

    public void registerObserver(WeatherObserver o){
        observers.add(o);
    }

    public void removeObserver(WeatherObserver o){
        observers.remove(o);
    }

    // Pushes the data to the observers
    public void notifyObservers(){
        for(WeatherObserver observer : observers){
            observer.update(temperature, humidity, pressure);
        }
    }

    public void measurementsChanged(){
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
