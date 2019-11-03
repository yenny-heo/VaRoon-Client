
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClients;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class Login extends JFrame{
    private Controller controller;
    public static void main(String args[]) {

    }

    public Login(){
        //setting
        setTitle("VaRoon Login");
        setSize(1300, 731);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);


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

        JLabel topbar = new JLabel("");
        JLabel title = new JLabel("로그인");
        JLabel idLabel = new JLabel("ID");
        JTextField idField = new JTextField(10);
        idField.setMaximumSize(idField.getPreferredSize());
        JLabel pwLabel = new JLabel("Password");
        JPasswordField pwField = new JPasswordField(10);
        pwField.setMaximumSize(idField.getPreferredSize());
        JButton loginButton = new JButton("로그인");

        //set position & size
        background.setBounds(-1,-1,1300,731);
        logo.setBounds(585, 15, 120, 27);
        topbar.setBounds(-2,-1,1305,60);
        title.setBounds(618, 150,  300, 50);
        idLabel.setBounds(505, 245,  300, 50);
        idField.setBounds(500, 280,  300, 50);
        pwLabel.setBounds(505, 330,  300, 50);
        pwField.setBounds(500, 365,  300, 50);
        loginButton.setBounds(500, 470, 300, 50);

        background.setBackground(Color.WHITE);
        background.setOpaque(true);
        title.setFont(new Font("로그인", Font.PLAIN, 23));
        loginButton.setBackground(Color.decode("#4b74ff"));
        loginButton.setForeground(Color.decode("#4b74ff"));
        Border border = BorderFactory.createLineBorder(Color.decode("#e2e2e2"), 1);
        topbar.setBorder(border);






        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String id = idField.getText();
                String pw = pwField.getText();
                try {

                    HttpClient httpclient = HttpClients.createDefault();
                    HttpPost httppost = new HttpPost("http://15.164.220.109/Api/Home/Login");
                    httppost.setHeader("accept", "application/json");
                    httppost.setHeader("Content-Type", "application/json");


                    String json = "{ \"id\": \""+ id +"\", \"pw\": \""+ pw +"\"}";
                    httppost.setEntity(new StringEntity(json));

                    HttpResponse response = httpclient.execute(httppost);
                    HttpEntity entity = response.getEntity();

                    if (response.getStatusLine().getStatusCode() == 200) {//로그인 성공
                        ResponseHandler<String> handler = new BasicResponseHandler();
                        String body = handler.handleResponse(response);

                        //parsing
                        JSONParser p = new JSONParser();
                        Object obj = p.parse(body);
                        JSONObject jsonObj = (JSONObject) obj;

                        String token = (String)jsonObj.get("token");
                        String role = (String)jsonObj.get("role");
                        String name = (String)jsonObj.get("name");

                        System.out.println(name);
                        controller.showMain(token, role, name);
                    } else {
                        System.out.println("response is error : " + response);
                        JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 일치하지 않습니다");
                    }

                } catch (Exception e){
                    System.err.println(e.toString());
                }

            }
        });

        jPanel.add(logo);
        jPanel.add(topbar);
        jPanel.add(title);
        jPanel.add(idLabel);
        jPanel.add(idField);
        jPanel.add(pwLabel);
        jPanel.add(pwField);
        jPanel.add(loginButton);
        jPanel.add(background);

        add(jPanel);
    }

    public void setMain(Controller controller){
        this.controller = controller;
    }

}
