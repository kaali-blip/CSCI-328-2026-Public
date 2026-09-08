package exams.finalexam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DungeonRoom {
    private static int nextRoomNumber = 1;
    private Random random = new Random();
    private Enemy roomEnemy;
    private boolean itemInRoom;
    private int enemyChance;
    private int itemChance;
    private int floorLevel;
    private String roomItem;
    private boolean bossRoom = false;
    private int roomNumber;
    private int roomX;
    private int roomY;
    private int dungeonSize;
    private String roomType;
    private boolean roomDiscovered = false;

    public DungeonRoom(int floorLevel, int roomX, int roomY, int dungeonSize){
        roomNumber = nextRoomNumber;
        enemyChance = 50;
        itemChance = 30;
        itemInRoom = false;
        roomItem = "";
        roomType = "normal";
        this.floorLevel = floorLevel;
        this.roomX = roomX;
        this.roomY = roomY;
        this.dungeonSize = dungeonSize;
        setChancesBasedOnFloorLevel();
        populateRoom();
        nextRoomNumber++;
    }

    public DungeonRoom(int floorLevel, int roomX, int roomY, int dungeonSize, String specialRoom){
        roomNumber = nextRoomNumber;
        itemInRoom = false;
        roomItem = "";
        this.roomType = specialRoom;
        this.floorLevel = floorLevel;
        this.roomX = roomX;
        this.roomY = roomY;
        this.dungeonSize = dungeonSize;
        populateSpecialRoom(specialRoom);
        nextRoomNumber++;
    }

    private void setChancesBasedOnFloorLevel(){
        switch (floorLevel) {
            case 1:
                enemyChance = 30;
                itemChance = 40;
                break;
            case 2:
                enemyChance = 45;
                itemChance = 50;
                break;
            case 3:
                enemyChance = 50;
                itemChance = 65;
                break;
            case 4:
                enemyChance = 60;
                itemChance = 75;
                break;
            case 5:
                enemyChance = 85;
                itemChance = 85;
                break;
            default:
                break;
        }
    }

    private void populateRoom(){
        int randomNumber = random.nextInt(100);

        if(randomNumber < enemyChance){
            roomEnemy = new Enemy(floorLevel);
        }

        randomNumber = random.nextInt(100);
        if(randomNumber < itemChance){
            setRoomItem();
        } else if(floorLevel > 4) {
            itemInRoom = true;
            roomItem = "bag of gold";
        }
    }

    public void spawnNewEnemy(){
        int randomNumber = random.nextInt(100);

        if(randomNumber < (enemyChance - 15)){
            System.out.println("An enemy attacks you while you rest!");
            roomEnemy = new Enemy(floorLevel);
        }
    }

    public boolean getCanUseKey(){
        boolean canUseKey = (roomType.equalsIgnoreCase("boss") && roomEnemy.isDefeated());
        return canUseKey;
    }

    private void populateSpecialRoom(String specialRoom){
        if (specialRoom.equals("player")){
            itemInRoom = false;
            roomItem = "";
            discoverRoom();
        } else if (specialRoom.equals("key")){
            populateKeyRoom();
        } else if (specialRoom.equals("boss")){
            bossRoom = true;
            roomEnemy = new Enemy(floorLevel, "boss");
            setBossRoomItem();
        } else {
            System.out.println("There was an error in room creation");
        }
    }

    private void populateKeyRoom(){
        int randomNumber = random.nextInt(100);

        if(randomNumber < enemyChance){
            roomEnemy = new Enemy();
        }
        roomItem = "dungeon key";
        itemInRoom = true;
    }

    private void setRoomItem(){
        int randomNumber = random.nextInt(100);
        itemInRoom = true;
        if(randomNumber < 20) {
            roomItem = "bag of gold";
        } else if(randomNumber < 45) {
            roomItem = "health potion";
        } else if(randomNumber < 65) {
            roomItem = "short sword";
        } else if(randomNumber < 75) {
            roomItem = "ax";
        } else if(randomNumber < 85) {
            roomItem = "long sword";
        } else if(randomNumber < 90) {
            roomItem = "greatsword";
        } else {
            roomItem = "armor part";
        }
    }

    private void setBossRoomItem(){
        int randomNumber = random.nextInt(100) + floorLevel * 5;
        if(randomNumber < 30) {
            roomItem = "short sword";
        } else if(randomNumber < 50) {
            roomItem = "ax";
        } else if(randomNumber < 70) {
            roomItem = "long sword";
        } else if(randomNumber < 85) {
            roomItem = "greatsword";
        } else {
            roomItem = "armor part";
        }
        itemInRoom = true;
    }

    public boolean itemInRoom(){
        return itemInRoom;
    }

    public String takeRoomItem(){
        String itemTaken = roomItem;
        roomItem = "";
        itemInRoom = false;
        return itemTaken;
    }

    public Enemy getEnemy(){
        return roomEnemy;
    }

    public String getRoomType(){
        return roomType; 
    }

    public boolean isEnemyInRoom(){
        return (roomEnemy != null) && (!roomEnemy.isDefeated());
    }

    public String getRoomIcon(){
        String  roomIcon = "?";
        if(roomDiscovered){
            if(roomType.equals("boss")){
                if(roomEnemy.isDefeated()){
                    roomIcon = "D";
                } else {
                    roomIcon = "B";
                }
            } else if((roomType.equals("key")) && itemInRoom){
                roomIcon = "K";
            } else if(roomEnemy != null && !roomEnemy.isDefeated()){
                roomIcon = "m";
             } else if(itemInRoom){
                roomIcon = "i";
            } else {
                roomIcon = " ";
            }

        }

        return roomIcon;
    }

    public void discoverRoom(){
        roomDiscovered = true;
    }

    public String toString(){
        StringBuffer roomInfo = new StringBuffer();

        List<String> directionList = new ArrayList<>();
        if(roomY != 0){
            directionList.add("north");
        }
        if(roomY != dungeonSize - 1){
            directionList.add("south");
        }
        if(roomX != dungeonSize - 1){
            directionList.add("east");
        }
        if(roomX != 0){
            directionList.add("west");
        }

        roomInfo.append("\nYou are on floor number ");
        roomInfo.append(floorLevel);
        roomInfo.append("\n");

        roomInfo.append("The room you are in has doors to the ");
        for(int i = 0; i < directionList.size(); ++i){
            roomInfo.append(directionList.get(i));
            if((directionList.size() > 2) && (i < directionList.size() - 1)){
                roomInfo.append(", ");
            } else if(i == directionList.size() - 1) {
                roomInfo.append(".");
            } else {
                roomInfo.append(" ");
            }

            if(i == directionList.size() - 2){
                roomInfo.append("and ");
            }
        }
        roomInfo.append("\n\n");
        if(roomEnemy != null){
            roomInfo.append(roomEnemy);
        } else {
            roomInfo.append("There are no enemies in this room.\n");
        }
        if(roomType.equals("boss")){
            roomInfo.append("\n** There is a locked trap door on the floor! **\n");
        }

        if(!roomItem.equals("")){
            roomInfo.append("    ** On the ground you see a(n) ");
            roomInfo.append(roomItem);
            roomInfo.append(". **\n");
        } else {
            roomInfo.append("There are no items in this room.\n");
        }
        
        return roomInfo.toString();
    }
}
