import javax.swing.*;
import java.awt.*;

public class EmployeeFormDemo extends JFrame {

    public EmployeeFormDemo() {

        setTitle("Employee Entry Form");
        setSize(400, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Main panel with grid layout
        JPanel main = new JPanel(new GridLayout(8, 2, 5, 5));

        // Components
        JTextField id = new JTextField();
        JTextField name = new JTextField();
        JTextField dob = new JTextField();
        JTextField salary = new JTextField();

        // Gender panel
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        ButtonGroup bg = new ButtonGroup();
        bg.add(male); bg.add(female);
        genderPanel.add(male); genderPanel.add(female);

        // Country ComboBox
        String countries[] = {"Nepal", "India", "China", "USA"};
        JComboBox<String> country = new JComboBox<>(countries);

        // Remarks
        JTextArea remarks = new JTextArea(15, 25);
        JScrollPane scroll = new JScrollPane(remarks);

        // Add components to panel
        main.add(new JLabel("Employee ID:"));      main.add(id);
        main.add(new JLabel("Name:"));             main.add(name);
        main.add(new JLabel("DOB (YYYY-MM-DD):")); main.add(dob);
        main.add(new JLabel("Salary:"));           main.add(salary);
        main.add(new JLabel("Gender:"));           main.add(genderPanel);
        main.add(new JLabel("Country:"));          main.add(country);
        main.add(new JLabel("Remarks:"));          main.add(scroll);

        // Button panel
        JPanel btnPanel = new JPanel();
        JButton add = new JButton("Add");
        JButton cancel = new JButton("Cancel");
        btnPanel.add(add);
        btnPanel.add(cancel);

        // Add both panels to frame
        add(main, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);

        // Button functionality (basic)
        add.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Employee Added Successfully!");
        });

        cancel.addActionListener(e -> dispose());

        setVisible(true);
    }

    public static void main(String[] args) {
        new EmployeeFormDemo();
    }
}
