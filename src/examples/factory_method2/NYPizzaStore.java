package examples.factory_method2;

public class NYPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String item) {
        Pizza pizza = null;
        if (item.equals("cheese")) {
            pizza = new NYCheesePizza(); // Specific NY-style pizza
        } else if (item.equals("veggie")) {
            pizza =new NYVeggiePizza();
        } 
        return pizza;
    }
}
