

/**
 * This class contains a list of coordinates for <br>
 * all the spawn tiles in the areas. 
 */
public class spawnTileCoordinates {
    private int[][] areaOneSpawnTiles={
        {0, 2, 1, 1},
        {0, 2, 3, 1},
        {1, 4, 1, 1},
        {1, 4, 3, 1},
        {1, 4, 4, 1},
        {1, 4, 5, 1},
        {1, 4, 7, 1},
        {1, 2, 4, 1},
        {1, 6, 3, 1},
        {1, 6, 5, 1}
    };//The list of spawn tiles for area 1

    private int[][] areaTwoSpawnTiles={
        {0, 4, 1, 1},
        {0, 4, 3, 1},
        {1, 2, 1, 1},
        {1, 4, 1, 1},
        {1, 6, 1, 1},
        {2, 2, 3, 1},
        {2, 6, 3, 1},
        {3, 1, 3, 1},
        {3, 1, 5, 1},
        {3, 3, 3, 1},
        {3, 3, 5, 1},
        {4, 3, 2, 1},
        {4, 3, 4, 1},
        {4, 3, 6, 1},
        {4, 5, 2, 1},
        {4, 5, 6, 1},
        {4, 7, 2, 1},
        {4, 7, 6, 1}
    };

    private int[][]areaThreeSpawnTiles={
        {0, 5, 2, 1},
        {2, 2, 1, 1},
        {2, 2, 3, 1},
        {2, 4, 1, 1},
        {2, 4, 3, 1},
        {2, 6, 1, 1},
        {2, 6, 3, 1},
        {2, 8, 1, 1},
        {2, 8, 3, 1}
    };

    /**
     * Returns the list of all the area one coordinates 
     * Each element in the sub-array represents the properties 
     * of the spawntiles. 
     * 
     * The first element in the sub-array is the current floor, <br>
     * the second and third element are the rows and columns <br>
     * the spawntile is located at. And the last element 
     * represents its status, 0 being disabled, and 1 being
     * enabled.  
     * 
     * @return The list of all the area one coordinates
     */

    public int[][] getAreaOneSpawnTiles() {
        return areaOneSpawnTiles;
    }

    public int[][] getAreaTwoSpawnTiles() {
        return areaTwoSpawnTiles;
    }

    public int[][] getAreaThreeSpawnTiles() {
        return areaThreeSpawnTiles;
    }

    /**
     * This method is used to reset the status of the
     * spawntiles once the player exits the area. It
     * re-enables all the spawntiles by changing the last
     * element of the subarray of the spawntile into 1. 
     * 
     * @param map  The map of the area that is currently used. 
     */

    public void resetStatus(char[][][] map)
    {
        /*This for loop iterates through the sub-array 
         * of the map, changing it's last element into 1.
         */
        for (int i=0; i<areaOneSpawnTiles.length; i++)
        {
            areaOneSpawnTiles[i][3]=1;
            areaTwoSpawnTiles[i][3]=1;
        }
        /*These nested for loops are responsible for 
         * changing back the values of the map to indicate
         * that the spawn tiles are re-enabled. 
         */
        for (int i=0; i<map.length; i++)
        {
            for (int j=0; j<map[i].length; j++)
            {
                for (int k=0; k<map[i][j].length; k++)
                {
                    if (map[i][j][k]=='X')
                    {
                        map[i][j][k]='?';
                    }
                }
            }
        }
    }
}
