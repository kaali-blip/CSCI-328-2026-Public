package labs.abstract_factory;

public class PepperoniPizza extends Pizza {
     PizzaIngredientFactory ingredientFactory;

    public PepperoniPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        toppings.add(ingredientFactory.createParmesan());
        toppings.add(ingredientFactory.createPepperoni());


    }
}
