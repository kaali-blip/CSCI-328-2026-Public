package examples.iterator;

public class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        String employeeInfo = "Name: " + getName() + ", Yearly Salary: " + salary;
        return employeeInfo;
    }
}
