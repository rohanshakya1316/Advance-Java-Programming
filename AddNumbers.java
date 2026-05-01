import javax.swing.*;
import java.awt.*;

public class AddNumbers extends JFrame {

    public AddNumbers() {

        setLayout(new GridLayout(4, 2, 5, 5));

        JTextField n1 = new JTextField();
        JTextField n2 = new JTextField();
        JTextField sum = new JTextField();

        add(new JLabel("First Number:"));
        add(n1);

        add(new JLabel("Second Number:"));
        add(n2);

        add(new JLabel("Sum:"));
        add(sum);

        JButton addBtn = new JButton("Add");
        add(addBtn);

        addBtn.addActionListener(e -> {
            try {
                int a = Integer.parseInt(n1.getText());
                int b = Integer.parseInt(n2.getText());
                sum.setText(String.valueOf(a + b));
            } catch (Exception ex) {
                sum.setText("Invalid Input");
            }
        });

        setSize(250, 180);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new AddNumbers();
    }
}
