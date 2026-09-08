package examples.builder2;

public interface IBicycleBuilder {
    public Bicycle getBicycleInstance();
    public void setColor(String color);
    public void setHeight(String height);
    public void setRoadType(String roadType);
    public void reset();
}
