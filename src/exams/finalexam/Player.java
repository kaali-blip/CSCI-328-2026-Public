package exams.finalexam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {
    private int health;
    private int maxHealth;
    private int experience;
    private int neededExperience;
    private int level;
    private int strength;
    private String equippedWeapon;
    private List<String> itemBag;
    private Random random;
    private int armorValue;
    private int maxArmorValue;
    private String magicWeaponSpell;
    private int magicWeaponValue;
    private List<String> weaponList;
    private int goldBagWeightInGrams = 900;
    private int dollarsPerGramOfGold = 130;

    public Player(){
        maxHealth = 15;
        health = 15;
        magicWeaponValue = 0;
        experience = 0;
        neededExperience = 6;
        level = 1;
        armorValue = 0;
        strength = 3;
        maxArmorValue = 10;
        equippedWeapon = "fist";
        itemBag = new ArrayList<>();
        random = new Random();
        weaponList = new ArrayList<>();
        populateWeaponList();
    }

    private void populateWeaponList(){
        weaponList.add("short sword");
        weaponList.add("ax");
        weaponList.add("long sword");
        weaponList.add("greatsword");
    }

    public int getHealth(){
        return health;
    }

    public String getDisplayHealth(){
        String displayHealth = health + "/" + maxHealth; 
        return displayHealth;
    }

    public int getLevel(){
        return level;
    }

    public void reduceHealth(int damage){
        StringBuffer display = new StringBuffer();
        display.append("* * * * *\n");
        display.append("* Ouch! *\n");
        display.append("* * * * *\n");
        display.append("\n");
        
        damage = damage - armorValue;
        if(armorValue > 0){
            display.append("Your armor blocked some of the damage!\n");
        }
        damage = (damage <= 0) ? 0 : damage;

        display.append("You took ");
        display.append(damage);
        display.append(" damage.\n");
        health = health - damage;
        display.append("You are now at ");
        display.append(health);
        display.append(" health.\n");

        display.append(checkHealth());

        System.out.println(display);
    }

    private String checkHealth(){
        StringBuffer display = new StringBuffer();
        display.append("You feel ");
        
        if(health <= 0){
            display.append("the world slip away and everything goes dark.\n");
        } else if(health < (maxHealth / 4)){
            display.append("absolutely terrible.\n");
        } else if(health < (maxHealth / 2)){
            display.append("beat up.\n");

        } else {
            display.append("healthy.\n");
        }
        return display.toString();
    }

    public void gainHealth(int healing){
        int oldHealth = health;
        health = health + healing;
        health = (health > maxHealth) ? maxHealth : health;
        StringBuffer display = new StringBuffer();
        display.append("Your health went from ");
        display.append(oldHealth);
        display.append(" to ");
        display.append(health);
        System.out.println(display);
    }

    public void gainXP(int xpUp){
        if (xpUp > 0){
            System.out.println("You gained " + xpUp + " XP!");
            experience = experience + xpUp;
            while(experience >= neededExperience){
                experience = experience - neededExperience;
                gainLevel();
            }
        }
    }

    public String getDisplayXP(){
        String displayXP = experience + "/" + neededExperience; 
        return displayXP;
    }

    private void gainLevel(){
        ++level;
        StringBuffer display = new StringBuffer();
        int oldStrength = strength;
        strength = strength + random.nextInt(3) + level;
        int oldMaxHealth = maxHealth;
        int healthIncrease = random.nextInt(4) + (int)(level * 1.5);
        maxHealth = maxHealth + healthIncrease;
        health = health + healthIncrease;
        neededExperience = neededExperience + (int)(level * 1.5);

        display.append("\n#####################################\n");
        display.append("   You leveled up!!\n");
        display.append("   You are now level ");
        display.append(level);
        display.append("!\n");
        display.append("   Your strength went from ");
        display.append(oldStrength);
        display.append(" to ");
        display.append(strength);
        display.append("\n");
        display.append("   Your max health went from ");
        display.append(oldMaxHealth);
        display.append(" to ");
        display.append(maxHealth);
        display.append("\n");
        display.append("#####################################\n");

        getMagic();

        System.out.println(display);
    }

    public String getEquippedWeapon() {
        return equippedWeapon;
    }

    private void getMagic(){
        StringBuffer display = new StringBuffer();
        if(level == 3){
            display.append("\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");
            display.append("   You have learned how to harness the magic around you!\n");
            display.append("   You learn to protect yourself with magic!\n");
            display.append("\n       ** Mage Armor Learned **\n\n");
            armorValue++;
            maxArmorValue++;
            maxArmorValue++;
            display.append("   Armor: ");
            display.append(armorValue);
            display.append("/");
            display.append(maxArmorValue);
            display.append("\n");
            display.append("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\n");

        }
        if(level == 4){
            display.append("\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");
            display.append("   You have learned how use magic for fighting!\n");
            display.append("\n       ** Ice Enchant Learned **\n\n");
            magicWeaponSpell = "ice";
            magicWeaponValue = 2;
            display.append("   All weapon damage increased by ");
            display.append(magicWeaponValue);
            display.append("\n");
            display.append("   Equipped Weapon: ");
            display.append(magicWeaponSpell);
            display.append(" enchanted ");
            display.append(equippedWeapon);
            display.append(" (");
            display.append(getWeaponDamage(equippedWeapon));
            display.append(")");
            display.append("\n");
            display.append("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\n");
        }

        if(level == 5){
            display.append("\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");
            display.append("   You learn to protect yourself with magic even better!\n");
            display.append("\n       **  Mage Armor Improved **\n\n");
            armorValue++;
            armorValue++;
            maxArmorValue++;
            maxArmorValue++;
            display.append("   Armor: ");
            display.append(armorValue);
            display.append("/");
            display.append(maxArmorValue);
            display.append("\n");
            display.append("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\n");
        }

        if(level == 6){
            display.append("\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");
            display.append("   You have learned how use magic for fighting better!\n");
            display.append("\n       ** Ice Enchant Improved **\n\n");
            magicWeaponSpell = "absolute ice";
            magicWeaponValue = 5;
            display.append("   All weapon damage increased by ");
            display.append(magicWeaponValue);
            display.append("\n");
            display.append("   Equipped Weapon: ");
            display.append(magicWeaponSpell);
            display.append(" enchanted ");
            display.append(equippedWeapon);
            display.append(" (");
            display.append(getWeaponDamage(equippedWeapon));
            display.append(")");
            display.append("\n");
            display.append("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\n");
        }

        if(level == 9){
            display.append("\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");
            display.append("   You have learned how use magic for maximum damage!\n");
            display.append("\n       ** Ice Enchant Maximized **\n\n");
            magicWeaponSpell = "stygian ice";
            magicWeaponValue = 10;
            display.append("   All weapon damage increased by ");
            display.append(magicWeaponValue);
            display.append("\n");
            display.append("   Equipped Weapon: ");
            display.append(magicWeaponSpell);
            display.append(" enchanted ");
            display.append(equippedWeapon);
            display.append(" (");
            display.append(getWeaponDamage(equippedWeapon));
            display.append(")");
            display.append("\n");
            display.append("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\n");
        }

        System.out.println(display);
    }

    public void equipItem(String item){
        StringBuffer display = new StringBuffer();
        item = item.toLowerCase();
        if(itemBag.contains(item)){
            if(item.equals("armor part") || item.equals("armor"))
            {
                if(armorValue < maxArmorValue){
                    display.append("You take out a piece or armor and fasten it to yourself.\n");
                    armorValue++;
                    itemBag.remove(item);
                } else {
                    display.append("Your armor is as good as it can be.\n");
                }
            } else if (weaponList.contains(item)){
                String oldWeapon = equippedWeapon;
                if(!oldWeapon.equalsIgnoreCase("fist")){
                    display.append("You store your ");
                    display.append(oldWeapon);
                    display.append(" in your bag\n");
                    itemBag.add(oldWeapon);
                }
                if(itemBag.remove(item))
                {
                    display.append("You equip your ");
                    display.append(item);
                    equippedWeapon = item;
                    display.append(".\n");
                }
                
            } else {
                display.append("You cannot equip the ");
                display.append(item);
                display.append(".\n");
            }
        } else {
            display.append("You you do not have a ");
            display.append(item);
            display.append(".\n");
        }

        System.out.println(display);
    }

    public boolean hasKey(){
        return itemBag.contains("dungeon key");
    }

    public boolean useKey(){
        StringBuffer display = new StringBuffer();
        boolean keyUsed = false;

        keyUsed = itemBag.remove("dungeon key");
        if(keyUsed){
            display.append("You use your key on the lock to the trap door!");
        } else {
            display.append("You do not have a dungeon key");
        }
        
        System.out.println(display);
        return keyUsed;
    }

    public int getWeaponDamage(String weapon){
        int weaponDamage = 0;
        switch (weapon.toLowerCase()) {
            case "fist":
                weaponDamage = 1;
                break;
            case "short sword":
                weaponDamage = 2;
                break;
            case "ax":
                weaponDamage = 3;
                break;
            case "long sword":
                weaponDamage = 4;
                break;
            case "greatsword":
                weaponDamage = 5;
                break;
            default:
                break;
        }

        if(magicWeaponValue > 0){
            weaponDamage = weaponDamage + magicWeaponValue;
        }

        return weaponDamage;
    }

    public int getDamage(){
        int randomNumber = random.nextInt(strength);
        int damage = randomNumber + getWeaponDamage(equippedWeapon);

        StringBuffer display = new StringBuffer();
        display.append("\nYou attack with your ");
        if(magicWeaponValue > 0){
            display.append(magicWeaponSpell);
            display.append(" enchanted ");
        }
        display.append(equippedWeapon);
        display.append("!\n");
        System.out.println(display);

        return damage;
    }

    public void addItemToBag(String item){
        if(!item.equals("")){
            itemBag.add(item.toLowerCase());
            System.out.println("  - You put your " + item + " into your bag.");
        }
    }

    public void checkBag(){
        StringBuffer display = new StringBuffer();
        display.append("In your bag you have:\n");
        for (String item : itemBag) {
            display.append("  - ");
            display.append(item);
            if (weaponList.contains(item)){
                display.append(" (");
                display.append(getWeaponDamage(item));
                display.append(")");
            }
            display.append("\n");
        }
        System.out.println(display);
    }

    public void useHealthPotion(){
        if(itemBag.remove("health potion")){
            System.out.println("You drink a health potion!\n");
            int potionHealing = (int)(maxHealth / 4);
            int healing = random.nextInt(potionHealing) + potionHealing;
            gainHealth(healing);
        } else {
            System.out.println("Unfortunately you do not have a health potion...\n");
        }
    }

    public void rest(){
        StringBuffer display = new StringBuffer();
        display.append("You rest and regain some health.\n");
        int healing = random.nextInt(10) + 6;
        gainHealth(healing);

        System.out.println(display);
    }

    public boolean alive(){
        return (health > 0);
    }

    public int bagsOfGold(){
        int totalGoldBags = 0;
        for (String item : itemBag) {
            if(item.equalsIgnoreCase("bag of gold")){
                ++totalGoldBags;
            }
        }
        return totalGoldBags;
    }

    public String stats(){
        StringBuffer playerStats = new StringBuffer();
        int totalGoldBags = bagsOfGold();
        int moneyInDollars = totalGoldBags * goldBagWeightInGrams * dollarsPerGramOfGold; 
        playerStats.append(toString());
        playerStats.append("\nYou had a total of ");
        playerStats.append(totalGoldBags);
        playerStats.append(" bags of gold!\n");
        playerStats.append("");
        playerStats.append("Which means you left with roughly $");
        playerStats.append(moneyInDollars);
        playerStats.append(" in gold!!\n");
        playerStats.append("Great job!!");

        return playerStats.toString();
    }

    public String toString(){
        StringBuffer playerInfo = new StringBuffer();
        playerInfo.append("HP: ");
        playerInfo.append(getDisplayHealth());
        playerInfo.append("\n");
        playerInfo.append("Level: ");
        playerInfo.append(level);
        playerInfo.append(" XP: ");
        playerInfo.append(getDisplayXP());
        playerInfo.append("\n");
        playerInfo.append("Strength: ");
        playerInfo.append(strength);
        playerInfo.append("\n");
        playerInfo.append("Equipped Weapon: ");
        if(magicWeaponValue > 0){
            playerInfo.append(magicWeaponSpell);
            playerInfo.append(" enchanted ");
        }
        playerInfo.append(equippedWeapon);
        playerInfo.append(" (");
        playerInfo.append(getWeaponDamage(equippedWeapon));
        playerInfo.append(")");
        playerInfo.append("\n");
        playerInfo.append("Armor: ");
        playerInfo.append(armorValue);
        playerInfo.append("/");
        playerInfo.append(maxArmorValue);
        playerInfo.append("\n");
        playerInfo.append(checkHealth());

        return playerInfo.toString();
    }
}