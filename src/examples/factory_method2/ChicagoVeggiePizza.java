package examples.factory_method2;

// Product
public class ChicagoVeggiePizza extends Pizza {
    public ChicagoVeggiePizza(){
        name = "Chicago Style Deep Dish Pizza";
        dough = "Extra thick crust";
        sauce = "Plum Tomato Sauce";
        toppings.add("Shredded Fresh Mozzarella");
        toppings.add("Diced onion");
        toppings.add("Sliced mushrooms");
        toppings.add("Sliced red pepper");
        toppings.add("Sliced black olives");
    }
    
    public void cut(){
        System.out.println("Cutting the pizza into square slices");
    }
}
