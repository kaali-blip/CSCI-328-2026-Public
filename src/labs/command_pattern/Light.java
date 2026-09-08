package labs.command_pattern;

public class Light {
    // Receiver
    String name = "light";

    public Light(String name){
        this.name = name;
    }

    public void on(){
        System.out.println("The " + name + " is on!");
    }

    public void off(){
        System.out.println("The " + name + " is off!");
    }
}
