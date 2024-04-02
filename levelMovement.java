import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class levelMovement extends JFrame implements KeyListener {
    private static final int CELL_SIZE = 30;
    private static final int PLAYER_SIZE = 20;
    private int playerX = 1;
    private int playerY = 0;
    private int playerFloor = 0;
    private Character C;
    private char[][][] map;
    private int offsetX;
    private int offsetY;
    private doorTileCoordinates doorTileCoordinates=new doorTileCoordinates();
    private spawnTileCoordinates spawnTileCoordinates=new spawnTileCoordinates();
    private int areaIndex;
    private JLabel displayRunes;
    private JLabel displayPLAYER_MAX_HEALTH;
    private EnemyManager enemyManager=new EnemyManager();

    public levelMovement(Character C, char map[][][], String areaName, int playerX, int playerY, int areaIndex) {
        this.C = C;
        if (this.C.getPLAYER_MAX_HEALTH()==0)
        {
            this.C.setPLAYER_MAX_HEALTH(100*((this.C.getPLAYER_HP()+this.C.getEquippedWeapon().getWeaponHp())));
        }
        
        this.map = map;
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

    private void updateDisplayRunes(){
        displayRunes.setText("RUNES: "+this.C.getPLAYER_RUNES());
    }

    private void updateDisplayPLAYER_MAX_HEALTH(){
        displayPLAYER_MAX_HEALTH.setText("PLAYER MAX HEALTH: "+this.C.getPLAYER_MAX_HEALTH());
    }

    private void updateOffset() {
        int gridWidth = this.map[playerFloor][0].length * CELL_SIZE;
        int gridHeight = this.map[playerFloor].length * CELL_SIZE;

        offsetX = (getWidth() - gridWidth) / 2;
        offsetY = (getHeight() - gridHeight) / 2;
    }

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
                            battleManager battleManager=new battleManager(this.C, this.map, this.playerX, this.playerY, this.areaIndex, enemy);
                            this.dispose();
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
                }
                else if(areaIndex==2){
                    if (checkSpawnTile(playerY, playerX, playerFloor, spawnTileCoordinates.getAreaTwoSpawnTiles(), this.map)==true){
                        Random rand=new Random();
                        double probability = rand.nextDouble();
                        if (probability<0.75){
                            Enemy enemy=enemyManager.generateEnemy(this.areaIndex);
                            JOptionPane.showMessageDialog(null, "BATTLE!!\n "+"ENEMY NAME: "+enemy.getENEMY_NAME()+"\n ENEMY PHYS_DEF: "+enemy.getPHYS_DEF()+"\n ENEMY SOR_DEF: "+enemy.getSOR_DEF()+"\nENEMY INC_DEF: "+enemy.getINC_DEF());
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
                    else if(this.map[playerFloor][playerY][playerX]=='F')
                    {
                        spawnTileCoordinates.resetStatus(this.map);
                        gameLobby gameLobby=new gameLobby(this.C);
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
}
