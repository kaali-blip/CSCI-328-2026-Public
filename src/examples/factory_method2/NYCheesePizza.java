package examples.factory_method2;

// Product
public class NYCheesePizza extends Pizza {
    public NYCheesePizza(){
        name = "NY Style Sauce and Cheese Pizza";
        dough = "Thin Crust";
        sauce = "Marinara Pizza Sauce";
        toppings.add("Fresh Mozzarella");
        toppings.add("Grated Parmesan Reggiano");
    }
}
