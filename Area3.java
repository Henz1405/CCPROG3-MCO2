/**
 * The Area3 class contains the map of Area three 
 * and its multiple floors, the starting position <br>
 * of the player, its name, and its index. 
 */

public class Area3 {
    private int playerRow = 9;//Player's starting Y position
    private int playerCol = 2;//Player's starting X position
    private String areaName="Elden Throne";//Area name
    private int areaIndex=3;//Area index

    public String getAreaName() {
        return areaName;
    }

    public int getAreaIndex() {
        return areaIndex;
    }

    private static char[][][] map3={
        {
            {'#', '#', '#', '#', '#'},
            {'#', '.', 'D', '.', '#'},
            {'#', '.', '.', '.', '#'},
            {'#', '.', '.', '.', '#'},
            {'#', '.', '.', '.', '#'},
            {'#', '.', '?', '.', '#'},
            {'#', '.', '.', '.', '#'},
            {'#', '.', '.', '.', '#'},
            {'#', '.', '.', '.', '#'},
            {'#', '.', 'F', '.', '#'},
            {'#', '#', '#', '#', '#'}
        },
        {
            {'#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', '#', '.', '.', 'D', '.', '.', '#', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '.', '.', 'B', '.', '.', '.', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '#', '.', '.', 'D', '.', '.', '#', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#'}
        },
        {
            {'#', '#', '#', '#', '#'},
            {'#', '.', 'C', '.', '#'},
            {'#', '?', '.', '?', '#'},
            {'#', '.', '.', '.', '#'},
            {'#', '?', '.', '?', '#'},
            {'#', '.', '.', '.', '#'},
            {'#', '?', '.', '?', '#'},
            {'#', '.', '.', '.', '#'},
            {'#', '?', '.', '?', '#'},
            {'#', '.', 'D', '.', '#'},
            {'#', '#', '#', '#', '#'}
        }
    };

    public char[][][] getMap3() {
        return map3;
    }

    public int getPlayerCol() {
        return playerCol;
    }

    public int getPlayerRow() {
        return playerRow;
    }
}
