import java.awt.Font;
import javax.swing.*;

public class gameLobby extends JFrame{
    private Character C;
    private JButton fastTravel;
    private JButton levelUp;
    private JButton inventory;
    private JButton store;
    private JButton quitGame;
    private JLabel characterName;
    private JLabel characterLevel;
    private JLabel characterJobClass;
    private JLabel characterRunes;
    private Area1 Area1=new Area1();
    private Area2 Area2=new Area2();
    private Area3 Area3=new Area3();
    private bossTileCoordinates bossTileCoordinates=new bossTileCoordinates();
    private int playerFloor=0;

    public gameLobby(Character C){
        this.C=C;
        this.C.setPLAYER_MAX_HEALTH(100*((this.C.getPLAYER_HP()+this.C.getEquippedWeapon().getWeaponHp())));
        characterName=new JLabel();
        characterName.setBounds(170, 30, 500, 50);

        characterLevel=new JLabel();
        characterLevel.setBounds(170, 45, 500, 50);

        characterJobClass=new JLabel();
        characterJobClass.setBounds(170, 60, 500, 50);

        characterRunes=new JLabel();
        characterRunes.setBounds(170, 75, 500, 50);

        fastTravel=new JButton();
        fastTravel.setText("FAST TRAVEL");
        fastTravel.setBounds(205, 160, 90, 50);
        fastTravel.setFocusable(false);
        fastTravel.setFont(new Font(getName(), Font.PLAIN, 7));
        fastTravel.addActionListener(e->openLevelMovement());

        levelUp=new JButton();
        levelUp.setText("LEVELUP");
        levelUp.setBounds(205, 220, 90, 50);
        levelUp.setFocusable(false);
        levelUp.setFont(new Font(getName(), Font.PLAIN, 12));
        levelUp.addActionListener(e->openLevelUp());

        inventory=new JButton();
        inventory.setText("INVENTORY");
        inventory.setBounds(205, 280, 90, 50);
        inventory.setFocusable(false);
        inventory.setFont(new Font(getName(), Font.PLAIN, 9));
        inventory.addActionListener(e->openInventory());

        store=new JButton();
        store.setText("STORE");
        store.setBounds(205, 340, 90, 50);
        store.setFocusable(false);
        store.setFont(new Font(getName(), Font.PLAIN, 12));
        store.addActionListener(e->openStore());

        quitGame=new JButton();
        quitGame.setText("QUIT");
        quitGame.setBounds(205, 400, 90, 50);
        quitGame.setFocusable(false);
        quitGame.setFont(new Font(getName(), Font.PLAIN, 12));
        quitGame.addActionListener(e -> openTitleScreen(this.C));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("GAME LOBBY");
        this.setSize(500, 500);
        this.setVisible(true);
        this.add(fastTravel);
        this.add(levelUp);
        this.add(inventory);
        this.add(store);
        this.add(quitGame);
        this.add(characterName);
        this.add(characterLevel);
        this.add(characterJobClass);
        this.add(characterRunes);
        this.setLocationRelativeTo(null);
        updateNameLabel(this.C.getPLAYER_NAME());
        updateLevelLabel(this.C.getPLAYER_LEVEL());
        updateJobClassLabel(this.C.getPLAYER_JOBCLASS());
        updateRunesLabel(this.C.getPLAYER_RUNES());
    }
    private void openLevelMovement(){
        String input=JOptionPane.showInputDialog("(1) Stormveil Castle\n(2) Raya Lucaria\n(3) Elden Throne");
        switch (input){
            case "1":
                levelMovement levelMovement=new levelMovement(this.C, this.Area1.getMap1(), this.Area1.getAreaName(), this.Area1.getPlayerCol(), this.Area1.getPlayerRow(), this.Area1.getAreaIndex(), this.bossTileCoordinates, this.playerFloor);
                levelMovement.setVisible(true);
                this.dispose();
                break;
            case "2":
                levelMovement levelMovement2=new levelMovement(this.C, this.Area2.getMap2(), this.Area2.getAreaName(), this.Area2.getPlayerCol(), this.Area2.getPlayerRow(), this.Area2.getAreaIndex(), this.bossTileCoordinates, this.playerFloor);
                levelMovement2.setVisible(true);
                this.dispose();
                break;
            case "3":
            if (this.C.getDefeatedBossOne()==false||this.C.getDefeatedBossTwo()==false){
                JOptionPane.showMessageDialog(null, "Defeat the Grafted Demigod and The Queen of the moon\n Only then can you enter");
                break;
            }
            else if(this.C.getDefeatedBossOne()==true&&this.C.getDefeatedBossTwo()==true){
                levelMovement levelMovement3=new levelMovement(this.C, this.Area3.getMap3(), this.Area3.getAreaName(), this.Area3.getPlayerCol(), this.Area3.getPlayerRow(), this.Area3.getAreaIndex(), this.bossTileCoordinates, this.playerFloor);
                levelMovement3.setVisible(true);
                this.dispose();
                break;
            }
                
        }
    }

    private void openInventory(){
        inventory inventory=new inventory(this.C);
        this.dispose();
    }
    private void openStore(){
        store store=new store(this.C);
        this.dispose();
    }

    private void updateNameLabel(String name){
        characterName.setText("CHARACTER NAME: "+name);
    }

    private void updateLevelLabel(int level){
        characterLevel.setText("CHARACTER LEVEL: "+level);
    }

    private void updateJobClassLabel(String jobClass){
        characterJobClass.setText("CHARACTER JOB CLASS: "+jobClass);
    }

    private void updateRunesLabel(long runes){
        characterRunes.setText("CHARACTER RUNES: "+runes);
    }

    private void openTitleScreen(Character C){
        titleScreen titleScreen=new titleScreen(C);
        this.dispose();
    }

    private void openLevelUp(){
        levelUp levelUp=new levelUp(this.C);
        this.dispose();
    }
}
