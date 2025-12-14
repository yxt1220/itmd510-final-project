package models;

public class Transaction {

    private int id;
    private double amount;
    private String type;

    public Transaction(int id, double amount, String type) {
        this.id = id;
        this.amount = amount;
        this.type = type;
    }

    public int getId() { return id; }
    public double getAmount() { return amount; }
    public String getType() { return type; }
}
