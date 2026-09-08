package assignments.facade_pattern;

public class SoundSystem {
    private int volume = 0;

    public void turnOnSpeakers(){
        System.out.println("Speakers turned on");
    }
  
    public void turnOffSpeakers(){
        System.out.println("Speakers turned off");
    }
  
    public void lowerVolume(int numberDown){
        volume = volume - numberDown;
        volume = (volume < 0) ? 0 : volume;
        System.out.println("Volume lowered to " + volume);
    }
  
    public void raiseVolume(int numberUp){
        volume = volume + numberUp;
        System.out.println("Volume raised to " + volume);
    }
}
