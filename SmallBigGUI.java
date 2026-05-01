import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SmallBigGUI extends JFrame implements MouseListener {

    JTextField t1 = new JTextField(10);
    JTextField t2 = new JTextField(10);
    JLabel result = new JLabel("Result will appear here");

    public SmallBigGUI() {
        setLayout(new GridLayout(3, 2, 10, 10));

        add(new JLabel("Number 1:"));
        add(t1);

        add(new JLabel("Number 2:"));
        add(t2);

        add(result);

        addMouseListener(this);

        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void mousePressed(MouseEvent e) {
        int a = Integer.parseInt(t1.getText());
        int b = Integer.parseInt(t2.getText());
        result.setText("Smaller: " + Math.min(a, b));
    }

    public void mouseReleased(MouseEvent e) {
        int a = Integer.parseInt(t1.getText());
        int b = Integer.parseInt(t2.getText());
        result.setText("Greater: " + Math.max(a, b));
    }

    // Unused methods
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        new SmallBigGUI();
    }
}
