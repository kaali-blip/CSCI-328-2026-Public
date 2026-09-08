package examples.factory_method2;

// Product
public class NYVeggiePizza extends Pizza {
    public NYVeggiePizza(){
        name = "NY Style Sauce and Veggie Pizza";
        dough = "Thin Crust";
        sauce = "Marinara sauce";
        toppings.add("Fresh Mozzarella");
        toppings.add("Grated Parmesan Reggiano");
        toppings.add("Diced onion");
        toppings.add("Sliced mushrooms");
        toppings.add("Sliced red pepper");
        toppings.add("Sliced black olives");
    }
}
