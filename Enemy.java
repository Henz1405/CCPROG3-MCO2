/**
 * The enemy class is used to represent an enemy in game.<br>
 * It has its own stats such as health, attack, and <br>
 * multiple defense types. 
 */
public class Enemy {
    private String ENEMY_NAME;
    private long ENEMY_HEALTH;
    private int ENEMY_ATTACK;
    private double PHYS_DEF;
    private double SOR_DEF;
    private double INC_DEF;
    private int enemyType;
    
    public Enemy(int ENEMY_HEALTH, double PHYS_DEF, double SOR_DEF, double INC_DEF, int enemyType)
    {
        this.ENEMY_HEALTH=ENEMY_HEALTH;
        this.PHYS_DEF=PHYS_DEF;
        this.SOR_DEF=SOR_DEF;
        this.INC_DEF=INC_DEF;
        this.enemyType=enemyType;
    }

    public Enemy(){
        
    }
    
    public void setENEMY_NAME(String ENEMY_NAME) {
        this.ENEMY_NAME = ENEMY_NAME;
    }

    public int getEnemyType() {
        return enemyType;
    }

    public void setENEMY_HEALTH(long eNEMY_HEALTH) {
        ENEMY_HEALTH = eNEMY_HEALTH;
    }

    public String getENEMY_NAME() {
        return ENEMY_NAME;
    }

    public int getENEMY_ATTACK() {
        return ENEMY_ATTACK;
    }

    public long getENEMY_HEALTH() {
        return ENEMY_HEALTH;
    }
    
    public double getINC_DEF() {
        return INC_DEF;
    }

    public double getPHYS_DEF() {
        return PHYS_DEF;
    }
    
    public double getSOR_DEF() {
        return SOR_DEF;
    }

    public void setENEMY_ATTACK(int eNEMY_ATTACK) {
        ENEMY_ATTACK = eNEMY_ATTACK;
    }
    
}
