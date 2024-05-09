package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RegisterView extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> userTypeComboBox;
    private DefaultListModel<String> familyMembersListModel;
    private JList<String> familyMembersList;
    private JButton addFamilyMemberButton;
    private JTextField familyMemberNameField;
    private JComboBox<String> currencyComboBox;
    private JButton registerButton;
    private JButton backButton;

    public RegisterView() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("注册系统");
        setSize(400, 400); // 设置窗口大小
        setLayout(new GridLayout(0, 2, 10, 10)); // 使用网格布局
        setLocationRelativeTo(null); // 窗口居中
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("用户名:"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("密码:"));
        passwordField = new JPasswordField();
        add(passwordField);

        add(new JLabel("用户类型:"));
        String[] userTypes = {"孩子", "父母"};
        userTypeComboBox = new JComboBox<>(userTypes);
        add(userTypeComboBox);

        add(new JLabel("家庭成员姓名:"));
        familyMemberNameField = new JTextField();
        add(familyMemberNameField);

        addFamilyMemberButton = new JButton("添加成员");
        add(addFamilyMemberButton);

        familyMembersListModel = new DefaultListModel<>();
        familyMembersList = new JList<>(familyMembersListModel);
        JScrollPane familyMembersScrollPane = new JScrollPane(familyMembersList);
        add(familyMembersScrollPane);

        add(new JLabel("货币类型:"));
        String[] currencies = {"人民币", "欧元", "日元", "美元", "英镑"};
        currencyComboBox = new JComboBox<>(currencies);
        add(currencyComboBox);

        registerButton = new JButton("注册");
        add(registerButton);

        backButton = new JButton("返回登录");
        add(backButton);
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public String getUserType() {
        return (String) userTypeComboBox.getSelectedItem();
    }

    public List<String> getFamilyMembers() {
        List<String> members = new ArrayList<>();
        for (int i = 0; i < familyMembersListModel.size(); i++) {
            members.add(familyMembersListModel.getElementAt(i));
        }
        return members;
    }

    public String getCurrency() {
        return (String) currencyComboBox.getSelectedItem();
    }

    public JButton getRegisterButton() {
        return registerButton;
    }

    public JButton getAddFamilyMemberButton() {
        return addFamilyMemberButton;
    }

    public JTextField getFamilyMemberNameField() {
        return familyMemberNameField;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public DefaultListModel<String> getFamilyMembersListModel() {
        return familyMembersListModel;
    }
}
