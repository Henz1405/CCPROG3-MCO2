import java.util.ArrayList;

/**
 * The character class represents the player's character. 
 * They have stats such as HP, DEX, FTH, etc. Is used throughout <br>
 * the game. 
 */
public class Character {
    private String PLAYER_NAME="";
    private String PLAYER_JOBCLASS="";
    private int PLAYER_LEVEL=1;
    private int PLAYER_HP=0;
    private int PLAYER_DEX=0;
    private int PLAYER_INT=0;
    private int PLAYER_END=0;
    private int PLAYER_STR=0;
    private int PLAYER_FTH=0;
    private int PLAYER_RUNES=10000;
    private boolean isCreated=false;
    private Weapon equippedWeapon=new Weapon();
    private int PLAYER_MAX_HEALTH=0;
    private boolean defeatedBossOne=false;
    private boolean defeatedBossTwo=false;
    private ArrayList<Weapon> Inventory=new ArrayList<Weapon>();

    public int getPLAYER_MAX_HEALTH() {
        return PLAYER_MAX_HEALTH;
    }

    public void setPLAYER_MAX_HEALTH(int pLAYER_MAX_HEALTH) {
        PLAYER_MAX_HEALTH = pLAYER_MAX_HEALTH;
    }

    public boolean getDefeatedBossOne(){
        return this.defeatedBossOne;
    }

    public boolean getDefeatedBossTwo(){
        return this.defeatedBossTwo;
    }

    public void setDefeatedBossOne(boolean defeat){
        this.defeatedBossOne=defeat;
    }

    public void setDefeatedBossTwo(boolean defeat){
        this.defeatedBossTwo=defeat;
    }

    /**
     * Returns the value of isCreated
     * 
     * @return  True if character is created, false if otherwise
     */
    public boolean getisCreated()
    {
        return isCreated;
    }

    /**
     * Set's the value of isCreated
     * 
     * 
     * @param isCreated  True if it is created, false if otherwise
     */
    public void setisCreated(boolean isCreated) {
        this.isCreated = isCreated;
    }
    
    /**
     * When a player picks the option to choose the player's jobclass, 
     * This method takes in all the stats, and sets them to the player Character. 
     * 
     * 
     * @param PLAYER_JOBCLASS  Player's Jobclass
     * @param PLAYER_HP  Player's HP
     * @param PLAYER_DEX  Player's DEX
     * @param PLAYER_INT  Player's INT
     * @param PLAYER_END  Player's END
     * @param PLAYER_STR  Player's STR
     * @param PLAYER_FTH  Player's FTH
     */
    public void setCharacterStats(String PLAYER_JOBCLASS, int PLAYER_HP, int PLAYER_DEX, int PLAYER_INT, int PLAYER_END, int PLAYER_STR, int PLAYER_FTH){
        this.PLAYER_JOBCLASS=PLAYER_JOBCLASS;
        this.PLAYER_HP=PLAYER_HP;
        this.PLAYER_DEX=PLAYER_DEX;
        this.PLAYER_INT=PLAYER_INT;
        this.PLAYER_END=PLAYER_END;
        this.PLAYER_STR=PLAYER_STR;
        this.PLAYER_FTH=PLAYER_FTH;
    }

    /**
     * Set's the characters runes. 
     *  
     * @param PLAYER_RUNES  Player's amount of runes. 
     */
    public void setCharacterRunes(int PLAYER_RUNES)
    {
        this.PLAYER_RUNES=PLAYER_RUNES;
    }

    /**
     * Set's the player's HP.
     * 
     * @param PLAYER_HP  Player's HP amount
     */
    public void setPLAYER_HP(int PLAYER_HP)
    {
        this.PLAYER_HP=PLAYER_HP;
    }

    /**
     * Set's the player's Dexterity
     * 
     * @param PLAYER_DEX  Player's DEX stat
     */
    public void setPLAYER_DEX(int PLAYER_DEX)
    {
        this.PLAYER_DEX=PLAYER_DEX;
    }

    /**
     * Set's the player's Intelligence
     * 
     * @param PLAYER_INT  Player's INT stat
     */
    public void setPLAYER_INT(int PLAYER_INT)
    {
        this.PLAYER_INT=PLAYER_INT;
    }

    /**
     * Set's the player's Endurance
     * 
     * @param PLAYER_END  Player's END stat
     */
    public void setPLAYER_END(int PLAYER_END)
    {
        this.PLAYER_END=PLAYER_END;
    }

    /**
     * Set's the player's Strength
     * 
     * @param PLAYER_STR  Player's STR stat
     */
    public void setPLAYER_STR(int PLAYER_STR)
    {
        this.PLAYER_STR=PLAYER_STR;
    }

    /**
     * Set's the player's Faith
     * 
     * @param PLAYER_FTH  Player's FTH stat
     */
    public void setPLAYER_FTH(int PLAYER_FTH)
    {
        this.PLAYER_FTH=PLAYER_FTH;
    }

    /**
     * Set's player's level
     * 
     * @param PLAYER_LEVEL  Player's new level
     */
    public void setPLAYER_LEVEL(int PLAYER_LEVEL)
    {
        this.PLAYER_LEVEL=PLAYER_LEVEL;
    }
    
    /**
     * Returns the player's amount of runes.
     * 
     * @return  Player's amount of runes
     */
    public int getPLAYER_RUNES(){
        return this.PLAYER_RUNES;
    }

    /**
     * Set's the player's name
     * 
     * @param PLAYER_NAME  Player's name
     */
    public void setCharacterName(String PLAYER_NAME){
        this.PLAYER_NAME=PLAYER_NAME;
    }

    /**
     * Returns the player's name
     *  
     * @return  Player's name
     */
    public String getPLAYER_NAME(){
        return PLAYER_NAME;
    }

    /**
     * Returns the Player's Jobclass
     * 
     * @return  Player's jobclass
     */
    public String getPLAYER_JOBCLASS(){
        return PLAYER_JOBCLASS;
    }

    /**
     * Returns the Player's level
     * 
     * @return  Player's level
     */
    public int getPLAYER_LEVEL(){
        return this.PLAYER_LEVEL;
    }

    /**
     * Returns Player's HP
     * 
     * @return  Player's HP
     */
    public int getPLAYER_HP(){
        return this.PLAYER_HP;
    }

    /**
     * Returns Player's DEX
     * 
     * @return  Player's DEX
     */
    public int getPLAYER_DEX(){
        return this.PLAYER_DEX;
    }

    /**
     * Returns Player's INT
     * 
     * @return  Player's INT
     */
    public int getPLAYER_INT(){
        return this.PLAYER_INT;
    }

    /**
     * Returns Player's END
     * 
     * @return  Player's END
     */
    public int getPLAYER_END(){
        return this.PLAYER_END;
    }

    /**
     * Returns Player's STR
     * 
     * @return  Player's STR
     */
    public int getPLAYER_STR(){
        return this.PLAYER_STR;
    }

    /**
     * Returns Player's FTH
     * 
     * @return  Player's FTH
     */
    public int getPLAYER_FTH(){
        return this.PLAYER_FTH;
    }

    public void setEquippedWeapon(Weapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public ArrayList<Weapon> getInventory() {
        return Inventory;
    }

    public void addWeapon(Weapon weapon)
    {
        Inventory.add(weapon);
    }

}
