import java.sql.*;

public class InsertItems {
    public static void main(String[] args) {
        try {
            // Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database "Shop"
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Shop",
                    "root",
                    ""
            );

            String query = "INSERT INTO item (ItemID, Name, UnitPrice, Units, ExpiryDate) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            // Record 1
            ps.setInt(1, 1);
            ps.setString(2, "Soap");
            ps.setDouble(3, 45.50);
            ps.setInt(4, 20);
            ps.setString(5, "2026-01-01");
            ps.executeUpdate();

            // Record 2
            ps.setInt(1, 2);
            ps.setString(2, "Shampoo");
            ps.setDouble(3, 120.00);
            ps.setInt(4, 15);
            ps.setString(5, "2025-12-15");
            ps.executeUpdate();

            // Record 3
            ps.setInt(1, 3);
            ps.setString(2, "Toothpaste");
            ps.setDouble(3, 80.00);
            ps.setInt(4, 30);
            ps.setString(5, "2026-03-20");
            ps.executeUpdate();

            System.out.println("3 records inserted successfully!");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
