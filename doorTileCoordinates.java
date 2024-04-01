public class doorTileCoordinates {
    private int[][] areaOneDoorTiles={
        {0, 1, 2, 1, 7, 4},
        {1, 7, 4, 0, 1, 2},
        {1, 1, 4, 2, 7, 3},
        {2, 7, 3, 1, 1, 4}
    };

    private int[][] areaTwoDoorTiles={
        {0, 5, 2, 1, 1, 2},
        {1, 1, 2, 0, 5, 2},
        {1, 4, 3, 2, 4, 1},
        {2, 4, 1, 1, 4, 3},
        {2, 4, 5, 3, 2, 1},
        {3, 2, 1, 2, 4, 5},
        {2, 1, 3, 4, 8, 4},
        {4, 8, 4, 2, 1, 3}
    };

    private int[][] areaThreeDoorTiles={
        {0, 1, 2, 1, 7, 4},
        {1, 7, 4, 0, 1, 2},
        {1, 1, 4, 2, 9, 2},
        {2, 9, 2, 1, 1, 4}
    };

    public int[][] getAreaOneDoorTiles() {
        return areaOneDoorTiles;
    }

    public int[][] getAreaTwoDoorTiles() {
        return areaTwoDoorTiles;
    }

    public int[][] getAreaThreeDoorTiles() {
        return areaThreeDoorTiles;
    }

}
