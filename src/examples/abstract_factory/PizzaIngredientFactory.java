package examples.abstract_factory;
import examples.abstract_factory.ingredients.*;

public interface PizzaIngredientFactory {

    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Pepperoni createPepperoni();
    public Parmesan createParmesan();
}
