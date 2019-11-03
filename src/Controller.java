
import javax.swing.JFrame;

public class Controller {

    Login login;
    Main main;
    public static void main(String[] args){
        Controller controller = new Controller();
        controller.login = new Login();
        controller.login.setMain(controller);
    }
    //로그인 완료시 메인화면으로 이동
    public void showMain(String token, String role, String name){
        login.dispose();
        this.main = new Main(token, role, name);
    }
}