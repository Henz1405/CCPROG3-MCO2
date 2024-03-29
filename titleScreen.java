import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class titleScreen extends JFrame {
    private JButton enterButton;
    private JButton exitButton;
    private Character C;

    public titleScreen(Character C) {
        this.C=C;
        setTitle("Title Screen");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JLabel titleLabel = new JLabel("Welcome to Elden Rogue");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel);

        enterButton = new JButton("Enter Game");
        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle entering the game
                openCharacterCreator();
            }
        });
        panel.add(enterButton);

        exitButton = new JButton("Exit Game");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle exiting the game
                int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        panel.add(exitButton);

        add(panel);
        setVisible(true);
    }

    private void openCharacterCreator() {
        if (this.C.getisCreated()==false){
            JOptionPane.showMessageDialog(null, "Entering the character creator...");
            characterCreator CharacterCreator = new characterCreator(this.C);
            this.dispose();
        }
        else if(this.C.getisCreated()==true){
            gameLobby gameLobby=new gameLobby(this.C);
            this.dispose();
        }
    }

    
}
