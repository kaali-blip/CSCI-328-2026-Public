package assignments.adapter_pattern;

public class VLCPlayer implements AdvancedMediaPlayer {
    public void decodeVideo(){
        System.out.println("Successfully Decoded VLC Video.");
    }

    public void decodeAdvancedAudio(){
        System.out.println("Successfully Decoded VLC Audio.");
    }

    public void playBackAudioVideo(){
        System.out.println("   /\\");
        System.out.println("  /__\\");
        System.out.println(" /____\\");
        System.out.println("/______\\");
        System.out.println("VLC Music and Video!!");
    }    
}