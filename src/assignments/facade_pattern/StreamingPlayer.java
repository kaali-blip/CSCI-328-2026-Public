package assignments.facade_pattern;

public class StreamingPlayer {
    public void turnOnSteamingPlayer(){
        System.out.println("Streaming Player turned on");
    }
  
    public void turnOffSteamingPlayer(){
        System.out.println("Streaming Player turned off");
    }

    public void findMovie(){
        System.out.println("Found a movie to watch!");
    }
    
    public void startMovie(){
        System.out.println("Movie started");
    }

    public void pauseMovie(){
        System.out.println("Movie paused");
    }
    
    public void resumeMovie(){
        System.out.println("Movie resumed");
    }
}
