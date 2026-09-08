package assignments.adapter_pattern;

public class MP4Player implements AdvancedMediaPlayer {
    public void decodeVideo(){
        System.out.println("Successfully Decoded MP4 Video");
    }

    public void decodeAdvancedAudio(){
        System.out.println("Successfully Decoded MP4 Audio");
    }

    public void playBackAudioVideo(){
        System.out.println("MP4 Music and Video Playback!");

    }

}
