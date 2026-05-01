import javax.swing.*;
import java.awt.*;

public class CalculatorForm extends JFrame {

    JTextField n1, n2, result;

    public CalculatorForm() {

        setLayout(new GridLayout(5, 2, 5, 5));

        add(new JLabel("First Number:"));
        n1 = new JTextField(); add(n1);

        add(new JLabel("Second Number:"));
        n2 = new JTextField(); add(n2);

        add(new JLabel("Result:"));
        result = new JTextField(); add(result);

        JButton addBtn = new JButton("Add");
        JButton subBtn = new JButton("Subtract");
        JButton mulBtn = new JButton("Multiply");
        JButton divBtn = new JButton("Divide");

        add(addBtn); add(subBtn);
        add(mulBtn); add(divBtn);

        addBtn.addActionListener(e -> compute("+"));
        subBtn.addActionListener(e -> compute("-"));
        mulBtn.addActionListener(e -> compute("*"));
        divBtn.addActionListener(e -> compute("/"));

        setSize(300, 200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    void compute(String op) {
        try {
            double a = Double.parseDouble(n1.getText());
            double b = Double.parseDouble(n2.getText());
            double ans = 0;

            switch (op) {
                case "+": ans = a + b; break;
                case "-": ans = a - b; break;
                case "*": ans = a * b; break;
                case "/": ans = b != 0 ? a / b : 0; break;
            }
            result.setText(String.valueOf(ans));

        } catch (Exception ex) {
            result.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        new CalculatorForm();
    }
}
