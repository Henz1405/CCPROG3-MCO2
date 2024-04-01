

/**
 * The Area1 class contains the map of Area one 
 * and its multiple floors, the starting position <br>
 * of the player, its name, and its index. 
 */
public class Area1 {

    private int playerRow = 7;//Player's starting Y position
    private int playerCol = 2;//Player's starting X position
    private String areaName="Stormveil Castle";//Area name
    private int areaIndex=1;//Area index

    public int getAreaIndex() {
        return areaIndex;
    }

    public String getAreaName() {
        return areaName;
    }

    private static char[][][] map1 = {
        {
        {'#', '#', '#', '#', '#'},
        {'#', '.', 'D', '.', '#'},
        {'#', '?', '.', '?', '#'},
        {'#', '.', '.', '.', '#'},
        {'#', '.', '.', '.', '#'},
        {'#', '.', '.', '.', '#'},
        {'#', '.', '.', '.', '#'},
        {'#', '.', 'F', '.', '#'},
        {'#', '#', '#', '#', '#'}
        },
        {
        {'#', '#', '#', '#', '#', '#', '#', '#', '#'},
        {'#', '.', '.', '.', 'D', '.', '.', '.', '#'},
        {'#', '.', '.', '.', '?', '.', '.', '.', '#'},
        {'#', '.', '.', '.', '.', '.', '.', '.', '#'},
        {'#', '?', '.', '?', '?', '?', '.', '?', '#'},
        {'#', '.', '.', '.', '.', '.', '.', '.', '#'},
        {'#', '.', '.', '?', '.', '?', '.', '.', '#'},
        {'#', '.', '.', '.', 'D', '.', '.', '.', '#'},
        {'#', '#', '#', '#', '#', '#', '#', '#', '#'}
        },
        {
        {'#', '#', '#', '#', '#', '#', '#'},
        {'#', '.', '.', 'F', '.', '.', '#'},
        {'#', '.', '.', '.', '.', '.', '#'},
        {'#', '.', '.', '.', '.', '.', '#'},
        {'#', '.', '.', 'B', '.', '.', '#'},
        {'#', '.', '.', '.', '.', '.', '#'},
        {'#', '.', '.', '.', '.', '.', '#'},
        {'#', '.', '.', 'D', '.', '.', '#'},
        {'#', '#', '#', '#', '#', '#', '#'}
        }
    };

    public char[][][] getMap1() {
        return map1;
    }
    

    public int getPlayerCol() {
        return playerCol;
    }

    public int getPlayerRow() {
        return playerRow;
    }

    
}
