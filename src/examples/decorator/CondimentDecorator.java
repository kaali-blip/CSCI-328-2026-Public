public abstract class CondimentDecorator extends Beverage {
    // Needs to be interchangeble with beverage, so it extends from beverage
    // You could also implement Beverage

    //This is the berverage which we will be decorating.
    protected Beverage beverage;

    // We will want condiments to re-implement the get desc method,
    // so we make it abstract and remove the definition
    public abstract String getDescription();
}
