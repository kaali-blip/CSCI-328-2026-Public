package assignments.adapter_pattern;

public class MP3Player implements AudioMediaPlayer {
    public void decodeAudio(){
        System.out.println("Successfully Decoded MP3 Audio");
    }

    public void playBackAudio(){
        System.out.println("Music is playing!");
    }
}
