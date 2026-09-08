package assignments.singleton_pattern;
import assignments.singleton_pattern.ingredients.*;

public interface PizzaIngredientFactory {

    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Pepperoni createPepperoni();
    public Parmesan createParmesan();
}
