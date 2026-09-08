package assignments.composite_pattern;

public class EmployeeHieratchyTest {
    public static void main(String[] args) {

        //TODO: Display the company heirarchy
        Manager ceo = new Manager("Jane", "CEO");
        Manager linda = new Manager("Linda", "Manager");
        Manager harry = new Manager("Harry", "Manager");
        Manager doreen = new Manager("Doreen", "Manager");
        
        StaffMember bob = new StaffMember("Bob", "Staff");
        StaffMember charlie = new StaffMember("Charlie", "Staff");
        StaffMember alice = new StaffMember("Alice", "Staff");
        StaffMember william = new StaffMember("William", "Staff");
        StaffMember sandra = new StaffMember("Sandra", "Staff");
        StaffMember luke = new StaffMember("Luke", "Staff");
        StaffMember walter = new StaffMember("Walter", "Staff");
        StaffMember sam = new StaffMember("Sam", "Staff");
        StaffMember beth = new StaffMember("Beth", "Staff");
        
        // TODO: Fix and uncomment the following code
        // ceo.add(linda);
        // ceo.add(harry);
        // linda.add(doreen);
        linda.add(bob);
        linda.add(charlie);
        linda.add(alice);
        harry.add(william);
        harry.add(luke);
        harry.add(sandra);
        doreen.add(walter);
        doreen.add(sam);
        doreen.add(beth);
        ceo.display();
    }
}
