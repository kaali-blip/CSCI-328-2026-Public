package assignments.singleton_pattern;

public class NYPizzaShop extends PizzaShop {
    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        final PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

        if (type.equalsIgnoreCase("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("New York Style Cheese Pizza");
        } else if (type.equalsIgnoreCase("pepperoni")) {
            pizza = new PepperoniPizza(ingredientFactory);
            pizza.setName("New York Style Pepperoni Pizza");
        }


        return pizza;
    }
}