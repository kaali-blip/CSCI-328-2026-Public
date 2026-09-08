import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StatisticsDisplay implements WeatherObserver, WeatherDisplayElement {
    private List<Float> temperatures;
    private WeatherData weatherData;


    public StatisticsDisplay(WeatherData weatherData){
        this.weatherData = weatherData;
        this.temperatures = new ArrayList<Float>();
        weatherData.registerObserver(this);
    }

    public void update(float temperature, float humidity, float pressure){
        this.temperatures.add(temperature);
        sevenDayMax();
        display();
    }

    public void display(){
        System.out.print("Min temp: ");
        System.out.print(Collections.min(temperatures));
        System.out.print("F degrees\nMax temp: ");
        System.out.print(Collections.max(temperatures));
        System.out.print("F degrees\nAverage: ");
        System.out.print(avgTemperature());
        System.out.print(" over "+ temperatures.size() +" days\n");

    }

    private void sevenDayMax(){
        if(temperatures.size() > 7){
            temperatures.remove(0);
        }
    }

    private float avgTemperature(){
        float total = 0;
        for(int i = 0; i < temperatures.size(); ++i){
            total = total + temperatures.get(i);
        }
        return total / temperatures.size();
    }

}
