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

    //Observers pull data
    public void notifyObservers(){
        for(WeatherObserver observer : observers){
            observer.update();
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

    public float getTemperature(){
        return this.temperature;
    }

    public float getHumidity(){
        return this.humidity;
    }

    public float getPressure(){
        return this.pressure;
    }
}
