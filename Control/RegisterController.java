package Control;

import Model.User;
import View.RegisterView;
import View.LoginView;
import javax.swing.*;

public class RegisterController {
    private RegisterView registerView;
    private User user;
    private LoginView loginView;

    public RegisterController(RegisterView registerView, User user, LoginView loginView) {
        this.registerView = registerView;
        this.user = user;
        this.loginView = loginView;
        initController();
    }

    private void initController() {
        registerView.getRegisterButton().addActionListener(e -> performRegistration());
        registerView.getBackButton().addActionListener(e -> goBackToLogin());
        registerView.getAddFamilyMemberButton().addActionListener(e -> addFamilyMember());
        registerView.setVisible(true);
    }

    private void performRegistration() {
        String username = registerView.getUsername();
        String password = registerView.getPassword();
        String userType = registerView.getUserType();
        java.util.List<String> familyMembers = registerView.getFamilyMembers();
        String currency = registerView.getCurrency();

        User newUser = new User(username, password, userType, familyMembers, currency);
        boolean success = User.registerUser("users.json", newUser);

        if (success) {
            JOptionPane.showMessageDialog(registerView, "注册成功！", "成功", JOptionPane.INFORMATION_MESSAGE);
            goBackToLogin();
        } else {
            JOptionPane.showMessageDialog(registerView, "注册失败，请检查输入或稍后重试。", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addFamilyMember() {
        String memberName = registerView.getFamilyMemberNameField().getText();
        if (!memberName.isEmpty()) {
            registerView.getFamilyMembersListModel().addElement(memberName);
            registerView.getFamilyMemberNameField().setText("");
        } else {
            JOptionPane.showMessageDialog(registerView, "成员姓名不能为空！", "错误", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void goBackToLogin() {
        // 假设有一个返回登录界面的方法
        // 此处应该实现视图的转换，例如关闭注册窗口，打开登录窗口
        registerView.setVisible(false);
        loginView.setVisible(true); // 假定 loginView 是已经实例化的登录视图
    }
}
