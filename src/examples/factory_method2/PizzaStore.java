package examples.factory_method2;

// Abstract Creator
public abstract class PizzaStore {
    public Pizza orderPizza(String type) {
        Pizza pizza;
        pizza = createPizza(type); // The factory method

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    // This is the Factory Method! Subclasses will implement this.
    protected abstract Pizza createPizza(String type);
}
