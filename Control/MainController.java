package Control;

import View.MainView;
import Model.User;
import Model.Transaction;
import javax.swing.*;

public class MainController {
    private MainView mainView;
    private User user;

    public MainController(MainView mainView, User user) {
        this.mainView = mainView;
        this.user = user;
        initView();
    }

    private void initView() {
        // 绑定事件处理器
        mainView.getDepositButton().addActionListener(e -> handleDeposit());
        mainView.getWithdrawButton().addActionListener(e -> handleWithdraw());
        mainView.getTransactionHistoryButton().addActionListener(e -> displayTransactionHistory());
        mainView.getTaskButton().addActionListener(e -> openTaskPage());
        mainView.getStudyButton().addActionListener(e -> openStudyPage());
        mainView.getShopButton().addActionListener(e -> openShopPage());
        mainView.getRegulationButton().addActionListener(e -> openRegulationPage());
        mainView.setVisible(true); // 显示主页面
    }

    private void handleDeposit() {
        // 以下是简化示例，实际操作可能涉及弹出对话框等获取详细信息
        String amountString = JOptionPane.showInputDialog(mainView, "请输入存款金额:");
        try {
            double amount = Double.parseDouble(amountString);
            user.deposit(amount, "活期", ""); // 假设是活期存款
            JOptionPane.showMessageDialog(mainView, "存款成功！");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(mainView, "请输入有效的金额！", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleWithdraw() {
        String amountString = JOptionPane.showInputDialog(mainView, "请输入取款金额:");
        try {
            double amount = Double.parseDouble(amountString);
            user.withdraw(amount, "活期");
            JOptionPane.showMessageDialog(mainView, "取款成功！");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainView, e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayTransactionHistory() {
        StringBuilder history = new StringBuilder("<html>交易记录：<br>");
        for (Transaction transaction : user.getTransactions()) {
            history.append(transaction.getType()).append(" - ").append(transaction.getAmount())
                    .append(" (").append(transaction.getTimestamp()).append(")<br>");
        }
        history.append("</html>");
        JOptionPane.showMessageDialog(mainView, history.toString());
    }

    private void openTaskPage() {
        // 打开任务页面逻辑
    }

    private void openStudyPage() {
        // 打开学习页面逻辑
    }

    private void openShopPage() {
        // 打开商店页面逻辑
    }

    private void openRegulationPage() {
        // 打开监管页面逻辑
    }
}
