package examples.factory_method2;

public class ChicagoPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String item) {
        Pizza pizza = null;
        if (item.equals("cheese")) {
            pizza = new ChicagoCheesePizza();
        } else if (item.equals("veggie")) {
            pizza =new ChicagoVeggiePizza();
        } 
        return pizza;
    }
}
