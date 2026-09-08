package exams.finalexam;

import java.util.Random;

public class Dungeon {
    private int floor;
    private int size;
    private DungeonRoom[][] rooms;
    private int playerX = 0;
    private int playerY = 0;
    private DungeonRoom bossRoom;
    private Random random;

    public Dungeon(){
        floor = 1;
        size = 5;
        random = new Random();
        rooms =  new DungeonRoom[size][size];
        createRooms();
    }

    private void createRooms(){
        createBossAndKeyRooms();
        createPlayerSpawnRoom();
        for(int y = 0; y < rooms.length; ++y){
            for (int x = 0; x < rooms[y].length; x++) {
                if(rooms[y][x] == null){
                    rooms[y][x] = new DungeonRoom(floor, x, y, size);
                }
            }
        }
    }

    public void newFloor(){
        ++floor;
        System.out.println("\nYou descend down, deeper into the dungeon!");
        rooms =  new DungeonRoom[size][size];
        createRooms();
    }

    private void createBossAndKeyRooms(){
        Random random = new Random();
        int x = random.nextInt(size);
        int y = random.nextInt(size);
        rooms[y][x] = new DungeonRoom(floor, x, y, size, "key");
        boolean bossRoomEmpty = true;
        while(bossRoomEmpty){
            x = random.nextInt(size);
            y = random.nextInt(size);
            if(rooms[y][x] == null){
                rooms[y][x] = new DungeonRoom(floor, x, y, size, "boss");
                bossRoomEmpty = false;
                bossRoom = rooms[y][x];
            } 
        }
    }

    public boolean beaten(){
        return ((floor >= 5) && bossRoom.getEnemy().isDefeated());
    }

    private void createPlayerSpawnRoom(){
        Random random = new Random();
        int x;
        int y;
        boolean playerRoomEmpty = true;
        while(playerRoomEmpty){
            x = random.nextInt(size);
            y = random.nextInt(size);
            if(rooms[y][x] == null){
                rooms[y][x] = new DungeonRoom(floor, x, y, size, "player");
                playerRoomEmpty = false;
                playerX = x;
                playerY = y;
            } 
        }
    }

    public DungeonRoom getCurrentRoom(){
        return rooms[playerY][playerX];
    }

    public void movePlayer(String direction){
        switch (direction.toLowerCase()) {
            case "north":
            case "n":
                if(playerY <= 0){
                    System.out.println("There is no door to the " + direction.toLowerCase() + ", you cannot go that way.\n");
                } else {
                    System.out.println("You move " + direction.toLowerCase() + " into the next room.");
                    --playerY;
                }
                break;
            case "south":
            case "s":
                if(playerY >= (size - 1)){
                    System.out.println("There is no door to the " + direction.toLowerCase() + ", you cannot go that way.\n");
                } else {
                    System.out.println("You move " + direction.toLowerCase() + " into the next room.");
                    ++playerY;
                }
                break;
            case "east":
            case "e":
                if(playerX >= (size - 1)){
                    System.out.println("There is no door to the " + direction.toLowerCase() + ", you cannot go that way.\n");
                } else {
                    System.out.println("You move " + direction.toLowerCase() + " into the next room.");
                    ++playerX;
                }
                break;
            case "west":
            case "w":
                if(playerX <= 0){
                    System.out.println("There is no door to the " + direction.toLowerCase() + ", you cannot go that way.\n");
                } else {
                    System.out.println("You move " + direction.toLowerCase() + " into the next room.");
                    --playerX;
                }
                break;
            default:
                break;
        }

        getCurrentRoom().discoverRoom();
    }

    public void playerRuns(){
        int randomDirection = random.nextInt(4);
        String direction = "";
        switch (randomDirection) {
            case 0:
                direction = "north";
                break;
            case 1:
                direction = "south";
                break;
            case 2:
                direction = "east";
                break;
            case 3:
                direction = "west";
                break;
            
            default:
                break;
        }
        System.out.println("You try and run " + direction + "!");
        movePlayer(direction);
    }

    public void look(){
        System.out.println(getCurrentRoom());
    }

    public String toString(){
        StringBuffer dungeonInfo = new StringBuffer();
        dungeonInfo.append("\n");
        dungeonInfo.append("Dungeon size: ");
        dungeonInfo.append(size);
        dungeonInfo.append("\n");
        dungeonInfo.append("Player X/Y: ");
        dungeonInfo.append(playerX);
        dungeonInfo.append(", ");
        dungeonInfo.append(playerY);
        dungeonInfo.append("\n");
        for (DungeonRoom[] dungeonRooms : rooms) {
            for (DungeonRoom dungeonRoom : dungeonRooms) {
                dungeonInfo.append(dungeonRoom);
                dungeonInfo.append("\n");
            }
        }
        
        return dungeonInfo.toString();
    }

    public void map(){
        System.out.printf("Player Coordinates: X: %d, Y: %d \n", playerX, playerY);
        for(int y = 0; y < rooms.length; ++y){
            for (int x = 0; x < rooms[y].length; x++) {
                if (y == playerY && x == playerX) {
                    System.out.print("|X");
                } else {
                    System.out.print("|" +  rooms[y][x].getRoomIcon());
                }
                if(x == (rooms[y].length - 1)){
                        System.out.println("|");
                }
            }
        }
    }
}
