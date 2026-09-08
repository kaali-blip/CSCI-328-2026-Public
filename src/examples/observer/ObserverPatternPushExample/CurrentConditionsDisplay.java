public class CurrentConditionsDisplay implements WeatherObserver, WeatherDisplayElement {
    private float temperature;
    private float humidity;
    private WeatherData weatherData;

    public CurrentConditionsDisplay(WeatherData weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void update(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    public void display(){
        System.out.print("Current conditions: ");
        System.out.print(temperature);
        System.out.print("F degrees  and ");
        System.out.print(humidity);
        System.out.print("% humidity\n");
    }



}
