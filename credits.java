import javax.swing.*;

/**
 * The credits screen
 */
public class credits extends JFrame{
    private JLabel madeBy;
    private JLabel name1;
    private JLabel name2;

    /**
     * Constructor for the credits screen
     */
    public credits(){
        this.setTitle("CREDITS");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setLayout(null);

        this.madeBy=new JLabel();
        madeBy.setBounds(230, 10, 500, 50);
        madeBy.setText("MADE BY");

        this.name1=new JLabel();
        name1.setBounds(200, 80, 500, 50);
        name1.setText("YOUNG, HENZLEY");

        this.name2=new JLabel();
        name2.setBounds(200, 100, 500, 50);
        name2.setText("MALICSI, PATRICK");

        this.add(madeBy);
        this.add(name1);
        this.add(name2);
    }
}