public class Whip extends CondimentDecorator {
    // This is both a decorator and a beverage

    // we need to set the beverage for these.
    public Whip(Beverage beverage){
        this.beverage = beverage; // this is the beverage we are wrapping
    }

    public String getDescription(){
        return beverage.getDescription() + ", Whip";
    }
    
    public double cost(){
        return beverage.cost() + 0.10;
    }
}
