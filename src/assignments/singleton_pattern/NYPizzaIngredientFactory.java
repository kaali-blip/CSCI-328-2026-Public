package assignments.singleton_pattern;

import assignments.singleton_pattern.ingredients.*;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new Marinara();
    }

    @Override
    public Cheese createCheese() {
        return new Mozzarella();
    }

    @Override
    public Pepperoni createPepperoni(){
        return new Pepperoni();
    }

    @Override
    public Parmesan createParmesan(){
        return new Parmesan();
    }
}
