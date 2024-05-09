package View;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;

    public LoginView() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("登录系统");
        setSize(600, 400); // 设置窗口大小
        setLocationRelativeTo(null); // 窗口居中
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 15, 15)); // 使用网格布局

        // 添加组件
        add(new JLabel("用户名:"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("密码:"));
        passwordField = new JPasswordField();
        add(passwordField);

        loginButton = new JButton("登录");
        add(loginButton);

        registerButton = new JButton("注册");
        add(registerButton);
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }
}
