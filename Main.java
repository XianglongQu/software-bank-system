import javax.swing.SwingUtilities;
import Model.User;
import View.LoginView;
import Control.LoginController;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginView loginView = new LoginView();
            LoginController loginController = new LoginController(loginView);
        });
    }
}
