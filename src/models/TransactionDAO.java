package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {

    public static void addTransaction(int userId, double amount, String type) {

        String sql =
            "INSERT INTO xyu67_transactions (user_id, amount, type) VALUES (?,?,?)";

        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, userId);
            ps.setDouble(2, amount);
            ps.setString(3, type);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Transaction> getAll() {

        List<Transaction> list = new ArrayList<>();

        try {
            Connection conn = DBConnect.getConnection();
            ResultSet rs =
                conn.createStatement()
                    .executeQuery("SELECT * FROM xyu67_transactions");

            while (rs.next()) {
                list.add(new Transaction(
                    rs.getInt("id"),
                    rs.getDouble("amount"),
                    rs.getString("type")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public static void updateFirst() {
        try {
            Connection conn = DBConnect.getConnection();
            conn.createStatement().executeUpdate(
                "UPDATE xyu67_transactions " +
                "SET amount = 999 " +
                "ORDER BY id ASC " +
                "LIMIT 1"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void deleteLast() {

        try {
            Connection conn = DBConnect.getConnection();
            conn.createStatement()
                .executeUpdate(
                    "DELETE FROM xyu67_transactions ORDER BY id DESC LIMIT 1"
                );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
