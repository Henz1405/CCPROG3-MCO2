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

    public gameLobby(Character C){
        this.C=C;

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
        updateNameLabel(this.C.getPLAYER_NAME());
        updateLevelLabel(this.C.getPLAYER_LEVEL());
        updateJobClassLabel(this.C.getPLAYER_JOBCLASS());
        updateRunesLabel(this.C.getPLAYER_RUNES());
    }
    private void openInventory(){
        if (this.C.getInventory().isEmpty()){
            System.out.println("NO ITEMS");
        }
        else{
            for (int x=0; x<this.C.getInventory().size(); x++)
            {
                System.out.println("Weapon"+"["+x+"]: "+this.C.getInventory().get(x).getWeaponName());
            }
        }
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

    private void updateRunesLabel(int runes){
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
