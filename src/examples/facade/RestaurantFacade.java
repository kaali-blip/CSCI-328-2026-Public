public class RestaurantFacade {
    private Order order;
    private Cook cook;
    private Waiter waiter;
    private Bill bill;

    public RestaurantFacade(Order order, Cook cook, Waiter waiter, Bill bill) {
        this.order = order;
        this.cook = cook;
        this.waiter = waiter;
        this.bill = bill;
    }

    // Simplified method to place an order
    public void placeOrder(String dish) {
        System.out.println("Placing order...");
        order.takeOrder(dish);      // Take the order
        cook.cookFood(dish);              // Cook the food
        waiter.serveFood(dish);           // Serve the food to the customer
        bill.generateBill(dish);    // Generate the bill for the dish
    }
}
