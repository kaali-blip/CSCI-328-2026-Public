package assignments.composite_pattern;

public class StaffMember {
    private final String name;
    private final String position;

    public StaffMember(String name, String position){
        this.name = name;
        this.position = position;
    }

    public void display(){
        System.out.printf("(%s) %s \n", position, name);
    }

    public void display(String indentAmount){
        System.out.printf("%s(%s) %s \n", indentAmount, position, name);
    }

}
