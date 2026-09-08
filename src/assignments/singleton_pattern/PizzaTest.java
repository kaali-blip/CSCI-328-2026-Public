package assignments.singleton_pattern;

public class PizzaTest {
    public static void main(String[] args) {
        PizzaShop shop = new NYPizzaShop();

        Pizza pizza = shop.orderPizza("cheese");

        System.out.println(pizza);
    }
}
