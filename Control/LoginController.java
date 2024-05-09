package Control;

import View.LoginView;
import View.RegisterView;
import View.MainView;
import Model.User;

import javax.swing.*;

public class LoginController {
    private LoginView loginView;
    private RegisterView registerView;
    private RegisterController registerController;

    public LoginController(LoginView loginView) {
        this.loginView = loginView;
        this.registerView = new RegisterView();
        this.registerController = new RegisterController(registerView, new User(), loginView);
        initView();
    }

    private void initView() {
        loginView.getLoginButton().addActionListener(e -> performLogin());
        loginView.getRegisterButton().addActionListener(e -> performRegistration());
        loginView.setVisible(true);
        registerView.setVisible(false); // 确保注册视图初始不可见
    }

    private void performLogin() {
        String username = loginView.getUsernameField().getText();
        String password = new String(loginView.getPasswordField().getPassword());
        User user = User.validate(username, password); // 假设validate现在返回User对象或null

        if (user != null) {
            JOptionPane.showMessageDialog(loginView, "登录成功", "成功", JOptionPane.INFORMATION_MESSAGE);
            loginView.setVisible(false);
            MainView mainView = new MainView(user);
            mainView.setVisible(true);
            MainController mainController = new MainController(mainView,user);
        } else {
            JOptionPane.showMessageDialog(loginView, "登录失败：用户名或密码错误", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void performRegistration() {
        loginView.setVisible(false);
        registerView.setVisible(true);
    }
}
