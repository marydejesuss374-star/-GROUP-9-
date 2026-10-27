import javax.swing.*;
import java.awt.*;

public class GUI_only {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Stack Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 300);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        JLabel title = new JLabel("STACK VISUALIZATION", JLabel.CENTER);

        JPanel inputPanel = new JPanel(new FlowLayout());
        JLabel inputLabel = new JLabel("Enter Value:");
        JTextField inputField = new JTextField(12);
        inputPanel.add(inputLabel);
        inputPanel.add(inputField);

        // GUI buttons only; Stack operations are not connected yet.
        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 8, 8));
        buttonPanel.add(new JButton("PUSH"));
        buttonPanel.add(new JButton("POP"));
        buttonPanel.add(new JButton("PEEK"));
        buttonPanel.add(new JButton("CLEAR"));
        buttonPanel.add(new JButton("CHECK STACK"));
        buttonPanel.add(new JButton("RANDOM"));

        JLabel statusLabel = new JLabel("Ready", JLabel.CENTER);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(title, BorderLayout.NORTH);
        topPanel.add(inputPanel, BorderLayout.CENTER);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(statusLabel, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.setVisible(true);
    }
}