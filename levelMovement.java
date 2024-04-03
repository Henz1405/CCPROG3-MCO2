import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 * Represents the JFrame where the player can move through the game's levels.
 */
public class levelMovement extends JFrame implements KeyListener {
    private static final int CELL_SIZE = 30;
    private static final int PLAYER_SIZE = 20;
    private int playerX = 1;
    private int playerY = 0;
    private int playerFloor;
    private Character C;
    private char[][][] map;
    private int offsetX;
    private int offsetY;
    private doorTileCoordinates doorTileCoordinates=new doorTileCoordinates();
    private spawnTileCoordinates spawnTileCoordinates=new spawnTileCoordinates();
    private bossTileCoordinates bossTileCoordinates;
    private int areaIndex;
    private JLabel displayRunes;
    private JLabel displayPLAYER_MAX_HEALTH;
    private EnemyManager enemyManager=new EnemyManager();
    private String areaName;
    Random random = new Random();

    /**
     * Constructs a new levelMovement object.
     *
     * @param C                The character object representing the player.
     * @param map              The map of the current level.
     * @param areaName         The name of the current area.
     * @param playerX          The initial X coordinate of the player.
     * @param playerY          The initial Y coordinate of the player.
     * @param areaIndex        The index of the current area.
     * @param bossTileCoordinates The coordinates of the boss tile.
     * @param playerFloor      The current floor of the player.
     */
    public levelMovement(Character C, char map[][][], String areaName, int playerX, int playerY, int areaIndex, bossTileCoordinates bossTileCoordinates, int playerFloor) {
        this.C = C;
        this.playerFloor=playerFloor;
        this.bossTileCoordinates=bossTileCoordinates;
        this.map = map;
        this.areaName=areaName;
        this.playerX=playerX;
        this.playerY=playerY;
        this.areaIndex=areaIndex;
        this.setTitle(areaName);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
        displayRunes=new JLabel();
        displayPLAYER_MAX_HEALTH=new JLabel();

        displayRunes.setBounds(10, 10, 200, 20); 
        displayPLAYER_MAX_HEALTH.setBounds(10, 20, 200, 20);

        this.add(displayRunes);
        this.add(displayPLAYER_MAX_HEALTH);
        updateDisplayRunes();
        updateDisplayPLAYER_MAX_HEALTH();

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                updateOffset();
            }
        });
    }

    /**
     * Updates the label for the player's runes
     */
    private void updateDisplayRunes(){
        displayRunes.setText("RUNES: "+this.C.getPLAYER_RUNES());
    }

    /**
     * Updates the display of the player's maximum health.
     */
    private void updateDisplayPLAYER_MAX_HEALTH(){
        displayPLAYER_MAX_HEALTH.setText("PLAYER MAX HEALTH: "+this.C.getPLAYER_MAX_HEALTH());
    }

    /**
     * Updates the offset for rendering the map based on the window size.
     */
    private void updateOffset() {
        int gridWidth = this.map[playerFloor][0].length * CELL_SIZE;
        int gridHeight = this.map[playerFloor].length * CELL_SIZE;

        offsetX = (getWidth() - gridWidth) / 2;
        offsetY = (getHeight() - gridHeight) / 2;
    }

    /**
     * Render's the level map
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        updateOffset();

        for (int y = 0; y < this.map[playerFloor].length; y++) {
            for (int x = 0; x < this.map[playerFloor][y].length; x++) {
                g.drawRect(offsetX + x * CELL_SIZE, offsetY + y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                g.drawString(String.valueOf(this.map[playerFloor][y][x]), offsetX + x * CELL_SIZE + CELL_SIZE / 2, offsetY + y * CELL_SIZE + CELL_SIZE / 2);
            }
        }

        g.setColor(Color.RED);
        g.fillRect(offsetX + playerX * CELL_SIZE + (CELL_SIZE - PLAYER_SIZE) / 2,
                offsetY + playerY * CELL_SIZE + (CELL_SIZE - PLAYER_SIZE) / 2,
                PLAYER_SIZE, PLAYER_SIZE);
    }

    /**
     * Calculates the movement of the player
     * @param dx The change in the X coordinate
     * @param dy The change in the Y coordinate
     */
    private void movePlayer(int dx, int dy) {
        int newX = playerX + dx;
        int newY = playerY + dy;

        if (newX >= 0 && newX < this.map[playerFloor][0].length && newY >= 0 && newY < this.map[playerFloor].length) {
            playerX = newX;
            playerY = newY;
            repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_UP:
            if (this.map[playerFloor][playerY - 1][playerX] != '#')
            {
                movePlayer(0, -1);
            }
            break;
            case KeyEvent.VK_DOWN:
            if (this.map[playerFloor][playerY + 1][playerX] != '#')
            {
                movePlayer(0, 1);
            }
            break;
            case KeyEvent.VK_LEFT:
            if (this.map[playerFloor][playerY][playerX - 1] != '#')
            {
                movePlayer(-1, 0);
            }
            break;
            case KeyEvent.VK_RIGHT:
            if (this.map[playerFloor][playerY][playerX + 1] != '#')
            {
                movePlayer(1, 0);
            }
            break;
            case KeyEvent.VK_E:
                if (areaIndex==1)
                {
                    if (checkSpawnTile(playerY, playerX, playerFloor, spawnTileCoordinates.getAreaOneSpawnTiles(), this.map)==true){
                        Random rand=new Random();
                        double probability = rand.nextDouble();
                        if (probability<0.75){
                            Enemy enemy=enemyManager.generateEnemy(this.areaIndex);
                            if (battleManager(enemy)==0){
                                gameLobby gameLobby=new gameLobby(this.C);
                                spawnTileCoordinates.resetStatus(this.map);
                                this.dispose();
                            }
                            updateDisplayPLAYER_MAX_HEALTH();
                            updateDisplayRunes();
                            repaint();
                        }
                        else{
                            int randomNumber = (rand.nextInt(101) + 50)*this.areaIndex;
                            JOptionPane.showMessageDialog(null, "TREASURE: "+randomNumber+" RUNES!!");
                            this.C.setCharacterRunes(this.C.getPLAYER_RUNES()+randomNumber);
                            updateDisplayRunes();
                        }
                    }
                    else if(checkDoorTile(playerY, playerX, playerFloor, doorTileCoordinates.getAreaOneDoorTiles(), this.map)==true){
                        int arr[]=activateDoor(playerY, playerX, playerFloor, doorTileCoordinates.getAreaOneDoorTiles(), this.map);
                        playerFloor=arr[0];
                        playerY=arr[1];
                        playerX=arr[2];
                        repaint();
                    }
                    else if(this.map[playerFloor][playerY][playerX]=='F')
                    {
                        spawnTileCoordinates.resetStatus(this.map);
                        gameLobby gameLobby=new gameLobby(this.C);
                        this.dispose();
                    }
                    else if(this.map[playerFloor][playerY][playerX]==this.map[this.bossTileCoordinates.getBossFloor1()][this.bossTileCoordinates.getBossY1()][this.bossTileCoordinates.getBossX1()]&&this.bossTileCoordinates.getboss1Defeat()==false){
                        JOptionPane.showMessageDialog(null, "BOSS TILE");
                        Enemy boss=enemyManager.generateBoss(this.areaIndex);
                        if (battleManager(boss)==0){
                            gameLobby gameLobby=new gameLobby(this.C);
                            spawnTileCoordinates.resetStatus(this.map);
                            this.dispose();
                        };
                        updateDisplayPLAYER_MAX_HEALTH();
                        updateDisplayRunes();
                        repaint();
                    }
                    else if(this.map[playerFloor][playerY][playerX]==this.map[this.bossTileCoordinates.getBossFloor1()][this.bossTileCoordinates.getBossY1()][this.bossTileCoordinates.getBossX1()]&&this.bossTileCoordinates.getboss1Defeat()==true){
                        JOptionPane.showMessageDialog(null, "BOSS DEFEATED");
                    }
                }
                else if(areaIndex==2){
                    if (checkSpawnTile(playerY, playerX, playerFloor, spawnTileCoordinates.getAreaTwoSpawnTiles(), this.map)==true){
                        Random rand=new Random();
                        double probability = rand.nextDouble();
                        if (probability<0.75){
                            Enemy enemy=enemyManager.generateEnemy(this.areaIndex);
                            if (battleManager(enemy)==0){
                                gameLobby gameLobby=new gameLobby(this.C);
                                spawnTileCoordinates.resetStatus(this.map);
                                this.dispose();
                            }
                            updateDisplayPLAYER_MAX_HEALTH();
                            updateDisplayRunes();
                            repaint();
                        }
                        else{
                            int randomNumber = (rand.nextInt(101) + 50)*this.areaIndex;
                            JOptionPane.showMessageDialog(null, "TREASURE: "+randomNumber+" RUNES!!");
                            this.C.setCharacterRunes(this.C.getPLAYER_RUNES()+randomNumber);
                            updateDisplayRunes();
                        }
                    }
                    else if(checkDoorTile(playerY, playerX, playerFloor, doorTileCoordinates.getAreaTwoDoorTiles(), this.map)==true){
                        int arr[]=activateDoor(playerY, playerX, playerFloor, doorTileCoordinates.getAreaTwoDoorTiles(), this.map);
                        playerFloor=arr[0];
                        playerY=arr[1];
                        playerX=arr[2];
                        repaint();
                    }
                    else if(this.map[playerFloor][playerY][playerX]==this.map[this.bossTileCoordinates.getBossFloor2()][this.bossTileCoordinates.getBossY2()][this.bossTileCoordinates.getBossX2()]&&this.bossTileCoordinates.getboss2Defeat()==false){
                        JOptionPane.showMessageDialog(null, "BOSS TILE");
                        Enemy boss=enemyManager.generateBoss(this.areaIndex);
                        if (battleManager(boss)==0){
                            gameLobby gameLobby=new gameLobby(this.C);
                            spawnTileCoordinates.resetStatus(this.map);
                            this.dispose();
                        }
                        updateDisplayPLAYER_MAX_HEALTH();
                        updateDisplayRunes();
                        repaint();
                    }
                    else if(this.map[playerFloor][playerY][playerX]==this.map[this.bossTileCoordinates.getBossFloor2()][this.bossTileCoordinates.getBossY2()][this.bossTileCoordinates.getBossX2()]&&this.bossTileCoordinates.getboss2Defeat()==true){
                        JOptionPane.showMessageDialog(null, "BOSS DEFEATED");
                    }
                    else if(this.map[playerFloor][playerY][playerX]=='F')
                    {
                        spawnTileCoordinates.resetStatus(this.map);
                        gameLobby gameLobby=new gameLobby(this.C);
                        this.dispose();
                    }
                }
                else if(areaIndex==3){
                    if (checkSpawnTile(playerY, playerX, playerFloor, spawnTileCoordinates.getAreaThreeSpawnTiles(), this.map)==true){
                        Random rand=new Random();
                        int randomNumber = (rand.nextInt(101) + 50)*this.areaIndex;
                        JOptionPane.showMessageDialog(null, "TREASURE: "+randomNumber+" RUNES!!");
                        this.C.setCharacterRunes(this.C.getPLAYER_RUNES()+randomNumber);
                        updateDisplayRunes();
                        
                    }
                    else if(checkDoorTile(playerY, playerX, playerFloor, doorTileCoordinates.getAreaThreeDoorTiles(), this.map)==true){
                        int arr[]=activateDoor(playerY, playerX, playerFloor, doorTileCoordinates.getAreaThreeDoorTiles(), this.map);
                        playerFloor=arr[0];
                        playerY=arr[1];
                        playerX=arr[2];
                        repaint();
                    }
                    else if(this.map[playerFloor][playerY][playerX]==this.map[this.bossTileCoordinates.getBossFloor3()][this.bossTileCoordinates.getBossY3()][this.bossTileCoordinates.getBossX3()]&&this.bossTileCoordinates.getboss3Defeat()==false){
                        JOptionPane.showMessageDialog(null, "BOSS TILE");
                        Enemy boss=enemyManager.generateBoss(this.areaIndex);
                        if (battleManager(boss)==0){
                            gameLobby gameLobby=new gameLobby(this.C);
                            spawnTileCoordinates.resetStatus(this.map);
                            this.dispose();
                        }
                        updateDisplayPLAYER_MAX_HEALTH();
                        updateDisplayRunes();
                        repaint();
                    }
                    else if(this.map[playerFloor][playerY][playerX]==this.map[this.bossTileCoordinates.getBossFloor3()][this.bossTileCoordinates.getBossY3()][this.bossTileCoordinates.getBossX3()]&&this.bossTileCoordinates.getboss3Defeat()==true){
                        JOptionPane.showMessageDialog(null, "BOSS DEFEATED");
                    }
                    else if(this.map[playerFloor][playerY][playerX]=='F')
                    {
                        spawnTileCoordinates.resetStatus(this.map);
                        gameLobby gameLobby=new gameLobby(this.C);
                        this.dispose();
                    }
                    else if(this.map[playerFloor][playerY][playerX]=='C'){
                        credits credits=new credits();
                        this.dispose();
                    }
                }
                break;
                }
                
        }
    

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    /**
     * Check if player stepped on a spawntile and deactivates it. 
     * @param playerRow The player's Y coordinate
     * @param playerCol The player's X coordinate
     * @param playerFloor The player's current floor number
     * @param SpawnTiles The array containing the coordinates for the spawntiles
     * @param map The current map
     * @return True if the player steps on a spawntile, false if not. 
     */
    private boolean checkSpawnTile(int playerRow, int playerCol, int playerFloor, int[][]SpawnTiles, char[][][]map)
    {
        for (int i=0; i<SpawnTiles.length; i++)
        {
           int x=SpawnTiles[i][1];
           int y=SpawnTiles[i][2];
           int area=SpawnTiles[i][0];
           if (playerFloor==area&&playerRow==x&&playerCol==y&&SpawnTiles[i][3]!=0)
           {
                SpawnTiles[i][3]=0;
                this.map[area][x][y]='X';
                return true;
           }
        }
        return false;
    }

    /**
     * Checks if the player steps on a doortile
     * @param playerRow The player's Y coordinate
     * @param playerCol The player's X coordinate
     * @param playerFloor The player's current floor number
     * @param doorTiles The array containing the coordinates for the doortiles
     * @param map The current map
     * @return True if the player steps on a doortile, false if not.
     */
    private boolean checkDoorTile(int playerRow, int playerCol, int playerFloor, int[][]doorTiles, char[][][]map)
    {
        for (int i=0; i<doorTiles.length; i++)
        {
           int row=doorTiles[i][1];
           int col=doorTiles[i][2];
           int area=doorTiles[i][0];
           if (playerFloor==area&&playerRow==row&&playerCol==col)
           {
                return true;
           }
        }
        return false;
    }

    /**
     * Activates a doortile when the player interacts with it.
     * @param playerRow The player's Y coordinate
     * @param playerCol The player's X coordinate
     * @param playerFloor The player's current floor number
     * @param doorTiles The array containing the coordinates for the doortiles
     * @param map The current map
     * @return An array representing the coordinates of where the doortile sends you too. 
     */
    private int[] activateDoor(int playerRow, int playerCol, int playerFloor, int[][]doorTiles, char[][][]map)
    {
        int[] arr={0, 0, 0};
        for (int i=0; i<doorTiles.length; i++)
        {
           int row=doorTiles[i][1];
           int col=doorTiles[i][2];
           int area=doorTiles[i][0];
           if (playerFloor==area&&playerRow==row&&playerCol==col)
           {
                arr[0]=doorTiles[i][3];
                arr[1]=doorTiles[i][4];
                arr[2]=doorTiles[i][5];
                return arr;
           }
        }
        return arr;
    }

    /**
     * Calculates the damage for the enemy's turn based on the enemy's type.
     * @param enemy Current enemy
     * @return The enemy's next attack.
     */
    private int calculateDamage(Enemy enemy)
    {
        
        if (enemy.getEnemyType()==1)
        {
            int ENEMY_ATTACK=random.nextInt(11) + 70;
            enemy.setENEMY_ATTACK(ENEMY_ATTACK);
            return ENEMY_ATTACK;
        }
        else if (enemy.getEnemyType()==2)
        {
            int ENEMY_ATTACK=random.nextInt(11) + 110;
            enemy.setENEMY_ATTACK(ENEMY_ATTACK);
            return ENEMY_ATTACK;
        }
        else if (enemy.getEnemyType()==3)
        {
            int ENEMY_ATTACK=random.nextInt(11) + 120;
            enemy.setENEMY_ATTACK(ENEMY_ATTACK);
            return ENEMY_ATTACK;
        }
        else if(enemy.getEnemyType()==4)
        {
            int ENEMY_ATTACK=random.nextInt(151) + 150;
            enemy.setENEMY_ATTACK(ENEMY_ATTACK);
            return ENEMY_ATTACK;
        }
        else if(enemy.getEnemyType()==5)
        {
            int ENEMY_ATTACK=random.nextInt(101) + 200;
            enemy.setENEMY_ATTACK(ENEMY_ATTACK);
            return ENEMY_ATTACK;
        }
        else if(enemy.getEnemyType()==6)
        {
            int ENEMY_ATTACK=random.nextInt(251) + 250;
            enemy.setENEMY_ATTACK(ENEMY_ATTACK);
            return ENEMY_ATTACK;
        }

        return 0;
    }

    /**
     * Checks the health of both the Player Character and the enemy
     * @param enemy Current enemy
     * @param C Player Character
     * @return returns 1 if both player and enemy are still alive, returns 2 if the enemy is dead, and returns 3 if the player died
     */
    private int checkHealth(Enemy enemy, Character C)
    {
        if (C.getPLAYER_MAX_HEALTH()>0&&enemy.getENEMY_HEALTH()>0)
        {
            return 1;//continue battle
        }
        else if(enemy.getENEMY_HEALTH()<=0||C.getPLAYER_MAX_HEALTH()<=0)
        {
            if (enemy.getENEMY_HEALTH()<=0){
                return 2;// enemy died
            }
            else if(C.getPLAYER_MAX_HEALTH()<=0){
                return 3;// player died
            }
        }
        return 0;
    }

    /**
     * Manages the battle between the player and the enemy
     * @param E The current enemy
     * @return Returns 0 if player looses, returns 1 if player wins, and returns -1 for debugging purposes
     */
    private int battleManager(Enemy E){
        boolean playerTurn;
        boolean battleStart=true;
        long DODGE_RATE=0;
        int ENEMY_DAMAGE;

        while (battleStart){
            playerTurn=true;
            ENEMY_DAMAGE=calculateDamage(E);
            String choice=JOptionPane.showInputDialog("PLAYER HP: "+this.C.getPLAYER_MAX_HEALTH()+
                                    
                                        
                                "\n\n\nEnemy name: "+E.getENEMY_NAME()+
                                "\nEnemy Health: "+E.getENEMY_HEALTH()+
                                "\nEnemy PHYS_DEF: "+E.getPHYS_DEF()+
                                "\nEnemy SOR_DEF: "+E.getSOR_DEF()+
                                "\nEnemy INC_DEF: "+E.getINC_DEF()+
                                "\n\n\n(1) Attack\n(2) Dodge"+
                                "\nIncoming enemy attack: "+ENEMY_DAMAGE);  
            switch (choice) {
                case "1":
                    String choice2=JOptionPane.showInputDialog("(1) Physical Attack\n(2) Sorcery Attack\n(3) Incantation Attack");
                    switch (choice2){
                        case "1":
                            long calculatedDamage=Math.round((this.C.getEquippedWeapon().getWeaponStr()+this.C.getPLAYER_STR())*(1-E.getPHYS_DEF()));
                            int PHYSICAL_DAMAGE=(int) calculatedDamage;
                            E.setENEMY_HEALTH(E.getENEMY_HEALTH()-PHYSICAL_DAMAGE);
                            playerTurn=false;
                            break;
                        case "2":
                            long calculatedDamage2=Math.round((this.C.getEquippedWeapon().getWeaponInt()+this.C.getPLAYER_INT())*(1-E.getSOR_DEF()));
                            int SORCERY_DAMAGE=(int) calculatedDamage2;
                            E.setENEMY_HEALTH(E.getENEMY_HEALTH()-SORCERY_DAMAGE);
                            playerTurn=false;
                            break;
                        case "3":
                            long calculatedDamage3=Math.round((this.C.getEquippedWeapon().getWeaponFth()+this.C.getPLAYER_FTH())*(1-E.getINC_DEF())); 
                            int INCANTATION_DAMAGE=(int) calculatedDamage3;
                            E.setENEMY_HEALTH(E.getENEMY_HEALTH()-INCANTATION_DAMAGE);
                            playerTurn=false;
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "NOT A VALID INPUT");
                    }
                    break;
                case "2":
                    DODGE_RATE=(20+((this.C.getPLAYER_END()+this.C.getEquippedWeapon().getWeaponEnd())/2)/100);
                    playerTurn=false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "NOT A VALID INPUT");
                    break;
            } 

            if (checkHealth(E, this.C)==1){
                int randomNumber = random.nextInt(100) + 1;
                if (randomNumber<=DODGE_RATE)
                {
                    JOptionPane.showMessageDialog(null, "DODGE SUCCESSFUL!");
                }
                else{
                    C.setPLAYER_MAX_HEALTH(C.getPLAYER_MAX_HEALTH()-ENEMY_DAMAGE);
                    if(checkHealth(E, this.C)==3)
                    {
                        battleStart=false;
                        JOptionPane.showMessageDialog(null, "YOU DIED!!");
                        return 0;
                    }
                }
            }
            else if(checkHealth(E, this.C)==2){
            if (E.getEnemyType()==1||E.getEnemyType()==2||E.getEnemyType()==3)
            {
                battleStart=false;
                int min = 50;
                int max = 150;
                int randomNumber = random.nextInt(max - min + 1) + min;
                int RUNES_GAINED=areaIndex*randomNumber;
                JOptionPane.showMessageDialog(null, "ENEMY FELLED");
                JOptionPane.showMessageDialog(null, "RUNES GAINED: "+RUNES_GAINED);
                this.C.setCharacterRunes(this.C.getPLAYER_RUNES()+RUNES_GAINED);
                return 1;
            }
            else if(E.getEnemyType()==4||E.getEnemyType()==5||E.getEnemyType()==6){
                battleStart=false;
                if (E.getEnemyType()==4){
                    int RUNES_GAINED=200*5;
                    JOptionPane.showMessageDialog(null, "GREAT ENEMY FELLED");
                    JOptionPane.showMessageDialog(null, "RUNES GAINED: "+RUNES_GAINED);
                    this.C.setCharacterRunes(this.C.getPLAYER_RUNES()+RUNES_GAINED);
                    this.C.setDefeatedBossOne(true);
                    this.bossTileCoordinates.setboss1Defeat(true);
                    return 1;
                }
                else if(E.getEnemyType()==5){
                    int RUNES_GAINED=400*5;
                    JOptionPane.showMessageDialog(null, "GREAT ENEMY FELLED");
                    JOptionPane.showMessageDialog(null, "RUNES GAINED: "+RUNES_GAINED);
                    this.C.setCharacterRunes(this.C.getPLAYER_RUNES()+RUNES_GAINED);
                    this.C.setDefeatedBossTwo(true);
                    this.bossTileCoordinates.setboss2Defeat(true);
                    return 1;
                }
                else if(E.getEnemyType()==6){
                    int RUNES_GAINED=800*5;
                    JOptionPane.showMessageDialog(null, "GREAT ENEMY FELLED");
                    JOptionPane.showMessageDialog(null, "RUNES GAINED: "+RUNES_GAINED);
                    this.C.setCharacterRunes(this.C.getPLAYER_RUNES()+RUNES_GAINED);
                    this.bossTileCoordinates.setboss3Defeat(true);
                    return 1;
                }
            }    
            }             
        }
        return -1;
    }
}
