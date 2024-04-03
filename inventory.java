import javax.swing.*;
import java.awt.Font;

/**
 * Represents the inventory screen where the player can manage their inventory and equip weapons.
 */
public class inventory extends JFrame {
    private Character C;
    private JButton quitGame;
    private JButton equipWeapon;
    private JLabel equippedWeapon;
    private JList<String> list;

     /**
     * Constructs a new inventory screen.
     *
     * @param C The character object representing the player.
     */
    inventory(Character C){
        this.C=C;

        equippedWeapon=new JLabel();
        equippedWeapon.setBounds(170, 30, 500, 50);

        quitGame=new JButton();
        quitGame.setText("BACK");
        quitGame.setBounds(205, 400, 90, 50);
        quitGame.setFocusable(false);
        quitGame.setFont(new Font(getName(), Font.PLAIN, 12));
        quitGame.addActionListener(e -> openGameLobby());

        equipWeapon=new JButton();
        equipWeapon.setText("EQUIP");
        equipWeapon.setBounds(205, 340, 90, 50);
        equipWeapon.setFocusable(false);
        equipWeapon.addActionListener(e->equipWeapon());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("GAME LOBBY");
        this.setSize(500, 500);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.add(quitGame);
        this.add(equippedWeapon);
        this.add(equipWeapon);
        updateEquippedWeapon();
        displayInventory();
    }

    /**
     * Allows the player to equip a weapon from their inventory.
     */
    private void equipWeapon(){
        try {
            int option=Integer.parseInt(JOptionPane.showInputDialog("ENTER WEAPON INDEX (0: first)"));
            int option2=JOptionPane.showConfirmDialog(null, "Weapon Name: "+this.C.getInventory().get(option).getWeaponName()+"\nWeapon HP: "+this.C.getInventory().get(option).getWeaponHp()+"\nWeapon DEX: "+this.C.getInventory().get(option).getWeaponDex()+"\nWeapon END: "+this.C.getInventory().get(option).getWeaponDex()+"\nWeapon STR: "+this.C.getInventory().get(option).getWeaponStr()+"\nWeapon INT: "+this.C.getInventory().get(option).getWeaponInt()+"\nWeapon FTH: "+this.C.getInventory().get(option).getWeaponFth(), "EQUIP WEAPON?", JOptionPane.YES_NO_OPTION);
            if (option2==0){
                if (this.C.getPLAYER_DEX()>=this.C.getInventory().get(option).getWeaponDex())
                {
                    this.C.setEquippedWeapon(this.C.getInventory().get(option));
                    updateEquippedWeapon();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "NOT ENOUGH DEX");
                }
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "WEAPON DOESN'T EXIST");
        }
    } 

    /**
     * Displays the player's inventory.
     */
    private void displayInventory(){
        if (this.C.getInventory().isEmpty()){
            JLabel JLabel=new JLabel();
            JLabel.setBounds(170, 60, 500, 50);
            JLabel.setText("NO WEAPONS AVAILABLE");
            this.add(JLabel);
        }
        else{
            String[] array=new String[this.C.getInventory().size()];
            for (int x=0; x<this.C.getInventory().size(); x++)
            {
                array[x]=this.C.getInventory().get(x).getWeaponName();
            }            
            list = new JList<>(array);
            JScrollPane scrollPane = new JScrollPane(list);
            scrollPane.setBounds(100, 70, 300, 250);
            this.add(scrollPane);
        }
    }

    /**
     * Updates the label showing the currently equipped weapon.
     */
    private void updateEquippedWeapon(){
        if (this.C.getEquippedWeapon().getWeaponName()==null){
            equippedWeapon.setText("EQUIPPED WEAPON: NONE");
        }
        else
        {
            equippedWeapon.setText("EQUIPPED WEAPON: "+this.C.getEquippedWeapon().getWeaponName());
        }
    }

    /**
     * Opens the game lobby screen.
     */
    private void openGameLobby(){
        gameLobby gameLobby=new gameLobby(this.C);
        this.dispose();
    }
}
