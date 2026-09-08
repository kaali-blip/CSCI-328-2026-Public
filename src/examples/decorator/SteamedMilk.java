public class SteamedMilk extends CondimentDecorator {
    // This is both a decorator and a beverage

    // we need to set the beverage for these.
    public SteamedMilk(Beverage beverage){
        this.beverage = beverage; // this is the beverage we are wrapping
    }

    public String getDescription(){
        return beverage.getDescription() + ", Steamed Milk";
    }
    
    public double cost(){
        return beverage.cost() + 0.10;
    }
}
