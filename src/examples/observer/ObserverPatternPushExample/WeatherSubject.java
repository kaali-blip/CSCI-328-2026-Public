public interface WeatherSubject {
    public void registerObserver(WeatherObserver o);
    public void removeObserver(WeatherObserver o);
    // pushes the data to Observers
    public void notifyObservers();    
}