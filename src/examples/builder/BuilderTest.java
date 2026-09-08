package examples.builder;

public class BuilderTest {
    public static void main(String[] args) {
        Pizza pizza = new Pizza.Builder("large").cheese(true).pepperoni(true).bacon(true).build();

        System.out.println(pizza);
    }
}
