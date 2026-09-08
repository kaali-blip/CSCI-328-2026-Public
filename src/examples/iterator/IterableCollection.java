package examples.iterator;

// The Aggregate Interface
public interface IterableCollection<T> {
    Iterator<T> createIterator();
}
