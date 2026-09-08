public interface Menu {
    // interface for collection / Aggregate
    // Make this so that it can use a user made Iterator or Java's iterator
    public void addItem(String name, String description, boolean vegetarian, double price);
    
    // public createIterator();
}
