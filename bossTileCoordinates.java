/**
 * Represents the coordinates and defeat status of the boss tiles in the game.
 */
public class bossTileCoordinates {
    private int bossFloor1=2;
    private int bossX1=3;
    private int bossY1=4;
    private boolean boss1Defeat=false;

    private int bossFloor2=4;
    private int bossX2=4;
    private int bossY2=5;
    private boolean boss2Defeat=false;

    private int bossFloor3=1;
    private int bossX3=4;
    private int bossY3=4;
    private boolean boss3Defeat=false;

    /**
     * Gets the floor number of the first boss tile.
     *
     * @return The floor number of the first boss tile.
     */
    public int getBossFloor1() {
        return bossFloor1;
    }
    
    /**
     * Gets the X coordinate of the first boss tile.
     *
     * @return The X coordinate of the first boss tile.
     */
    public int getBossX1() {
        return bossX1;
    }

    /**
     * Gets the Y coordinate of the first boss tile.
     *
     * @return The Y coordinate of the first boss tile.
     */
    public int getBossY1() {
        return bossY1;
    }

    /**
     * Gets the defeat status of the first boss.
     *
     * @return True if the first boss is defeated, false otherwise.
     */
    public boolean getboss1Defeat(){
        return boss1Defeat;
    }

    /**
     * Sets the defeat status of the first boss.
     *
     * @param defeat The defeat status of the first boss.
     */
    public void setboss1Defeat(boolean defeat){
        this.boss1Defeat=defeat;
    }

    /**
     * Gets the floor number of the second boss tile.
     *
     * @return The floor number of the second boss tile.
     */
    public int getBossFloor2() {
        return bossFloor2;
    }

    /**
     * Gets the X coordinate of the second boss tile.
     *
     * @return The X coordinate of the second boss tile.
     */
    public int getBossX2() {
        return bossX2;
    }

    /**
     * Gets the Y coordinate of the second boss tile.
     *
     * @return The Y coordinate of the second boss tile.
     */
    public int getBossY2() {
        return bossY2;
    }

    /**
     * Gets the defeat status of the second boss.
     *
     * @return True if the second boss is defeated, false otherwise.
     */
    public boolean getboss2Defeat(){
        return boss2Defeat;
    }

    /**
     * Sets the defeat status of the second boss.
     *
     * @param defeat The defeat status of the second boss.
     */
    public void setboss2Defeat(boolean defeat){
        this.boss2Defeat=defeat;
    }

    /**
     * Gets the floor number of the third boss tile.
     *
     * @return The floor number of the third boss tile.
     */
    public int getBossFloor3() {
        return bossFloor3;
    }

    /**
     * Gets the X coordinate of the third boss tile.
     *
     * @return The X coordinate of the third boss tile.
     */
    public int getBossX3() {
        return bossX3;
    }

    /**
     * Gets the Y coordinate of the third boss tile.
     *
     * @return The Y coordinate of the third boss tile.
     */
    public int getBossY3() {
        return bossY3;
    }

   /**
     * Gets the defeat status of the third boss.
     *
     * @return True if the third boss is defeated, false otherwise.
     */ 
    public boolean getboss3Defeat(){
        return boss3Defeat;
    }

    /**
     * Sets the defeat status of the third boss.
     *
     * @param defeat The defeat status of the third boss.
     */
    public void setboss3Defeat(boolean defeat){
        this.boss3Defeat=defeat;
    }

}
