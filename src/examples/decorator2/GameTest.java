package examples.decorator2;

public class GameTest {
    public static void main(String[] args) {
        Player warrior = new FireEnchant(new StrengthBuff(new Warrior()));
        System.out.println("Warrior Damage: " + warrior.getDamage());
    }

}
