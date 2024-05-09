import javax.swing.SwingUtilities;
import Model.User;
import View.LoginView;
import Control.LoginController;
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            User user = User.loadUser("user.json");  // 从JSON文件加载用户
            if (user == null) {
                System.out.println("系统故障，无法加载用户数据！");
            }
            LoginView loginView = new LoginView();
            new LoginController(loginView, user);
        });
    }
}
