import java.awt.Font;
import javax.swing.*;

public class titleScreen extends JFrame{
    JButton startGame;
    JButton closeGame;
    private Character C=new Character();
    public titleScreen(Character C){
        this.C=C;
        this.startGame=new JButton();
        this.closeGame=new JButton();

        startGame.setBounds(200, 300, 100, 50);
        startGame.setText("START GAME");
        startGame.setFont(new Font(getName(), Font.PLAIN, 8));
        startGame.addActionListener(e -> opencharacterCreator(C));
        startGame.setFocusable(false);

        closeGame.setText("CLOSE GAME");
        closeGame.setBounds(200, 350, 100, 50);
        closeGame.setFont(new Font(getName(), Font.PLAIN, 8));
        closeGame.addActionListener(e -> closeApp());
        closeGame.setFocusable(false);

        JLabel Label1= new JLabel();
        Label1.setText("ELDEN ROGUE");
        Label1.setBounds(180, 150, 150, 150);
        Label1.setHorizontalAlignment(JLabel.CENTER);
        Label1.setFont(new Font(getName(), Font.PLAIN, 20));
        

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500, 500);
        this.setVisible(true);
        this.add(Label1);
        this.add(startGame);
        this.add(closeGame);
        this.setTitle("TITLESCREEN");
    }


    private void opencharacterCreator(Character C){
        if (this.C.getisCreated()==false){
            characterCreator characterCreator=new characterCreator(C);
            this.dispose();
        }
        else if(this.C.getisCreated()==true){
            gameLobby gameLobby=new gameLobby(C);
            this.dispose();
        }
    }

    private void closeApp(){
        this.dispose();
    }

}


