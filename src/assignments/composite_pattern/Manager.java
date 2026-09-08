package assignments.composite_pattern;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private final String name;
    private final String position;
    private List<StaffMember> team = new ArrayList<>();

    public Manager(String name, String position){
        this.name = name;
        this.position = position;
    }

    public void add(StaffMember teamMember){
        team.add(teamMember);
    }

    public void display(){
        System.out.printf("(%s) %s \n", position, name);
        for (StaffMember staffMember : team) {
            staffMember.display("   ");
        }
    }

    public void display(String indentAmount){
        System.out.printf("%s(%s) %s \n", indentAmount, position, name);
        for (StaffMember staffMember : team) {
            staffMember.display(indentAmount + "   ");
        }
    }
}
