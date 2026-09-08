package labs.command_pattern;

public class LightOffCommand implements Command{
    // Conctrete Command Class
    Light light;

    public LightOffCommand(Light light){
        this.light = light;
    }

    public void execute(){
        light.off();
    }
}
