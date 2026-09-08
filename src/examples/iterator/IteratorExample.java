package examples.iterator;

import java.util.ArrayList;
import java.util.List;

public class IteratorExample {
    // The main serves as the client
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 50000));
        employees.add(new Employee("Bob", 60000));
        employees.add(new Employee("Charlie", 70000));

        Company company = new Company(employees);
        Iterator<Employee> iterator = company.createIterator();

        double totalSalary = 0;
        while (iterator.hasNext()) {
            Employee currentEmployee = iterator.next();
            System.out.println(currentEmployee.toString()); 
            totalSalary += currentEmployee.getSalary();
        }

        System.out.println("Total salary: " + totalSalary);
    }

}
