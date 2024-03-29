import javax.swing.*;
import java.awt.Font;

public class store extends JFrame {
    private Character C;
    private JLabel storeDisplay;
    private JLabel runes;
    private JButton backButton;
    private JButton swords;
    private JButton katanas;
    private JButton whips;
    private JButton greatSwords;
    private JButton staves;
    private JButton seals;

    store(Character C){
        this.C=C;

        storeDisplay=new JLabel();
        storeDisplay.setBounds(190, 30, 500, 50);
        storeDisplay.setText("BUY WEAPONS HERE");

        runes=new JLabel();
        runes.setBounds(190, 50, 500, 50);

        swords=new JButton();
        swords.setBounds(205, 90, 90, 50);
        swords.setText("SWORDS");
        swords.setFocusable(false);
        swords.addActionListener(e->swordMenu());

        katanas=new JButton();
        katanas.setBounds(205, 150, 90, 50);
        katanas.setText("KATANAS");
        katanas.setFocusable(false);
        katanas.addActionListener(e->katanasMenu());

        backButton=new JButton();
        backButton.setText("BACK");
        backButton.setFocusable(false);
        backButton.setBounds(205, 400, 90, 50);
        backButton.setFont(new Font(getName(), Font.PLAIN,12));
        backButton.addActionListener(e->openGameLobby());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("WEAPON SHOP");
        this.setSize(500, 500);
        this.setVisible(true);
        this.add(storeDisplay);
        this.add(backButton);
        this.add(swords);
        this.add(runes);
        this.add(katanas);

        updateDisplayRunes();
    }

    private void updateDisplayRunes(){
        runes.setText("RUNES: "+this.C.getPLAYER_RUNES());
    }

    private void openGameLobby(){
        gameLobby gameLobby=new gameLobby(this.C);
        this.dispose();
    }

    private boolean checkPrice(int runes, int price){
        if (runes>=price){
            return true;
        }

        return false;
    }

