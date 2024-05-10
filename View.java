import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class View {
    private JFrame frame;
    private JList<String> modelList;
    private JList<String> cartList;
    private JTextField modelNameField;
    private JTextField modelPriceField;
    private JTextField modelDescriptionField;
    private JButton addToCartButton;
    private JButton checkoutButton;
    private JButton addModelButton;

    public View() {
        frame = new JFrame("银行商店");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2, 2));

        modelList = new JList<>(new DefaultListModel<>());
        JScrollPane modelScrollPane = new JScrollPane(modelList);

        cartList = new JList<>(new DefaultListModel<>());
        JScrollPane cartScrollPane = new JScrollPane(cartList);

        JPanel addModelPanel = new JPanel(new GridLayout(4, 2));
        addModelPanel.add(new JLabel("商品名称: "));
        modelNameField = new JTextField();
        addModelPanel.add(modelNameField);
        addModelPanel.add(new JLabel("商品价格: "));
        modelPriceField = new JTextField();
        addModelPanel.add(modelPriceField);
        addModelPanel.add(new JLabel("商品描述: "));
        modelDescriptionField = new JTextField();
        addModelPanel.add(modelDescriptionField);
        addModelButton = new JButton("添加商品");
        addModelPanel.add(addModelButton);

        addToCartButton = new JButton("加入购物车");
        checkoutButton = new JButton("结账");

        frame.add(modelScrollPane);
        frame.add(addModelPanel);
        frame.add(cartScrollPane);
        frame.add(addToCartButton);
        frame.add(checkoutButton);
        frame.pack();
        frame.setVisible(true);
    }

    public void addModel(String model) {
        DefaultListModel<String> modelListModel = (DefaultListModel<String>) modelList.getModel();
        modelListModel.addElement(model);
    }

    public void addToCart(String model) {
        DefaultListModel<String> cartListModel = (DefaultListModel<String>) cartList.getModel();
        cartListModel.addElement(model);
    }

    public int getModelListSelectedIndex() {
        return modelList.getSelectedIndex();
    }

    public List<String> getCartItems() {
        return cartList.getSelectedValuesList();
    }

    public String getModelName() {
        return modelNameField.getText();
    }

    public double getModelPrice() {
        return Double.parseDouble(modelPriceField.getText());
    }

    public String getModelDescription() {
        return modelDescriptionField.getText();
    }

    public void setAddToCartButtonListener(ActionListener listener) {
        addToCartButton.addActionListener(listener);
    }

    public void setCheckoutButtonListener(ActionListener listener) {
        checkoutButton.addActionListener(listener);
    }

    public void setAddModelButtonListener(ActionListener listener) {
        addModelButton.addActionListener(listener);
    }

    public void showCheckoutMessage(String message) {
        JOptionPane.showMessageDialog(frame, message, "结账", JOptionPane.INFORMATION_MESSAGE);
    }
}














