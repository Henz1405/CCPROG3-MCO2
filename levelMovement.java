import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class levelMovement extends JFrame implements KeyListener {
    private static final int GRID_SIZE = 5;
    private static final int CELL_SIZE = 50;
    private static final int PLAYER_SIZE = 40;

    private int playerX = 1;
    private int playerY = 0;
    private int playerFloor=0;
    private Character C;

    public levelMovement(Character C) {
        this.C=C;
        setTitle("Simple Grid Game");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

    int offsetX = (getWidth() - GRID_SIZE * CELL_SIZE) / 2;
    int offsetY = (getHeight() - GRID_SIZE * CELL_SIZE) / 2;

    for (int y = 0; y < GRID_SIZE; y++) {
        for (int x = 0; x < GRID_SIZE; x++) {
            g.drawRect(offsetX + x * CELL_SIZE, offsetY + y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
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

        if (newX >= 0 && newX < GRID_SIZE && newY >= 0 && newY < GRID_SIZE) {
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
                movePlayer(0, -1);
                break;
            case KeyEvent.VK_DOWN:
                movePlayer(0, 1);
                break;
            case KeyEvent.VK_LEFT:
                movePlayer(-1, 0);
                break;
            case KeyEvent.VK_RIGHT:
                movePlayer(1, 0);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}


}
