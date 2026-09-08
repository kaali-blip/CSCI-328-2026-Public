package examples.decorator2;

public abstract class PlayerDecorator implements Player {
    protected Player player;
    
    public PlayerDecorator(Player player) {
        this.player = player;
    }
}
