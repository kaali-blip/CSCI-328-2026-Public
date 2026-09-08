public class FacadeDemo {
    public static void main(String[] args) {
        // Create subsystem instances
        Order order = new Order();
        Cook cook = new Cook();
        Waiter waiter = new Waiter();
        Bill bill = new Bill();

        // Create the Facade
        RestaurantFacade restaurantFacade = new RestaurantFacade(order, cook, waiter, bill);

        // Use the Facade to place an order
        restaurantFacade.placeOrder("Spaghetti Bolognese");
    }
}
