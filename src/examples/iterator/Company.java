package examples.iterator;

import java.util.List;

public class Company  implements IterableCollection<Employee>{
    // Concrete Collection / Aggregate
    private List<Employee> employees;

    public Company(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public Iterator<Employee> createIterator() {
        return new EmployeeIterator(employees);
    }
}
