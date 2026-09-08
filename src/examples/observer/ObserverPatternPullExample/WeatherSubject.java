public interface WeatherSubject {
    public void registerObserver(WeatherObserver o);
    public void removeObserver(WeatherObserver o);
    public void notifyObservers();    
}