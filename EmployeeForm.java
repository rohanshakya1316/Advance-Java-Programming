import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class EmployeeForm extends JFrame implements ActionListener {

    JTextField idField, nameField, salaryField;
    JButton insertBtn, viewBtn, deleteBtn;

    // Simple in-memory database
    HashMap<String, String[]> database = new HashMap<>();

    public EmployeeForm() {

        setTitle("Employee Form");
        setLayout(new GridLayout(5, 2, 10, 10));

        // Labels & Fields
        add(new JLabel("Employee ID:"));
        idField = new JTextField();
        add(idField);

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Salary:"));
        salaryField = new JTextField();
        add(salaryField);

        // Buttons
        insertBtn = new JButton("Insert");
        viewBtn = new JButton("View");
        deleteBtn = new JButton("Delete");

        add(insertBtn);
        add(viewBtn);
        add(deleteBtn);

        // Action Listeners
        insertBtn.addActionListener(this);
        viewBtn.addActionListener(this);
        deleteBtn.addActionListener(this);

        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String id = idField.getText();
        String name = nameField.getText();
        String salary = salaryField.getText();

        if (e.getSource() == insertBtn) {

            database.put(id, new String[]{name, salary});
            JOptionPane.showMessageDialog(this, "Employee Inserted");

        } else if (e.getSource() == viewBtn) {

            if (database.containsKey(id)) {
                String[] emp = database.get(id);
                nameField.setText(emp[0]);
                salaryField.setText(emp[1]);
            } else {
                JOptionPane.showMessageDialog(this, "Employee Not Found");
            }

        } else if (e.getSource() == deleteBtn) {

            if (database.containsKey(id)) {
                database.remove(id);
                nameField.setText("");
                salaryField.setText("");
                JOptionPane.showMessageDialog(this, "Employee Deleted");
            } else {
                JOptionPane.showMessageDialog(this, "Employee Not Found");
            }
        }
    }

    public static void main(String[] args) {
        new EmployeeForm();
    }
}