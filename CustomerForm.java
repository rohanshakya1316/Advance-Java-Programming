import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class CustomerForm extends JFrame {

    JTextField cid = new JTextField(10);
    JTextField name = new JTextField(15);
    JTextField address = new JTextField(15);
    JTextField email = new JTextField(15);
    JTextField age = new JTextField(5);

    JButton insertBtn = new JButton("Insert");

    public CustomerForm() {
        super("Customer Entry Form");
        setLayout(new GridLayout(6, 2, 5, 5));

        add(new JLabel("CID:")); add(cid);
        add(new JLabel("Name:")); add(name);
        add(new JLabel("Address:")); add(address);
        add(new JLabel("Email:")); add(email);
        add(new JLabel("Age:")); add(age);
        add(new JLabel("")); add(insertBtn);

        insertBtn.addActionListener(e -> insertCustomer());

        setSize(300, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    void insertCustomer() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/shop",
                    "root",
                    ""
            );

            String sql = "INSERT INTO Customer VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(cid.getText()));
            ps.setString(2, name.getText());
            ps.setString(3, address.getText());
            ps.setString(4, email.getText());
            ps.setInt(5, Integer.parseInt(age.getText()));
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Inserted Successfully");
            con.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new CustomerForm();
    }
}
