import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * This class represents our character creator screen
 */
public class characterCreator extends JFrame implements ActionListener {

    private JButton confirmCharacter;
    private JButton characterClass;
    private JButton characterName;
    private JLabel Label1;
    private JLabel Label2;
    private JLabel Label3;
    private JLabel Label4;
    private JLabel Label5;
    private JLabel Label6;
    private JLabel Label7;
    private JLabel Label8;
    private Character C=new Character();

    /**
     * This constructor constructs our character creator object
     * @param C The player's character
     */
    public characterCreator(Character C){
        this.C=C;
        this.confirmCharacter=new JButton();
        confirmCharacter.setBounds(200, 400, 90, 50);
        confirmCharacter.setText("CONFIRM CHARACTER");
        confirmCharacter.setFocusable(false);
        confirmCharacter.setFont(new Font(getName(), Font.PLAIN, 5));
        confirmCharacter.addActionListener(this);

        characterClass=new JButton();
        characterClass.setBounds(150, 330, 90, 50);
        characterClass.setText("SET CLASS");
        characterClass.setFocusable(false);
        characterClass.setFont(new Font(getName(), Font.PLAIN, 9));
        characterClass.addActionListener(this);

        characterName=new JButton();
        characterName.setBounds(260, 330, 90, 50);
        characterName.setText("SET NAME");
        characterName.setFocusable(false);
        characterName.setFont(new Font(getName(), Font.PLAIN, 9));
        characterName.addActionListener(this);

        Label1=new JLabel();
        Label1.setText("CHARACTER NAME: "+this.C.getPLAYER_NAME());
        Label1.setBounds(100, 10, 500, 40);

        Label2=new JLabel();
        Label2.setText("CHARACTER JOBCLASS: "+this.C.getPLAYER_JOBCLASS());
        Label2.setBounds(100, 50, 500, 40);

        Label3=new JLabel();
        Label3.setText("CHARACTER HP: "+this.C.getPLAYER_HP());
        Label3.setBounds(100, 90, 500, 30);

        Label4=new JLabel();
        Label4.setText("CHARACTER DEX: "+this.C.getPLAYER_DEX());
        Label4.setBounds(100, 130, 500, 30);

        Label5=new JLabel();
        Label5.setText("CHARACTER INT: "+this.C.getPLAYER_INT());
        Label5.setBounds(100, 170, 500, 30);

        Label6=new JLabel();
        Label6.setText("CHARACTER END: "+this.C.getPLAYER_END());
        Label6.setBounds(100, 210, 500, 30);

        Label7=new JLabel();
        Label7.setText("CHARACTER STR: "+this.C.getPLAYER_STR());
        Label7.setBounds(100, 250, 500, 30);

        Label8=new JLabel();
        Label8.setText("CHARACTER FTH: "+this.C.getPLAYER_FTH());
        Label8.setBounds(100, 290, 500, 30);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500, 500);
        this.setVisible(true);
        this.setTitle("CHARACTER CREATOR");
        this.add(confirmCharacter);
        this.add(Label1);
        this.add(Label2);
        this.add(Label3);
        this.add(Label4);
        this.add(Label5);
        this.add(Label6);
        this.add(Label7);
        this.add(Label8);
        this.add(characterClass);
        this.add(characterName);
        this.setLocationRelativeTo(null);
    }

    /**
     * This function updates the label for the character name
     * @param characterName the Character's assigned name
     */
    private void updateName(String characterName){
        Label1.setText("CHARACTER NAME: "+characterName);
    }

    /**
     * This function updates the label for the character's jobclass
     * @param JOB_CLASS The character's Jobclass
     */
    private void updateJobClassLabel(String JOB_CLASS){
        Label2.setText("CHARACTER JOBCLASS: "+JOB_CLASS);
    }

    /**
     * This function updates the label for the character's HP stat
     * @param HP The character's HP stat
     */
    private void updateHPLabel(int HP){
        Label3.setText("CHARACTER HP: "+HP);
    }

    /**
     * This function updates the label for the character's DEX stat
     * @param DEX The character's DEX stat
     */
    private void updateDEXLabel(int DEX){
        Label4.setText("CHARACTER DEX: "+DEX);
    }

    /**
     * This function updates the label for the character's INT stat
     * @param INT The character's INT stat
     */
    private void updateINTLabel(int INT){
        Label5.setText("CHARACTER INT: "+INT);
    }

    /**
     * This function updates the label for the character's END stat
     * @param END The character's END stat
     */
    private void updateENDLabel(int END){
        Label6.setText("CHARACTER END: "+END);
    }

    /**
     * This function updates the label for the character's STR stat
     * @param STR The character's STR stat
     */
    private void updateSTRLabel(int STR){
        Label7.setText("CHARACTER STR: "+STR);
    }

    /**
     * This function updatest the label for the character's FTH stat
     * @param FTH The character's FTH stat
     */
    private void updateFTHLabel(int FTH){
        Label8.setText("CHARACTER FTH: "+FTH);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==characterName)
        {
            String characterName=JOptionPane.showInputDialog("Set character name: ");
            if(characterName.length()>25)
            {
                characterName=characterName.substring(0, 25);
            }
            this.C.setCharacterName(characterName);
            updateName(this.C.getPLAYER_NAME());
        }

        else if(e.getSource()==characterClass)
        {
            String characterClass=JOptionPane.showInputDialog("Set character JOBCLASS\n(1) Vagabond\n(2) Samurai\n(3) Warrior\n(4) Hero\n(5) Astrologer\n(6) Prophet");
            switch (characterClass){
                case "1":
                    this.C.setCharacterStats("Vagabond", 15, 13, 9, 11, 14, 9);
                    updateJobClassLabel("Vagabond");
                    updateHPLabel(15);
                    updateDEXLabel(13);
                    updateINTLabel(9);
                    updateENDLabel(11);
                    updateSTRLabel(14);
                    updateFTHLabel(9);
                    break;
                case "2":
                    this.C.setCharacterStats("Samurai", 12, 15, 9, 13, 12, 8);
                    updateJobClassLabel("Samurai");
                    updateHPLabel(12);
                    updateDEXLabel(15);
                    updateINTLabel(9);
                    updateENDLabel(13);
                    updateSTRLabel(12);
                    updateFTHLabel(8);
                    break;
                case "3":
                    this.C.setCharacterStats("Warrior", 11, 16, 10, 11, 10, 8);
                    updateJobClassLabel("Warrior");
                    updateHPLabel(11);
                    updateDEXLabel(16);
                    updateINTLabel(10);
                    updateENDLabel(11);
                    updateSTRLabel(10);
                    updateFTHLabel(8);
                    break;
                case "4":
                    this.C.setCharacterStats("Hero", 14, 9, 7, 12, 16, 8);
                    updateJobClassLabel("Hero");
                    updateHPLabel(14);
                    updateDEXLabel(9);
                    updateINTLabel(7);
                    updateENDLabel(12);
                    updateSTRLabel(16);
                    updateFTHLabel(8);
                    break;
                case "5":
                    this.C.setCharacterStats("Astrologer", 9, 12, 16, 9, 8, 7);
                    updateJobClassLabel("Astrologer");
                    updateHPLabel(9);
                    updateDEXLabel(12);
                    updateINTLabel(16);
                    updateENDLabel(9);
                    updateSTRLabel(8);
                    updateFTHLabel(7);
                    break;
                case "6":
                    this.C.setCharacterStats("Prophet", 10, 10, 7, 8, 11, 16);
                    updateJobClassLabel("Prophet");
                    updateHPLabel(10);
                    updateDEXLabel(10);
                    updateINTLabel(7);
                    updateENDLabel(8);
                    updateSTRLabel(11);
                    updateFTHLabel(16);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "NOT A VALID INPUT");
                    break;
            }
        }

        else if(e.getSource()==confirmCharacter){
            if (this.C.getPLAYER_NAME().isEmpty()||this.C.getPLAYER_JOBCLASS().isEmpty()){
                JOptionPane.showMessageDialog(null, "CHARACTER HAS NOT BEEN CREATED YET");
            }
            else{
                this.C.setisCreated(true);
                gameLobby gameLobby=new gameLobby(C);
                this.dispose();
            }
        }
        
    }
}
