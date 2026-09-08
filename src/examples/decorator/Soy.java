public class Soy extends CondimentDecorator {
    // This is both a decorator and a beverage

    // we need to set the beverage for these.
    public Soy(Beverage beverage){
        this.beverage = beverage; // this is the beverage we are wrapping
    }

    public String getDescription(){
        return beverage.getDescription() + ", Soy";
    }
    
    public double cost(){
        return beverage.cost() + 0.15;
    }
}
