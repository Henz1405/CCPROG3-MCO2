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
        swords.setBounds(205, 90, 90, 30);
        swords.setText("SWORDS");
        swords.setFocusable(false);
        swords.addActionListener(e->swordMenu());

        katanas=new JButton();
        katanas.setBounds(205, 130, 90, 30);
        katanas.setText("KATANAS");
        katanas.setFocusable(false);
        katanas.addActionListener(e->katanasMenu());

        whips=new JButton();
        whips.setBounds(205, 170, 90, 30);
        whips.setText("WHIPS");
        whips.setFocusable(false);
        whips.addActionListener(e->whipsMenu());

        greatSwords=new JButton();
        greatSwords.setBounds(205, 210, 90, 30);
        greatSwords.setText("GREATSWORDS");
        greatSwords.setFocusable(false);
        greatSwords.addActionListener(e->greatSwordsMenu());
        greatSwords.setFont(new Font(getName(), Font.PLAIN, 6));

        staves=new JButton();
        staves.setBounds(205, 250, 90, 30);
        staves.setText("STAVES");
        staves.setFocusable(false);
        staves.addActionListener(e->stavesMenu());

        seals=new JButton();
        seals.setBounds(205, 290, 90, 30);
        seals.setText("SEALS");
        seals.setFocusable(false);
        seals.addActionListener(e->sealsMenu());

        backButton=new JButton();
        backButton.setText("BACK");
        backButton.setFocusable(false);
        backButton.setBounds(205, 400, 90, 30);
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
        this.add(whips);
        this.add(greatSwords);
        this.add(staves);
        this.add(seals);
        this.setLocationRelativeTo(null);

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

    private void whipsMenu(){
        String choice=JOptionPane.showInputDialog("[1] Whip (1500)\n[2] Urumi (3000)\n[3] Thorned Whip (5000)\n[4] Hoslow's Petal Whip (10000)");
        int confirm;
        switch (choice){
            case "1":
                confirm=JOptionPane.showConfirmDialog(null, "Whip\nCost: 1500\nHP: 15\nDEX: 20\nEND: 60\nSTR: 20\nINT: 0\nFTH: 0", "Confirm Choice?", JOptionPane.YES_NO_OPTION);
                if (confirm==0)
                {
                    if (checkPrice(this.C.getPLAYER_RUNES(), 1500)==true){
                        Weapon weapon=new Weapon();
                        weapon.initializeWeapon("WHIP", 20, 15, 60, 20, 0, 0);
                        this.C.addWeapon(weapon);
                        this.C.setCharacterRunes(this.C.getPLAYER_RUNES()-1500);
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
                confirm=JOptionPane.showConfirmDialog(null, "Urumi\nCost: 3000\nHP: 20\nDEX: 25\nEND: 70\nSTR: 40\nINT: 10\nFTH: 0", "Confirm Choice?", JOptionPane.YES_NO_OPTION);
                if (confirm==0)
                {
                    if (checkPrice(this.C.getPLAYER_RUNES(), 3000)==true){
                        Weapon weapon=new Weapon();
                        weapon.initializeWeapon("URUMI", 25, 20, 70, 40, 10, 0);
                        this.C.addWeapon(weapon);
                        this.C.setCharacterRunes(this.C.getPLAYER_RUNES()-3000);
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
                confirm=JOptionPane.showConfirmDialog(null, "Thorned Whip\nCost: 5000\nHP: 30\nDEX: 30\nEND: 80\nSTR: 50\nINT: 0\nFTH: 40", "Confirm Choice?", JOptionPane.YES_NO_OPTION);
                if (confirm==0)
                {
                    if (checkPrice(this.C.getPLAYER_RUNES(), 5000)==true){
                        Weapon weapon=new Weapon();
                        weapon.initializeWeapon("THORNED WHIP", 30, 30, 70, 40, 0, 40);
                        this.C.addWeapon(weapon);
                        this.C.setCharacterRunes(this.C.getPLAYER_RUNES()-5000);
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
                confirm=JOptionPane.showConfirmDialog(null, "Hoslow's Petal Whip\nCost: 10000\nHP: 35\nDEX: 35\nEND: 90\nSTR: 55\nINT: 20\nFTH: 20", "Confirm Choice?", JOptionPane.YES_NO_OPTION);
                if (confirm==0)
                {
                    if (checkPrice(this.C.getPLAYER_RUNES(), 10000)==true){
                        Weapon weapon=new Weapon();
                        weapon.initializeWeapon("HOSLOW'S PETAL WHIP", 35, 35, 90, 55, 20, 20);
                        this.C.addWeapon(weapon);
                        this.C.setCharacterRunes(this.C.getPLAYER_RUNES()-10000);
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

    private void greatSwordsMenu(){
        String choice=JOptionPane.showInputDialog("[1] Claymore (3000)\n[2] Starscourge Greatsword (6000)\n[3] Inseparable Sword (12000)\n[4] Maliketh's Black Blade (24000)");
        int confirm;
        switch (choice){
            case "1":
                confirm=JOptionPane.showConfirmDialog(null, "Claymore\nCost: 3000\nHP: 15\nDEX: 9\nEND: 10\nSTR: 20\nINT: 0\nFTH: 0", "Confirm Choice?", JOptionPane.YES_NO_OPTION);
                if (confirm==0)
                {
                    if (checkPrice(this.C.getPLAYER_RUNES(), 3000)==true){
                        Weapon weapon=new Weapon();
                        weapon.initializeWeapon("CLAYMORE", 9, 15, 10, 20, 0, 0);
                        this.C.addWeapon(weapon);
                        this.C.setCharacterRunes(this.C.getPLAYER_RUNES()-3000);
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
                confirm=JOptionPane.showConfirmDialog(null, "Starscourge Greatsword\nCost: 6000\nHP: 20\nDEX: 14\nEND: 15\nSTR: 40\nINT: 0\nFTH: 20", "Confirm Choice?", JOptionPane.YES_NO_OPTION);
                if (confirm==0)
                {
                    if (checkPrice(this.C.getPLAYER_RUNES(), 6000)==true){
                        Weapon weapon=new Weapon();
                        weapon.initializeWeapon("STARSCOURGE GREATSWORD", 14, 20, 15, 40, 0, 20);
                        this.C.addWeapon(weapon);
                        this.C.setCharacterRunes(this.C.getPLAYER_RUNES()-6000);
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
                confirm=JOptionPane.showConfirmDialog(null, "Inseparable Sword\nCost: 12000\nHP: 25\nDEX: 19\nEND: 20\nSTR: 25\nINT: 60\nFTH: 60", "Confirm Choice?", JOptionPane.YES_NO_OPTION);
                if (confirm==0)
                {
                    if (checkPrice(this.C.getPLAYER_RUNES(), 12000)==true){
                        Weapon weapon=new Weapon();
                        weapon.initializeWeapon("INSEPARABLE SWORD", 19, 25, 20, 70, 60, 60);
                        this.C.addWeapon(weapon);
                        this.C.setCharacterRunes(this.C.getPLAYER_RUNES()-12000);
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
                confirm=JOptionPane.showConfirmDialog(null, "Maliketh's Black Blade\nCost: 24000\nHP: 30\nDEX: 24\nEND: 25\nSTR: 80\nINT: 40\nFTH: 60", "Confirm Choice?", JOptionPane.YES_NO_OPTION);
                if (confirm==0)
                {
                    if (checkPrice(this.C.getPLAYER_RUNES(), 24000)==true){
                        Weapon weapon=new Weapon();
                        weapon.initializeWeapon("MAKIKETH'S BLACK BLADE", 24, 30, 25, 80, 40, 60);
                        this.C.addWeapon(weapon);
                        this.C.setCharacterRunes(this.C.getPLAYER_RUNES()-24000);
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

    private void stavesMenu(){
        String choice=JOptionPane.showInputDialog("[1] Astrologer's Staff (2000)\n[2] Albinauric Staff (4000)\n[3] Staff of the Guilty (8000)\n[4] Carian Regal Scepter (16000)");
        int confirm;
        switch (choice){
            case "1":
                confirm=JOptionPane.showConfirmDialog(null, "Astrologer's Staff\nCost: 2000\nHP: 5\nDEX: 12\nEND: 20\nSTR: 5\nINT: 25\nFTH: 15", "Confirm Choice?", JOptionPane.YES_NO_OPTION);
                if (confirm==0)
                {
                    if (checkPrice(this.C.getPLAYER_RUNES(), 2000)==true){
                        Weapon weapon=new Weapon();
                        weapon.initializeWeapon("ASTROLOGER'S STAFF", 12, 5, 20, 5, 25, 15);
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
            case "2":
                confirm=JOptionPane.showConfirmDialog(null, "Albinauric Staff\nCost: 4000\nHP: 10\nDEX: 14\nEND: 20\nSTR: 10\nINT: 45\nFTH: 35", "Confirm Choice?", JOptionPane.YES_NO_OPTION);
                if (confirm==0)
                {
                    if (checkPrice(this.C.getPLAYER_RUNES(), 4000)==true){
                        Weapon weapon=new Weapon();
                        weapon.initializeWeapon("ALBINAURIC STAFF", 14, 10, 30, 10, 45, 35);
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
            case "3":
                confirm=JOptionPane.showConfirmDialog(null, "Staff of the Guilty\nCost: 8000\nHP: 15\nDEX: 16\nEND: 40\nSTR: 15\nINT: 65\nFTH: 60", "Confirm Choice?", JOptionPane.YES_NO_OPTION);
                if (confirm==0)
                {
                    if (checkPrice(this.C.getPLAYER_RUNES(), 8000)==true){
                        Weapon weapon=new Weapon();
                        weapon.initializeWeapon("STAFF OF THE GUILTY", 16, 15, 40, 15, 65, 60);
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
            case "4":
                confirm=JOptionPane.showConfirmDialog(null, "Carian Regal Scepter\nCost: 16000\nHP: 25\nDEX: 18\nEND: 50\nSTR: 20\nINT: 85\nFTH: 75", "Confirm Choice?", JOptionPane.YES_NO_OPTION);
                if (confirm==0)
                {
                    if (checkPrice(this.C.getPLAYER_RUNES(), 16000)==true){
                        Weapon weapon=new Weapon();
                        weapon.initializeWeapon("CARIAN REGAL SCEPTER", 18, 25, 50, 20, 85, 75);
                        this.C.addWeapon(weapon);
                        this.C.setCharacterRunes(this.C.getPLAYER_RUNES()-16000);
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

    private void sealsMenu(){
        String choice=JOptionPane.showInputDialog("[1] Finger Seal (2500)\n[2] Godslayer's Seal (5000)\n[3] Golden Order Seal (10000)\n[4] Dragon Communion Seal (15000)");
        int confirm;
        switch (choice){
            case "1":
                confirm=JOptionPane.showConfirmDialog(null, "Finger Seal\nCost: 2500\nHP: 10\nDEX: 10\nEND: 45\nSTR: 0\nINT: 15\nFTH: 20", "Confirm Choice?", JOptionPane.YES_NO_OPTION);
                if (confirm==0)
                {
                    if (checkPrice(this.C.getPLAYER_RUNES(), 2500)==true){
                        Weapon weapon=new Weapon();
                        weapon.initializeWeapon("FINGER SEAL", 10, 10, 45, 0, 15, 20);
                        this.C.addWeapon(weapon);
                        this.C.setCharacterRunes(this.C.getPLAYER_RUNES()-2500);
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
                confirm=JOptionPane.showConfirmDialog(null, "Godslayer's Seal\nCost: 5000\nHP: 15\nDEX: 12\nEND: 50\nSTR: 0\nINT: 35\nFTH: 40", "Confirm Choice?", JOptionPane.YES_NO_OPTION);
                if (confirm==0)
                {
                    if (checkPrice(this.C.getPLAYER_RUNES(), 5000)==true){
                        Weapon weapon=new Weapon();
                        weapon.initializeWeapon("GODSLAYER'S SEAL", 12, 15, 50, 0, 35, 40);
                        this.C.addWeapon(weapon);
                        this.C.setCharacterRunes(this.C.getPLAYER_RUNES()-5000);
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
                confirm=JOptionPane.showConfirmDialog(null, "Golden Order Seal\nCost: 10000\nHP: 20\nDEX: 14\nEND: 55\nSTR: 0\nINT: 65\nFTH: 65", "Confirm Choice?", JOptionPane.YES_NO_OPTION);
                if (confirm==0)
                {
                    if (checkPrice(this.C.getPLAYER_RUNES(), 10000)==true){
                        Weapon weapon=new Weapon();
                        weapon.initializeWeapon("GOLDEN ORDER SEAL", 14, 20, 55, 0, 65, 65);
                        this.C.addWeapon(weapon);
                        this.C.setCharacterRunes(this.C.getPLAYER_RUNES()-10000);
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
                confirm=JOptionPane.showConfirmDialog(null, "Dragon Communion Seal\nCost: 15000\nHP: 25\nDEX: 18\nEND: 60\nSTR: 0\nINT: 75\nFTH: 80", "Confirm Choice?", JOptionPane.YES_NO_OPTION);
                if (confirm==0)
                {
                    if (checkPrice(this.C.getPLAYER_RUNES(), 15000)==true){
                        Weapon weapon=new Weapon();
                        weapon.initializeWeapon("DRAGON COMMUNION SEAL", 18, 25, 60, 0, 75, 80);
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
