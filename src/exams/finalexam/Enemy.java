package exams.finalexam;

import java.util.Random;

public class Enemy {
    private int health;
    private int maxHealth;
    private int experience;
    private int gold;
    private int item;
    private int strength;
    private int weaponDamage;
    private String weapon;
    private boolean defeated;
    private String enemyType;
    private int floorLevel;
    private Random random;

    public Enemy(){
        maxHealth = 3;
        health = 3;
        experience = 2;
        enemyType = "Goblin";
        defeated = false;
        weapon = "claws";
        weaponDamage = 0;
        strength = 2;
        floorLevel = 0;
        random = new Random();
    }

    public Enemy(int floorLevel){
       this();
       this.floorLevel = floorLevel;
       createEnemy();
    }

    public Enemy(int floorLevel, String boss){
        this();
        maxHealth = 20;
        health = 20;
        experience = 8;
        enemyType = "Dragon";
        this.floorLevel = floorLevel;
        createBossEnemy();
    }

    public int getHealth(){
        return health;
    }

    public String getDisplayHealth(){
        String displayHealth = health + "/" + maxHealth; 
        return displayHealth;
    }

    public int reduceHealth(int damage){
        int experienceRecieved = 0;
        health = health - damage;
        System.out.println("The " + enemyType + " took " + damage + " damage!");
        checkHealth();
        if(health <= 0){
            creatureDies();
            experienceRecieved = experience;
        }
        return experienceRecieved;
    }

    private void checkHealth(){
        StringBuffer display = new StringBuffer();
        display.append("The ");
        display.append(enemyType);
        display.append(" looks ");
        if(health < (maxHealth / 4)){
            display.append("absolutely terrible.\n");
            if(health <= 0){
                display.append("It staggers, and falls to the ground.\n");
            }
        } else if(health < (maxHealth / 2)){
            display.append("beat up.\n");

        } else {
            display.append("healthy.\n");
        }
        System.out.println(display);
    }

    private void creatureDies(){
        System.out.println("  ** Congratulations!! You have defeated the " + enemyType + "!! ** \n");
        defeated = true;
    }

    public void gainHealth(int healing){
        health = health + healing;
        health = (health > maxHealth) ? maxHealth : health;
    }

    public int getDamage(){
        int randomNumber = random.nextInt(strength);
        int damage = randomNumber + weaponDamage;
        StringBuffer display = new StringBuffer();

        display.append("The ");
        display.append(enemyType);
        display.append(" attacks you with it's ");
        display.append(weapon);
        display.append(".\n\n");

        System.out.println(display);

        return damage;
    }

    public boolean isDefeated(){
        return defeated;
    }

    private void createEnemy(){
       int randomNumber = random.nextInt(10);

       if(floorLevel < 5){
            if(randomNumber < 4){
                enemyType = "Goblin";
                maxHealth = 4;
                health = 4;
                strength = 2;
                weapon = "goblin dagger";
                weaponDamage = 1;
                experience = 3;
            } else if(randomNumber < 6){
                enemyType = "Giant Spider";
                maxHealth = 6;
                health = 6;
                strength = 2;
                weapon = "fangs";
                weaponDamage = 2;
                experience = 5;
            } else if(randomNumber < 8){
                enemyType = "Giant Rat";
                maxHealth = 6;
                health = 6;
                strength = 1;
                weapon = "claws";
                weaponDamage = 1;
                experience = 4;
            } else {
                enemyType = "Zombie";
                maxHealth = 10;
                health = 10;
                strength = 2;
                weapon = "fists";
                weaponDamage = 2;
                experience = 6;
            }
        } else {
            createSubBossEnemy();
        }

        adjustDifficulty(floorLevel);
    }

    private void createSubBossEnemy(){
        int randomNumber = random.nextInt(10);

        if(randomNumber < 4){
            enemyType = "Ogre";
            maxHealth = 14;
            health = 14;
            strength = 5;
            weapon = "fists";
            weaponDamage = 1;
            experience = 8;
        } else if(randomNumber < 6){
            enemyType = "Skeleton Knight";
            maxHealth = 12;
            health = 12;
            strength = 2;
            weapon = "rusted sword";
            weaponDamage = 4;
            experience = 9;
        } else if(randomNumber < 8){
            enemyType = "Skelton Mage";
            maxHealth = 9;
            health = 9;
            strength = 9;
            weapon = "magic curse";
            weaponDamage = 1;
            experience = 10;
        } else {
            enemyType = "Dragon";
            maxHealth = 15;
            health = 15;
            strength = 6;
            weapon = "fire breath";
            weaponDamage = 5;
            experience = 12;
        }
    }

    private void createBossEnemy(){
        

        if(floorLevel == 5){
            enemyType = "Hell Balor";
            maxHealth = 250;
            health = 250;
            strength = 40;
            weapon = "evil flaming sword";
            weaponDamage = 13;
            experience = 200;
        } else {
            createSubBossEnemy();
            adjustDifficulty(floorLevel);
        }
    }

    private void adjustDifficulty(int floorLevel){
        if (floorLevel > 1){
            int randomNumber = random.nextInt(floorLevel * 20) + floorLevel * 5;
            if((floorLevel == 5) && randomNumber > 110){
                enemyType = "Cosmic Hellborne " + enemyType;
                maxHealth = (maxHealth + 20) * 4;
                health = (health + 20) * 4;
                strength = (strength + 6) * 2;
                weaponDamage = (weaponDamage + 6) * 2;
                experience = experience + 20;
            } else if(randomNumber > 70){
                enemyType = "Infernal " + enemyType;
                maxHealth = (maxHealth + 15) * 2;
                health = (health + 15) * 2;
                strength = strength + 15;
                weaponDamage = weaponDamage + 10;
                experience = experience + 12;
            } else if(randomNumber > 45){
                enemyType = "Nightmare " + enemyType;
                maxHealth = maxHealth + 15;
                health = health + 15;
                strength = strength + 2;
                weaponDamage = weaponDamage + 2;
                experience = experience + 7;
            } else if(randomNumber > 30){
                enemyType = "Deep " + enemyType;
                maxHealth = maxHealth + 3;
                health = health + 3;
                strength = strength + 1;
                weaponDamage = weaponDamage + 1;
                experience = experience + 4;
            }
        }
    }   

    public String toString(){
        StringBuffer enemyInfo = new StringBuffer();
        enemyInfo.append("In front of you is a ");
        if(isDefeated()){
            enemyInfo.append("dead ");    
        }
        enemyInfo.append(enemyType);
        enemyInfo.append(".\n");
        if(isDefeated()){
            enemyInfo.append("It has been defeated and lies on the floor.\n");
        } else {
            enemyInfo.append("It looks at you angrily, ready to attack with it's ");
            enemyInfo.append(weapon);
            enemyInfo.append(".\n");
        }
        enemyInfo.append("\n");

        return enemyInfo.toString();
    }
}
