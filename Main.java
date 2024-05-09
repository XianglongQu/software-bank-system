import javax.swing.SwingUtilities;
import Model.User;
import View.LoginView;
import Control.LoginController;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            List<User> users = User.loadUsers("D:\\QM courses\\software engineering\\software engineering\\users.json");  // 从JSON文件加载用户
            if (users.isEmpty()) {
                System.out.println("系统故障，无法加载用户数据！");
                return;
            }
            User user1 = users.get(0);
            LoginView loginView = new LoginView();
            String username = loginView.getUsernameField().getText();
            String password = new String(loginView.getPasswordField().getPassword());
            for(int i=0; i< users.size();i++){
                if( users.get(i).getUsername().equals(username) &&
                        users.get(i).getUsername().equals(password) ){
                    user1  = users.get(i);
                }
            }
            new LoginController(loginView,user1);
        });
    }
}
