package examples.factory_method2;

// Product
public class ChicagoCheesePizza extends Pizza {
    public ChicagoCheesePizza(){
        name = "Chicago Style Deep Dish Pizza";
        dough = "Extra thick crust";
        sauce = "Plum Tomato Sauce";
        toppings.add("Shredded Fresh Mozzarella");
    }

    public void cut(){
        System.out.println("Cutting the pizza into square slices");
    }
}
