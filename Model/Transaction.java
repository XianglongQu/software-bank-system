package Model;

import java.time.LocalDateTime;

public class Transaction {
    private String type; // 交易类型（存款或取款）
    private double amount; // 交易金额
    private LocalDateTime timestamp; // 交易时间戳
    private String duration; // 对于定期存款的持续时间

    public Transaction(String type, double amount, String storageType, String duration) {
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now(); // 设置交易发生的当前时间
        this.duration = duration;
    }

    // 访问器方法
    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getDuration() {
        return duration;
    }
}
