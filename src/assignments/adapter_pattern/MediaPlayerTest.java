package assignments.adapter_pattern;

import java.util.ArrayList;
import java.util.List;

public class MediaPlayerTest {
    
    public static void main(String[] args) {
            AudioMediaPlayer mp3Player = new MP3Player();
            AdvancedMediaPlayer mp4Player = new MP4Player();
            AdvancedMediaPlayer vlcPlayer = new VLCPlayer();

            //TODO: Add the AdvancedMediaPlayers to the list 
            List<AudioMediaPlayer> allAudioMediaPlayers = new ArrayList<>();

            allAudioMediaPlayers.add(mp3Player);

            for (AudioMediaPlayer audioMediaPlayer : allAudioMediaPlayers) {
                audioMediaPlayer.decodeAudio();
                audioMediaPlayer.playBackAudio();
            }
    }
}