    private void swordMenu(){
        String choice=JOptionPane.showInputDialog("[1] Short Sword (1000)\n[2] Rogier's Rapier (2000)\n[3] Coded Sword (4000)\n[4] Sword of Night and Flame (8000)");
        int confirm;
        switch (choice){
            case "1":
                confirm=JOptionPane.showConfirmDialog(null, "Short Sword\nCost: 1000\nHP: 0\nDEX: 13\nEND: 15\nSTR: 15\nINT: 15\nFTH: 15", "Confirm Choice?", JOptionPane.YES_NO_OPTION);
                if (confirm==0)
                {
                    if (checkPrice(this.C.getPLAYER_RUNES(), 1000)==true){
                        Weapon weapon=new Weapon();
                        weapon.initializeWeapon("SHORT SWORD", 13, 0, 15, 15, 15, 15);
                        this.C.addWeapon(weapon);
                        this.C.setCharacterRunes(this.C.getPLAYER_RUNES()-1000);
                        updateDisplayRunes();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "NOT ENOUGH RUNES");
                    }
                }
                else if(confirm==1)
                {
                    JOptionPane.showMessageDialog(null, "CANCELLED PURCHASE");
                }
                break;
            case "2":
                confirm=JOptionPane.showConfirmDialog(null, "Rogier's Rapier\nCost: 2000\nHP: 10\nDEX: 18\nEND: 25\nSTR: 35\nINT: 35\nFTH: 35", "Confirm Choice?", JOptionPane.YES_NO_OPTION);
                if (confirm==0)
                {
                    if (checkPrice(this.C.getPLAYER_RUNES(), 2000)==true){
                        Weapon weapon=new Weapon();
                        weapon.initializeWeapon("ROGIER'S RAPIER", 18, 10, 25, 35, 35, 35);
                        this.C.addWeapon(weapon);
                        this.C.setCharacterRunes(this.C.getPLAYER_RUNES()-2000);
                        updateDisplayRunes();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "NOT ENOUGH RUNES");
                    }
                }
                else if(confirm==1)
                {
                    JOptionPane.showMessageDialog(null, "CANCELLED PURCHASE");
                }
                break;
            case "3":
                confirm=JOptionPane.showConfirmDialog(null, "Coded Sword\nCost: 4000\nHP: 20\nDEX: 21\nEND: 35\nSTR: 40\nINT: 40\nFTH: 40", "Confirm Choice?", JOptionPane.YES_NO_OPTION);
                if (confirm==0)
                {
                    if (checkPrice(this.C.getPLAYER_RUNES(), 4000)==true){
                        Weapon weapon=new Weapon();
                        weapon.initializeWeapon("CODED SWORD", 21, 20, 35, 40, 40, 40);
                        this.C.addWeapon(weapon);
                        this.C.setCharacterRunes(this.C.getPLAYER_RUNES()-4000);
                        updateDisplayRunes();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "NOT ENOUGH RUNES");
                    }
                }
                else if(confirm==1)
                {
                    JOptionPane.showMessageDialog(null, "CANCELLED PURCHASE");
                }
                break;
            case "4":
                confirm=JOptionPane.showConfirmDialog(null, "Sword of Night and Flame\nCost: 8000\nHP: 20\nDEX: 25\nEND: 45\nSTR: 55\nINT: 55\nFTH: 55", "Confirm Choice?", JOptionPane.YES_NO_OPTION);
                if (confirm==0)
                {
                    if (checkPrice(this.C.getPLAYER_RUNES(), 8000)==true){
                        Weapon weapon=new Weapon();
                        weapon.initializeWeapon("SWORD OF NIGHT AND FLAME", 25, 30, 45, 55, 55, 55);
                        this.C.addWeapon(weapon);
                        this.C.setCharacterRunes(this.C.getPLAYER_RUNES()-8000);
                        updateDisplayRunes();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "NOT ENOUGH RUNES");
                    }
                }
                else if(confirm==1)
                {
                    JOptionPane.showMessageDialog(null, "CANCELLED PURCHASE");
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "NOT A VALID INPUT");
                break;
        }
    }

    private void katanasMenu() {
        String choice=JOptionPane.showInputDialog("[1] Uchigatana (1875)\n[2] Moonveil (3750)\n[3] Rivers of Blood (7500)\n[4] Hand of Malenia (15000)");
        int confirm;
        switch (choice){
            case "1":
                confirm=JOptionPane.showConfirmDialog(null, "Uchigatana\nCost: 1875\nHP: 20\nDEX: 15\nEND: 35\nSTR: 30\nINT: 0\nFTH: 0", "Confirm Choice?", JOptionPane.YES_NO_OPTION);
                if (confirm==0)
                {
                    if (checkPrice(this.C.getPLAYER_RUNES(), 1875)==true){
                        Weapon weapon=new Weapon();
                        weapon.initializeWeapon("UCHIGATANA", 15, 20, 35, 30, 0, 0);
                        this.C.addWeapon(weapon);
                        this.C.setCharacterRunes(this.C.getPLAYER_RUNES()-1875);
                        updateDisplayRunes();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "NOT ENOUGH RUNES");
                    }
                }
                else if(confirm==1)
                {
                    JOptionPane.showMessageDialog(null, "CANCELLED PURCHASE");
                }
                break;
            case "2":
                confirm=JOptionPane.showConfirmDialog(null, "Moonveil\nCost: 3750\nHP: 30\nDEX: 20\nEND: 40\nSTR: 45\nINT: 0\nFTH: 0", "Confirm Choice?", JOptionPane.YES_NO_OPTION);
                if (confirm==0)
                {
                    if (checkPrice(this.C.getPLAYER_RUNES(), 3750)==true){
                        Weapon weapon=new Weapon();
                        weapon.initializeWeapon("MOONVEIL", 20, 30, 40, 45, 0, 0);
                        this.C.addWeapon(weapon);
                        this.C.setCharacterRunes(this.C.getPLAYER_RUNES()-3750);
                        updateDisplayRunes();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "NOT ENOUGH RUNES");
                    }
                }
                else if(confirm==1)
                {
                    JOptionPane.showMessageDialog(null, "CANCELLED PURCHASE");
                }
                break;
            case "3":
                confirm=JOptionPane.showConfirmDialog(null, "Rivers of Blood\nCost: 7500\nHP: 40\nDEX: 25\nEND: 45\nSTR: 60\nINT: 0\nFTH: 0", "Confirm Choice?", JOptionPane.YES_NO_OPTION);
                if (confirm==0)
                {
                    if (checkPrice(this.C.getPLAYER_RUNES(), 7500)==true){
                        Weapon weapon=new Weapon();
                        weapon.initializeWeapon("RIVERS OF BLOOD", 25, 40, 45, 60, 0, 0);
                        this.C.addWeapon(weapon);
                        this.C.setCharacterRunes(this.C.getPLAYER_RUNES()-7500);
                        updateDisplayRunes();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "NOT ENOUGH RUNES");
                    }
                }
                else if(confirm==1)
                {
                    JOptionPane.showMessageDialog(null, "CANCELLED PURCHASE");
                }
                break;
            case "4":
                confirm=JOptionPane.showConfirmDialog(null, "Hand of Malenia\nCost: 15000\nHP: 50\nDEX: 30\nEND: 50\nSTR: 75\nINT: 0\nFTH: 0", "Confirm Choice?", JOptionPane.YES_NO_OPTION);
                if (confirm==0)
                {
                    if (checkPrice(this.C.getPLAYER_RUNES(), 15000)==true){
                        Weapon weapon=new Weapon();
                        weapon.initializeWeapon("HAND OF MALENIA", 30, 50, 50, 75, 0, 0);
                        this.C.addWeapon(weapon);
                        this.C.setCharacterRunes(this.C.getPLAYER_RUNES()-15000);
                        updateDisplayRunes();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "NOT ENOUGH RUNES");
                    }
                }
                else if(confirm==1)
                {
                    JOptionPane.showMessageDialog(null, "CANCELLED PURCHASE");
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "NOT A VALID INPUT");
                break;
        }
    }
}
