package assignments.facade_pattern;

public class MovieTest {
    public static void main(String[] args) {
        PopcornMaker popcornMaker = new PopcornMaker();
        TheaterLights theaterLights = new TheaterLights();
        ProjectorTV projectorTV =  new ProjectorTV();
        SoundSystem soundSystem = new SoundSystem();
        StreamingPlayer streamingPlayer = new StreamingPlayer();

        /*TODO:
            Get ready: 
                - turn on lights
                - fill popcorn maker
                - turn on TV
                - turn on sound system
                - turn on streaming player
                - find a movie
                - pop popcorn
            Play movie:
                - get popcorn
                - turn off lights
                - turn up volume to 20
                - start movie
            
            Pause movie:
                - turn down volume to 5
                - pause movie
                - turn on lights
                - make more popcorn
            
            Resume movie:
                - get popcorn
                - turn off lights
                - turn up volume to 20
                - resume movie

            Finish movie:
                - Turn theater things off
                - Turn on lights
        */
    }
}
