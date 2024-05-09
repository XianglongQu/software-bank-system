package Control;

import View.LoginView;
import View.RegisterView;
import Model.User;
import javax.swing.*;
public class LoginController {
    private LoginView loginView;
    private User user;
    private RegisterView registerView;
    private RegisterController registerController;

    public LoginController(LoginView loginView, User user) {
        this.loginView = loginView;
        this.user = user;
        this.registerView = new RegisterView(); // 实例化注册视图
        // 确保传递正确的参数，包括新的 User 对象和 loginView
        this.registerController = new RegisterController(registerView, new User(), loginView);
        initView();
    }

    private void initView() {
        loginView.getLoginButton().addActionListener(e -> performLogin());
        loginView.getRegisterButton().addActionListener(e -> performRegistration());
        loginView.setVisible(true); // 只在需要时显示登录视图
        registerView.setVisible(false); // 确保注册视图初始不可见
    }

    private void performLogin() {
        String username = loginView.getUsernameField().getText();
        String password = new String(loginView.getPasswordField().getPassword());

        if (user.validate(username, password)) {
            JOptionPane.showMessageDialog(loginView, "登录成功", "成功", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(loginView, "登录失败：用户名或密码错误", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void performRegistration() {
        loginView.setVisible(false); // 隐藏登录视图
        registerView.setVisible(true); // 显示注册视图
    }
}
