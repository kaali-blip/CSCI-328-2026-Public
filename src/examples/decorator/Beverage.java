public abstract class Beverage {
    protected String description = "Unknown Beverage";

    public String getDescription(){
        return description;
    }

    public abstract double cost();

    public void showDescCost(){
        System.out.printf("%s $%.2f\n", getDescription(), cost());
    }
}