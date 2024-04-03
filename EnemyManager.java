import java.util.Random;
/**
 * The BattleManager class is in charge of generating 
 * enemy objects when an enemy is encountered through <br>
 * a spawn tile, as well as generating a special enemy 
 * when a boss tile is interacted with.
 */
public class EnemyManager {
    /**
     * This method generates an enemy based on certain condition such as <br>
     * the area index, and its randomized type. 
     * 
     * @param C  The player character
     * @param areaIndex  The current area index
     */
    public Enemy generateEnemy(int areaIndex)
    {
        Random random = new Random();
        int randomNumber = random.nextInt(3) + 1;
        Enemy enemyvoid= new Enemy();
        if (randomNumber==1)
        {
            int ENEMY_HEALTH=random.nextInt(11) + 20;
            Enemy enemy=new Enemy(ENEMY_HEALTH*areaIndex, 0.20, 0.15, 0.10, 1);
            if (areaIndex==1)
            {
                enemy.setENEMY_NAME("Godrick Soldier");
            }
            else if (areaIndex==2)
            {
                enemy.setENEMY_NAME("Living Jar");
            }
            //BattleManager.battleStart(C, enemy, areaIndex,scanner);//Starts the battle with generated enemy

            return enemy;
        }
        else if (randomNumber==2)
        {
            int ENEMY_HEALTH=random.nextInt(11) + 25;
            Enemy enemy=new Enemy(ENEMY_HEALTH*areaIndex, 0.50, 0.15, 0.20, 2);
            if (areaIndex==1)
            {
                enemy.setENEMY_NAME("Godrick Archer");
            }
            else if (areaIndex==2)
            {
                enemy.setENEMY_NAME("Glintstone Sorcerer");
            }
            //BattleManager.battleStart(C, enemy, areaIndex, scanner);//Starts the battle with generated enemy

            return enemy;
        }
        else if (randomNumber==3)
        {
            int ENEMY_HEALTH=random.nextInt(11) + 70;
            Enemy enemy=new Enemy(ENEMY_HEALTH*areaIndex, 0.25, 0.25, 0.20, 3);
            if (areaIndex==1)
            {
                enemy.setENEMY_NAME("Godrick Knight");
            }
            else if (areaIndex==2)
            {
                enemy.setENEMY_NAME("Battlemage");
            }
            //BattleManager.battleStart(C, enemy, areaIndex, scanner);//Starts the battle with generated enemy
            return enemy;
        }
        return enemyvoid;

    }
    /**
     * This method is used to generate a boss enemy when the player 
     * steps on and interacts with a boss tile. The boss differs <br>
     * in stats based on the area index. 
     * 
     * @param C  Player character
     * @param areaIndex  Current area index
     */
    public Enemy generateBoss(int areaIndex)
    {
        Enemy enemyvoid= new Enemy();
        if (areaIndex==1)
        {
            //int ENEMY_ATTACK=random.nextInt(151) + 150;
            Enemy enemy=new Enemy(200, 0.35, 0.20, 0.15, 4);
            enemy.setENEMY_NAME("Godrick the Grafted");
            //BattleManager.battleStart(C, enemy, areaIndex, scanner);//Starts the battle with generated enemy
            return enemy;
        }
        else if(areaIndex==2)
        {
            //int ENEMY_ATTACK=random.nextInt(101) + 200;
            Enemy enemy=new Enemy(400, 0.15, 0.35, 0.25, 5);
            enemy.setENEMY_NAME("Rennala, Queen of the Moon");
            //BattleManager.battleStart(C, enemy, areaIndex, scanner);//Starts the battle with generated enemy
            return enemy;
        }
        else if(areaIndex==3)
        {
            //int ENEMY_ATTACK=random.nextInt(251) + 250;
            Enemy enemy=new Enemy(800, 0.25, 0.50, 0.40, 6);
            enemy.setENEMY_NAME("The Elden Beast");
            //BattleManager.battleStart(C, enemy, areaIndex, scanner);//Starts the battle with generated enemy
            return enemy;
        }
        return enemyvoid;
    }
}
