package examples.abstract_factory;
import examples.abstract_factory.ingredients.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
    protected String name;
    protected Dough dough;
    protected Sauce sauce;
    protected Cheese cheese;
    protected List<Topping> toppings = new ArrayList<>();

    public abstract void prepare();

    public void bake() {
        System.out.println("Bake for 25 minutes");

    }

    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices");

    }

    public void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public void setName(String name){
        this.name = name;
    }

    public String toString(){
        StringBuffer output = new StringBuffer();
        output.append("A ");
        output.append(dough);
        output.append(" ");
        output.append(name);
        output.append(" with ");
        output.append(sauce);
        output.append(" and ");
        output.append(cheese);
        if (toppings.size() > 0)
        {
            output.append(", topped with");
            for (Topping topping : toppings) {
                output.append(" ");
                output.append(topping);
            }
            
        }
        output.append(".");

        return output.toString();
    }
}
