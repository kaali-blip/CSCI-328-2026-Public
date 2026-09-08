package examples.decorator2;

public class StrengthBuff extends PlayerDecorator {
    
    public StrengthBuff(Player player) { 
        super(player); 
    }

    public int getDamage() {
        return player.getDamage() + 5;
    }
}
