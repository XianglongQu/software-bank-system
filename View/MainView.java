package View;
import Model.User;
import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    private JLabel userInfoLabel;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton transactionHistoryButton;
    private JButton taskButton;
    private JButton studyButton;
    private JButton shopButton;
    private JButton regulationButton;

    public MainView(User user) {
        initializeUI(user.getUsername());
    }

    private void initializeUI(String username) {
        setTitle("主页面");
        setSize(600, 400); // 设置窗口大小
        setLayout(new FlowLayout()); // 使用流式布局
        setLocationRelativeTo(null); // 窗口居中
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 用户信息显示
        userInfoLabel = new JLabel("用户名: " + username);
        add(userInfoLabel);

        // 存款按钮
        depositButton = new JButton("存款");
        add(depositButton);

        // 取款按钮
        withdrawButton = new JButton("取款");
        add(withdrawButton);

        // 交易历史按钮
        transactionHistoryButton = new JButton("交易记录");
        add(transactionHistoryButton);

        // 任务按钮
        taskButton = new JButton("任务");
        add(taskButton);

        // 学习按钮
        studyButton = new JButton("学习");
        add(studyButton);

        // 商店按钮
        shopButton = new JButton("商店");
        add(shopButton);

        // 监管按钮
        regulationButton = new JButton("监管");
        add(regulationButton);
    }

    public JButton getDepositButton() {
        return depositButton;
    }

    public JButton getWithdrawButton() {
        return withdrawButton;
    }

    public JButton getTransactionHistoryButton() {
        return transactionHistoryButton;
    }

    public JButton getTaskButton() {
        return taskButton;
    }

    public JButton getStudyButton() {
        return studyButton;
    }

    public JButton getShopButton() {
        return shopButton;
    }

    public JButton getRegulationButton() {
        return regulationButton;
    }
}
