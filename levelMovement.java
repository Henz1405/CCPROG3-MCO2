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

    public levelMovement(Character C, char map[][][], String areaName, int playerX, int playerY, int areaIndex) {
        this.C = C;
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

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                updateOffset();
            }
        });
    }

    private void updateOffset() {
        int gridWidth = map[playerFloor][0].length * CELL_SIZE;
        int gridHeight = map[playerFloor].length * CELL_SIZE;

        offsetX = (getWidth() - gridWidth) / 2;
        offsetY = (getHeight() - gridHeight) / 2;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        updateOffset();

        for (int y = 0; y < map[playerFloor].length; y++) {
            for (int x = 0; x < map[playerFloor][y].length; x++) {
                g.drawRect(offsetX + x * CELL_SIZE, offsetY + y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                g.drawString(String.valueOf(map[playerFloor][y][x]), offsetX + x * CELL_SIZE + CELL_SIZE / 2, offsetY + y * CELL_SIZE + CELL_SIZE / 2);
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

        if (newX >= 0 && newX < map[playerFloor][0].length && newY >= 0 && newY < map[playerFloor].length) {
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
            if (map[playerFloor][playerY - 1][playerX] != '#')
            {
                movePlayer(0, -1);
            }
            break;
            case KeyEvent.VK_DOWN:
            if (map[playerFloor][playerY + 1][playerX] != '#')
            {
                movePlayer(0, 1);
            }
            break;
            case KeyEvent.VK_LEFT:
            if (map[playerFloor][playerY][playerX - 1] != '#')
            {
                movePlayer(-1, 0);
            }
            break;
            case KeyEvent.VK_RIGHT:
            if (map[playerFloor][playerY][playerX + 1] != '#')
            {
                movePlayer(1, 0);
            }
            break;
            case KeyEvent.VK_E:
                if (areaIndex==1)
                {
                    if (checkSpawnTile(playerY, playerX, playerFloor, spawnTileCoordinates.getAreaOneSpawnTiles(), map)==true){
                        Random rand=new Random();
                        double probability = rand.nextDouble();
                        if (probability<0.75){
                            JOptionPane.showMessageDialog(null, "BATTLE!!");
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "TREASURE");
                        }
                    }
                    else if(checkDoorTile(playerY, playerX, playerFloor, doorTileCoordinates.getAreaOneDoorTiles(), map)==true){
                        int arr[]=activateDoor(playerY, playerX, playerFloor, doorTileCoordinates.getAreaOneDoorTiles(), map);
                        playerFloor=arr[0];
                        playerY=arr[1];
                        playerX=arr[2];
                        repaint();
                    }
                    else if(map[playerFloor][playerY][playerX]=='F')
                    {
                        spawnTileCoordinates.resetStatus(map);
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
                map[area][x][y]='X';
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
