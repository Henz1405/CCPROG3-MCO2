import java.awt.Font;

import javax.swing.*;

/**
 * JFrame subclass for handling the level up process of a character.
 */
public class levelUp extends JFrame{
    private Character C;
    private int LEVEL_UP_RUNE_COST;
    private JLabel displayCost;
    private JLabel displayRunes;
    private JLabel displayHp;
    private JLabel displayDex;
    private JLabel displayEnd;
    private JLabel displayStr;
    private JLabel displayInt;
    private JLabel displayFth;
    private JLabel displayLevel;
    private JButton backButton;
    private JButton levelUp;

    /**
     * Constructs a new levelUp frame for a given character.
     * @param C The character to level up.
     */
    levelUp(Character C){
        this.C=C;
        LEVEL_UP_RUNE_COST=(this.C.getPLAYER_LEVEL()*100)/2;

        displayCost=new JLabel();
        displayCost.setBounds(170, 30, 500, 50);

        displayRunes=new JLabel();
        displayRunes.setBounds(170, 45, 500, 50);

        displayHp=new JLabel();
        displayHp.setBounds(170, 60, 500, 50);

        displayEnd=new JLabel();
        displayEnd.setBounds(170, 75, 500, 50);

        displayDex=new JLabel();
        displayDex.setBounds(170, 90, 500, 50);

        displayStr=new JLabel();
        displayStr.setBounds(170, 105, 500, 50);

        displayInt=new JLabel();
        displayInt.setBounds(170, 120, 500, 50);

        displayFth=new JLabel();
        displayFth.setBounds(170, 135, 500, 50);

        displayLevel=new JLabel();
        displayLevel.setBounds(170, 150, 500, 50);

        levelUp=new JButton();
        levelUp.setText("LEVELUP");
        levelUp.setFocusable(false);
        levelUp.setBounds(205, 340, 90, 50);
        levelUp.setFont(new Font(getName(), Font.PLAIN,10));
        levelUp.addActionListener(e->levelUpOptions());

        backButton=new JButton();
        backButton.setText("BACK");
        backButton.setFocusable(false);
        backButton.setBounds(205, 400, 90, 50);
        backButton.setFont(new Font(getName(), Font.PLAIN,12));
        backButton.addActionListener(e->openGameLobby());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("LEVEL UP");
        this.setSize(500, 500);
        this.setVisible(true);
        this.add(displayCost);
        this.add(displayRunes);
        this.add(displayHp);
        this.add(displayEnd);
        this.add(displayDex);
        this.add(displayStr);
        this.add(displayInt);
        this.add(displayFth);
        this.add(backButton);
        this.add(levelUp);
        this.add(displayLevel);
        this.setLocationRelativeTo(null);

        updateDisplayRunes(this.C.getPLAYER_RUNES());
        updateDisplayHp(this.C.getPLAYER_HP());
        updatedisplayEnd(this.C.getPLAYER_END());
        updateDisplayDex(this.C.getPLAYER_DEX());
        updateDisplayStr(this.C.getPLAYER_STR());
        updateDisplayInt(this.C.getPLAYER_INT());
        updateDisplayFth(this.C.getPLAYER_FTH());
        updateDisplayLevel(this.C.getPLAYER_LEVEL());
        updateDisplayCost(LEVEL_UP_RUNE_COST);
    }

    /**
     * Updates the display of the player's level.
     * @param level The player's level to display.
     */
    private void updateDisplayLevel(int level){
        displayLevel.setText("LEVEL: "+level);
    }

