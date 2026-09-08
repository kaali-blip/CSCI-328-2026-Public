package labs.abstract_factory;

public abstract class PizzaShop {
     public final Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);

        if (pizza != null) {
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }

        return pizza;
    }

    protected abstract Pizza createPizza(String type);
}
