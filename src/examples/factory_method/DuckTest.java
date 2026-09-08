package examples.factory_method;

public class DuckTest {
    public static void main(String[] args) {
        DuckCreator americanDucks = new AmericanDuckCreator();
        DuckCreator europeanDucks = new EuropeanDuckCreator();

        americanDucks.watchDucksFly();
        europeanDucks.watchDucksFly();
    }

}
