package examples.decorator2;

public class FireEnchant extends PlayerDecorator {
    public FireEnchant(Player player) { 
        super(player); 
    }
    
    public int getDamage() {
        return player.getDamage() + 10;
    }

}
