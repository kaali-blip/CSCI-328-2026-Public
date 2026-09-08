package labs.command_pattern;

public class Client {
    public static void main(String[] args) {
        Light livingRoomLight = new Light("Living Room");
        Light kitchenRoomLight = new Light("Kitchen Room");
        RemoteControl remoteControl = new RemoteControl();

        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
        LightOnCommand kitchenRoomLightOn = new LightOnCommand(kitchenRoomLight);
        LightOffCommand kitchenRoomLightOff = new LightOffCommand(kitchenRoomLight);

        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remoteControl.setCommand(1, kitchenRoomLightOn, kitchenRoomLightOff);

        System.out.println(remoteControl);

        remoteControl.pushOnButton(0);
        remoteControl.pushOffButton(0);
        remoteControl.pushOnButton(1);
        remoteControl.pushOffButton(1);
    }
}