    /**
     * Displays a message if the player does not have enough runes to level up.
     * Otherwise, prompts the player to choose a stat to increase.
     */
    private void levelUpOptions(){
        if (checkRuneAmount(this.C, this.LEVEL_UP_RUNE_COST)==false){
            JOptionPane.showMessageDialog(null, "NOT ENOUGH RUNES");
        }
        else{
            String choice=JOptionPane.showInputDialog("CHOOSE A STAT TO INCREASE: \n[1] HP\n[2] END\n[3] DEX\n[4] STR\n[5] INT\n[6] FTH");
            switch (choice){
                case "1":
                    this.C.setPLAYER_HP(this.C.getPLAYER_HP()+1);
                    updateDisplayHp(this.C.getPLAYER_HP());
                    this.C.setCharacterRunes(this.C.getPLAYER_RUNES()-this.LEVEL_UP_RUNE_COST);
                    updateDisplayRunes(this.C.getPLAYER_RUNES());
                    this.C.setPLAYER_LEVEL(this.C.getPLAYER_LEVEL()+1);
                    updateDisplayLevel(this.C.getPLAYER_LEVEL());
                    this.LEVEL_UP_RUNE_COST=(this.C.getPLAYER_LEVEL()*100)/2;
                    updateDisplayCost(LEVEL_UP_RUNE_COST);
                    break;
                case "2":
                    this.C.setPLAYER_END(this.C.getPLAYER_END()+1);
                    updateDisplayHp(this.C.getPLAYER_END());
                    this.C.setCharacterRunes(this.C.getPLAYER_RUNES()-this.LEVEL_UP_RUNE_COST);
                    updateDisplayRunes(this.C.getPLAYER_RUNES());
                    this.C.setPLAYER_LEVEL(this.C.getPLAYER_LEVEL()+1);
                    updateDisplayLevel(this.C.getPLAYER_LEVEL());
                    this.LEVEL_UP_RUNE_COST=(this.C.getPLAYER_LEVEL()*100)/2;
                    updateDisplayCost(LEVEL_UP_RUNE_COST);
                    break;
                case "3":
                    this.C.setPLAYER_DEX(this.C.getPLAYER_DEX()+1);
                    updateDisplayDex(this.C.getPLAYER_DEX());
                    this.C.setCharacterRunes(this.C.getPLAYER_RUNES()-this.LEVEL_UP_RUNE_COST);
                    updateDisplayRunes(this.C.getPLAYER_RUNES());
                    this.C.setPLAYER_LEVEL(this.C.getPLAYER_LEVEL()+1);
                    updateDisplayLevel(this.C.getPLAYER_LEVEL());
                    this.LEVEL_UP_RUNE_COST=(this.C.getPLAYER_LEVEL()*100)/2;
                    updateDisplayCost(LEVEL_UP_RUNE_COST);
                    break;
                case "4":
                    this.C.setPLAYER_STR(this.C.getPLAYER_STR()+1);
                    updateDisplayStr(this.C.getPLAYER_STR());
                    this.C.setCharacterRunes(this.C.getPLAYER_RUNES()-this.LEVEL_UP_RUNE_COST);
                    updateDisplayRunes(this.C.getPLAYER_RUNES());
                    this.C.setPLAYER_LEVEL(this.C.getPLAYER_LEVEL()+1);
                    updateDisplayLevel(this.C.getPLAYER_LEVEL());
                    this.LEVEL_UP_RUNE_COST=(this.C.getPLAYER_LEVEL()*100)/2;
                    updateDisplayCost(LEVEL_UP_RUNE_COST);
                    break;
                case "5":
                    this.C.setPLAYER_INT(this.C.getPLAYER_INT()+1);
                    updateDisplayInt(this.C.getPLAYER_INT());
                    this.C.setCharacterRunes(this.C.getPLAYER_RUNES()-this.LEVEL_UP_RUNE_COST);
                    updateDisplayRunes(this.C.getPLAYER_RUNES());
                    this.C.setPLAYER_LEVEL(this.C.getPLAYER_LEVEL()+1);
                    updateDisplayLevel(this.C.getPLAYER_LEVEL());
                    this.LEVEL_UP_RUNE_COST=(this.C.getPLAYER_LEVEL()*100)/2;
                    updateDisplayCost(LEVEL_UP_RUNE_COST);
                    break;
                case "6":
                    this.C.setPLAYER_FTH(this.C.getPLAYER_FTH()+1);
                    updateDisplayFth(this.C.getPLAYER_FTH());
                    this.C.setCharacterRunes(this.C.getPLAYER_RUNES()-this.LEVEL_UP_RUNE_COST);
                    updateDisplayRunes(this.C.getPLAYER_RUNES());
                    this.C.setPLAYER_LEVEL(this.C.getPLAYER_LEVEL()+1);
                    updateDisplayLevel(this.C.getPLAYER_LEVEL());
                    this.LEVEL_UP_RUNE_COST=(this.C.getPLAYER_LEVEL()*100)/2;
                    updateDisplayCost(LEVEL_UP_RUNE_COST);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "NOT A VALID INPUT");
            }
        }
    }

    /**
     * Opens the game lobby frame and disposes of the current frame.
     */
    private void openGameLobby(){
        gameLobby gameLobby=new gameLobby(this.C);
        this.dispose();
    }

    /**
     * Updates the display of the level up cost.
     * @param Cost The cost to display.
     */
    private void updateDisplayCost(int Cost){
        displayCost.setText("COST: "+Cost);
    }

    /**
     * Updates the display of the player's faith stat.
     * @param Fth The faith stat to display.
     */
    private void updateDisplayFth(int Fth){
        displayFth.setText("FTH: "+Fth);
    }

    /**
     * Updates the display of the player's intelligence stat.
     * @param Int The intelligence stat to display.
     */
    private void updateDisplayInt(int Int){
        displayInt.setText("INT: "+Int);
    }

    /**
     * Updates the display of the player's strength stat.
     * @param Str The strength stat to display.
     */
    private void updateDisplayStr(int Str){
        displayStr.setText("STR: "+Str);
    }

    /**
     * Updates the display of the player's dexterity stat.
     * @param Dex The dexterity stat to display.
     */
    private void updateDisplayDex(int Dex){
        displayDex.setText("DEX: "+Dex);
    }

    /**
     * Updates the display of the player's runes.
     * @param runes The number of runes to display.
     */
    private void updateDisplayRunes(int runes){
        displayRunes.setText("RUNES: "+runes);
    }

    /**
     * Updates the display of the player's endurance stat.
     * @param End The endurance stat to display.
     */
    private void updatedisplayEnd(int End){
        displayEnd.setText("END: "+End);
    }

    /**
     * Updates the display of the player's health stat.
     * @param Hp The health stat to display.
     */
    private void updateDisplayHp(int Hp){
        displayHp.setText("HP: "+Hp);
    }

    /**
     * Checks if the player has enough runes to level up.
     * @param C The character to check.
     * @param LEVEL_UP_RUNE_COST The cost of leveling up.
     * @return True if the player has enough runes, false otherwise.
     */
    private boolean checkRuneAmount(Character C, int LEVEL_UP_RUNE_COST)
    {   
        if (C.getPLAYER_RUNES()>=LEVEL_UP_RUNE_COST)
        {
            return true;
        }
        return false;
    }

}
