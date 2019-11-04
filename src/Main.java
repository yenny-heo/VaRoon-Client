import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Main extends JFrame {

    public static void main(String[] args){

    }

    public Main(String token, String role, String name){
        //setting
        setTitle("VaRoon Client");
        setSize(1300, 731);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //panel
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);

        //background
        JLabel background = new JLabel("");
        //components
        ImageIcon icon = new ImageIcon("Image/rowlogo.png");
        Image im = icon.getImage();
        Image im2 =  im.getScaledInstance(120, 27, Image.SCALE_SMOOTH);
        ImageIcon icon2 = new ImageIcon(im2);
        JLabel logo = new JLabel(icon2);

        JLabel leftMenu = new JLabel("");
        JLabel topbar = new JLabel("");
        JLabel welcome = new JLabel("안녕하세요, "+name+"님");

        JLabel menuTitle = new JLabel("<html><font color='#bcbcbc'>M E N U</font></html>");
        JLabel homeacc = new JLabel("");
        JLabel home = new JLabel("<html><font color='#4b74ff'>홈</font></html>");
        JButton mesureBtn = new JButton("측정");
        JButton resultBtn = new JButton("결과 확인");

        JLabel contents =  new JLabel("컨텐츠 목록");
        ImageIcon icon3 = new ImageIcon("Image/fruitcutting.png");
        Image im3 = icon3.getImage();
        Image im4 =  im3.getScaledInstance(300, 146, Image.SCALE_SMOOTH);
        ImageIcon icon4 = new ImageIcon(im4);
        JButton fruitcuttingBtn = new JButton(icon4);
        ImageIcon icon5 = new ImageIcon("Image/youtube.png");
        Image im5 = icon5.getImage();
        Image im6 =  im5.getScaledInstance(300, 146, Image.SCALE_SMOOTH);
        ImageIcon icon6 = new ImageIcon(im6);
        JButton youtubeBtn = new JButton(icon6);
        ImageIcon icon7 = new ImageIcon("Image/game1.png");
        Image im7 = icon7.getImage();
        Image im8 =  im7.getScaledInstance(300, 146, Image.SCALE_SMOOTH);
        ImageIcon icon8 = new ImageIcon(im8);
        JButton game1Btn = new JButton(icon8);
        ImageIcon icon9 = new ImageIcon("Image/game2.png");
        Image im9 = icon9.getImage();
        Image im10 =  im9.getScaledInstance(300, 146, Image.SCALE_SMOOTH);
        ImageIcon icon10 = new ImageIcon(im10);
        JButton game2Btn = new JButton(icon10);
        ImageIcon icon11 = new ImageIcon("Image/game3.png");
        Image im11 = icon11.getImage();
        Image im12 =  im11.getScaledInstance(300, 146, Image.SCALE_SMOOTH);
        ImageIcon icon12 = new ImageIcon(im12);
        JButton game3Btn = new JButton(icon12);

        //set position & size
        logo.setBounds(585, 15, 120, 27);
        topbar.setBounds(-2,-1,1305,60);
        leftMenu.setBounds(-1, -1, 260, 732);
        welcome.setBounds(300, 120, 300, 30);

        menuTitle.setBounds(40, 120, 100, 40);
        homeacc.setBounds(0, 164, 6, 30);
        home.setBounds(41, 160, 100, 40);
        mesureBtn.setBounds(18, 200, 100, 40);
        resultBtn.setBounds(17, 240, 200, 40);

        contents.setBounds(300, 220, 100, 30);
        fruitcuttingBtn.setBounds(300,270,300,146);
        youtubeBtn.setBounds(620, 270, 300, 146);
        game1Btn.setBounds(940,270,300,146);
        game2Btn.setBounds(300, 436, 300, 146);
        game3Btn.setBounds(620, 436, 300, 146);

        background.setBounds(-1,-1,1300,731);

        //style
        Border border = BorderFactory.createLineBorder(Color.decode("#e2e2e2"), 1);
        topbar.setBorder(border);
        topbar.setBackground(Color.WHITE);
        topbar.setOpaque(true);
        leftMenu.setBorder(border);
        leftMenu.setBackground(Color.decode("#fcfcfc"));
        leftMenu.setOpaque(true);
        welcome.setFont(new Font("안녕하세요", Font.PLAIN, 23));
        homeacc.setBackground(Color.decode("#4b74ff"));
        homeacc.setOpaque(true);

        menuTitle.setFont(new Font("메뉴", Font.PLAIN, 18));
        home.setFont(new Font("홈", Font.PLAIN, 15));
        mesureBtn.setBorderPainted(false);
        mesureBtn.setHorizontalAlignment(SwingConstants.LEFT);
        mesureBtn.setFont(new Font("측정", Font.PLAIN, 15));
        resultBtn.setBorderPainted(false);
        resultBtn.setFont(new Font("결과 확인", Font.PLAIN, 15));
        resultBtn.setHorizontalAlignment(SwingConstants.LEFT);

        contents.setFont(new Font("컨텐츠 목록", Font.PLAIN, 15));
        fruitcuttingBtn.setBorderPainted(false);
        fruitcuttingBtn.setContentAreaFilled(false);
        fruitcuttingBtn.setOpaque(false);
        youtubeBtn.setBorderPainted(false);
        youtubeBtn.setContentAreaFilled(false);
        youtubeBtn.setOpaque(false);
        game1Btn.setBorderPainted(false);
        game1Btn.setContentAreaFilled(false);
        game1Btn.setOpaque(false);
        game2Btn.setBorderPainted(false);
        game2Btn.setContentAreaFilled(false);
        game2Btn.setOpaque(false);
        game3Btn.setBorderPainted(false);
        game3Btn.setContentAreaFilled(false);
        game3Btn.setOpaque(false);

        background.setBackground(Color.WHITE);
        background.setOpaque(true);


        jPanel.add(logo);
        jPanel.add(topbar);

        jPanel.add(welcome);
        jPanel.add(menuTitle);
        jPanel.add(homeacc);
        jPanel.add(home);
        jPanel.add(mesureBtn);
        jPanel.add(resultBtn);

        jPanel.add(contents);
        jPanel.add(fruitcuttingBtn);
        jPanel.add(youtubeBtn);
        jPanel.add(game1Btn);
        jPanel.add(game2Btn);
        jPanel.add(game3Btn);

        jPanel.add(leftMenu);
        jPanel.add(background);

        add(jPanel);

        //결과 확인 버튼
        resultBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    java.awt.Desktop.getDesktop().browse(java.net.URI.create("http://varoon.s3-website.ap-northeast-2.amazonaws.com/PatientCenter"));
                }
                catch (java.io.IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        });

        //과일썰기 게임
        fruitcuttingBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String osName = System.getProperty("os.name");
                System.out.println(" - OS Name: " + osName);
                Process process = null;
                try{
                    String cmd = null;
                    if (osName.toLowerCase().startsWith("mac os x")) {
                        //계산기 실행
                        cmd = new String("open "+"/Applications/Calculator.app "+ token);
                    }
                    else if(osName.toLowerCase().startsWith("window")){
                        cmd = new String("\"과일썰기 주소\" "+ token);
                    }
                    process = Runtime.getRuntime().exec(cmd);
                } catch (IOException e){
                    e.printStackTrace();
                } finally {
                    try {
                        process.waitFor();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    process.destroy();

                }

            }
        });

        //유튜브
        youtubeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String osName = System.getProperty("os.name");
                System.out.println(" - OS Name: " + osName);
                Process process = null;
                try{
                    String cmd = null;
                    if (osName.toLowerCase().startsWith("mac os x")) {
                        //계산기 실행
                        cmd = new String("open "+"유튜브 주소 "+ token);
                    }
                    else if(osName.toLowerCase().startsWith("window")){
                        cmd = new String("\"유튜브 주소\" "+ token);
                    }
                    process = Runtime.getRuntime().exec(cmd);
                } catch (IOException e){
                    e.printStackTrace();
                } finally {
                    try {
                        process.waitFor();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    process.destroy();

                }

            }
        });

        //측정
        mesureBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String osName = System.getProperty("os.name");
                System.out.println(" - OS Name: " + osName);
                Process process = null;
                try{
                    String cmd = null;
                    if (osName.toLowerCase().startsWith("mac os x")) {
                        cmd = new String("open "+"측정 주소 "+ token);
                    }
                    else if(osName.toLowerCase().startsWith("window")){
                        cmd = new String("\"측정 주소\" "+ token);
                    }
                    process = Runtime.getRuntime().exec(cmd);
                } catch (IOException e){
                    e.printStackTrace();
                } finally {
                    try {
                        process.waitFor();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    process.destroy();

                }

            }
        });

        setVisible(true);
    }
}

