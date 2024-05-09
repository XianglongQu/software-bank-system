package Control;

import View.LoginView;
import View.RegisterView;
import View.MainView;  // 导入主页面视图
import Model.User;
import javax.swing.*;

public class LoginController {
    private LoginView loginView;

    private User user;
    private RegisterView registerView;
    private MainView mainView;
    private RegisterController registerController;
    private MainController mainController;

    public LoginController(LoginView loginView, User user) {
        this.loginView = loginView;
        this.user = user;
        this.registerView = new RegisterView(); // 实例化注册视图
        this.registerController = new RegisterController(registerView, new User(), loginView);
        this.mainView = new MainView(user);
        this.mainController = new MainController(mainView, user);
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

        if (User.validate(username, password)) {
            JOptionPane.showMessageDialog(loginView, "登录成功", "成功", JOptionPane.INFORMATION_MESSAGE);
            loginView.setVisible(false); // 登录成功，隐藏登录界面


            // 创建 MainView 实例并传入用户名和余额
             // 确保此处正确创建了 MainView 实例
            mainView.setVisible(true); // 显示主页面

        } else {
            JOptionPane.showMessageDialog(loginView, "登录失败：用户名或密码错误", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void performRegistration() {
        loginView.setVisible(false); // 隐藏登录界面
        registerView.setVisible(true); // 显示注册视图
    }
}
