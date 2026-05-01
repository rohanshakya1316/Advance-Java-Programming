import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DistinctionStudents {

    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 1. Load JDBC driver (optional for newer versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Connect to the database "College"
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Shop",
                    "root",
                    ""
            );

            // 3. Create SQL query
            String query = "SELECT Rollno, Name, Level, Division, Major " +
                    "FROM Student " +
                    "WHERE Division = 'Distinction' " +
                    "AND Major = 'Data Science'";

            // 4. Execute query
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            // 5. Display result
            System.out.println("Students with Distinction in Data Science:\n");

            while (rs.next()) {
                System.out.println("Roll No : " + rs.getInt("Rollno"));
                System.out.println("Name    : " + rs.getString("Name"));
                System.out.println("Level   : " + rs.getString("Level"));
                System.out.println("Division: " + rs.getString("Division"));
                System.out.println("Major   : " + rs.getString("Major"));
                System.out.println("--------------------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception ex) {}
            try { if (stmt != null) stmt.close(); } catch (Exception ex) {}
            try { if (con != null) con.close(); } catch (Exception ex) {}
        }
    }
}
