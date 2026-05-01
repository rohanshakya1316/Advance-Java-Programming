import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SumDiffGUI extends JFrame implements MouseListener {

    JTextField t1 = new JTextField(10);
    JTextField t2 = new JTextField(10);
    JTextField t3 = new JTextField(10);

    public SumDiffGUI() {
        setLayout(new GridLayout(3, 2, 10, 10));

        add(new JLabel("Number 1:"));
        add(t1);

        add(new JLabel("Number 2:"));
        add(t2);

        add(new JLabel("Result:"));
        add(t3);

        // Add mouse listener to the whole frame
        addMouseListener(this);

        setSize(250, 180);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void mousePressed(MouseEvent e) {
        int a = Integer.parseInt(t1.getText());
        int b = Integer.parseInt(t2.getText());
        t3.setText("Sum: " + (a + b));
    }

    public void mouseReleased(MouseEvent e) {
        int a = Integer.parseInt(t1.getText());
        int b = Integer.parseInt(t2.getText());
        t3.setText("Diff: " + (a - b));
    }

    // Unused methods
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        new SumDiffGUI();
    }
}
