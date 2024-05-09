package Model;

import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private String userType;
    private List<String> familyMembers;
    private String currency;
    private double balance; // 用户余额
    private List<Transaction> transactions; // 交易记录

    // 无参数构造器
    // 无参数构造器
    public User() {
        this.familyMembers = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }
    public User(String username, String password, String userType, List<String> familyMembers, String currency, double initialBalance) {
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.familyMembers = familyMembers;
        this.currency = currency;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
    }

    // 带参数的构造器

    // 加载用户数据
    public static User loadUser(String path) {
        try {
            String data = new String(Files.readAllBytes(Paths.get(path)));
            JSONObject json = new JSONObject(data);
            JSONArray membersJson = json.optJSONArray("familyMembers");
            List<String> members = new ArrayList<>();
            if (membersJson != null) {
                for (int i = 0; i < membersJson.length(); i++) {
                    members.add(membersJson.getString(i));
                }
            }
            return new User(
                    json.getString("username"),
                    json.getString("password"),
                    json.getString("userType"),
                    members,
                    json.getString("currency"),
                    json.optDouble("balance", 0.0) // Default to 0 if not specified
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 验证用户的凭证
    public boolean validate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    // 注册新用户并保存到 JSON 文件
    public static boolean registerUser(String path, User newUser) {
        try {
            JSONObject newUserJson = new JSONObject();
            newUserJson.put("username", newUser.username);
            newUserJson.put("password", newUser.password);
            newUserJson.put("userType", newUser.userType);
            newUserJson.put("familyMembers", new JSONArray(newUser.familyMembers));
            newUserJson.put("currency", newUser.currency);
            newUserJson.put("balance", newUser.balance);

            // 这里简单地将新用户信息添加到文件，实际应用可能需要更复杂的逻辑来存储用户数据
            Files.write(Paths.get(path), newUserJson.toString().getBytes());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 存款
    public void deposit(double amount, String type, String duration) {
        this.balance += amount;
        this.transactions.add(new Transaction("Deposit", amount, type, duration));
    }

    // 取款
    public void withdraw(double amount, String type) throws Exception {
        if (this.balance >= amount) {
            this.balance -= amount;
            this.transactions.add(new Transaction("Withdrawal", amount, type, null));
        } else {
            throw new Exception("Insufficient funds");
        }
    }

    // 获取余额
    public double getBalance() {
        return this.balance;
    }

    // 获取交易记录
    public List<Transaction> getTransactions() {
        return this.transactions;
    }
}

// Transaction class (already provided in the previous response)
