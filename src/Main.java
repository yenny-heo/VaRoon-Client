import javax.swing.*;

public class Main extends JFrame {


    public Main(String token, String role, String name){
        //setting
        setTitle("VaRoon Client");
        setSize(1300, 731);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        //panel
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);

        //background
        JLabel background = new JLabel("");

        jPanel.add(background);

        add(jPanel);
    }
}

