import javax.swing.*;
import java.awt.*;

public class GUI {
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

        // ===================== ADDED: stack + horizontal output =====================
        ArrayStack stack = new ArrayStack();
        java.util.Random random = new java.util.Random();

        JPanel displayPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 1, 5));
        displayPanel.setPreferredSize(new Dimension(430, 70));
        topPanel.add(displayPanel, BorderLayout.SOUTH);

        // Redraws the stack as a row of boxes: bottom on the left, TOP on the right
        Runnable refresh = () -> {
            displayPanel.removeAll();
            int[] items = stack.toArray();
            for (int i = 0; i < items.length; i++) {
                boolean isTop = (i == items.length - 1);

                JLabel box = new JLabel(String.valueOf(items[i]), SwingConstants.CENTER);
                box.setPreferredSize(new Dimension(40, 36));
                box.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
                box.setOpaque(true);
                box.setBackground(isTop ? new Color(180, 220, 255) : Color.WHITE);

                JLabel tag = new JLabel(isTop ? "TOP" : " ", SwingConstants.CENTER);

                JPanel cell = new JPanel(new BorderLayout());
                cell.add(box, BorderLayout.CENTER);
                cell.add(tag, BorderLayout.SOUTH);
                displayPanel.add(cell);
            }
            displayPanel.revalidate();
            displayPanel.repaint();
        };

        // Connects the existing buttons to the stack
        for (Component c : buttonPanel.getComponents()) {
            JButton b = (JButton) c;
            b.addActionListener(e -> {
                try {
                    switch (b.getText()) {
                        case "PUSH":
                            int value = Integer.parseInt(inputField.getText().trim());
                            stack.push(value);
                            inputField.setText("");
                            statusLabel.setText("PUSH " + value + " done | Size: " + stack.size() + "/" + stack.getCapacity());
                            break;
                        case "POP":
                            statusLabel.setText("POP: " + stack.pop() + " removed | Size: " + stack.size() + "/" + stack.getCapacity());
                            break;
                        case "PEEK":
                            statusLabel.setText("PEEK: top is " + stack.peek() + " (not removed)");
                            break;
                        case "CLEAR":
                            stack.clear();
                            statusLabel.setText("CLEAR: stack is now empty");
                            break;
                        case "CHECK STACK":
                            statusLabel.setText(stack.isEmpty() ? "Stack is EMPTY."
                                    : stack.isFull() ? "Stack is NOT empty - it is FULL."
                                    : "Stack is NOT empty.");
                            break;
                        case "RANDOM":
                            stack.clear();
                            int count = random.nextInt(stack.getCapacity()) + 1;
                            for (int i = 0; i < count; i++) {
                                stack.push(random.nextInt(100) + 1);
                            }
                            statusLabel.setText("RANDOM: " + count + " element(s) pushed");
                            break;
                    }
                } catch (NumberFormatException ex) {
                    statusLabel.setText("Enter a whole number");
                } catch (IllegalStateException ex) {
                    statusLabel.setText(ex.getMessage());
                }
                refresh.run();
            });
        }
        // ============================================================================

        frame.add(mainPanel);
        frame.setVisible(true);
    }
}

// ===================== STACK =====================
class ArrayStack {

    public static final int MAX_CAPACITY = 10;

    private int[] data;
    private int top;
    private int capacity;

    public ArrayStack(int capacity) {
        checkCapacity(capacity);
        this.capacity = capacity;
        this.data = new int[capacity];
        this.top = -1;
    }

    public ArrayStack() {
        this(MAX_CAPACITY);
    }

    private static void checkCapacity(int capacity) {
        if (capacity < 1 || capacity > MAX_CAPACITY) {
            throw new IllegalArgumentException(
                    "Capacity must be between 1 and " + MAX_CAPACITY);
        }
    }

    public void push(int value) {
        if (isFull()) {
            throw new IllegalStateException("STACK OVERFLOW: Cannot push, stack is full");
        }
        data[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("STACK UNDERFLOW: Cannot pop, stack is empty");
        }
        return data[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("STACK EMPTY: Cannot peek, stack is empty");
        }
        return data[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public int size() {
        return top + 1;
    }

    public void clear() {
        top = -1;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean setCapacity(int newCapacity) {
        checkCapacity(newCapacity);
        if (size() > newCapacity) {
            return false;
        }
        int[] newData = new int[newCapacity];
        for (int i = 0; i <= top; i++) {
            newData[i] = data[i];
        }
        data = newData;
        capacity = newCapacity;
        return true;
    }

    public int[] toArray() {
        int[] copy = new int[size()];
        for (int i = 0; i < copy.length; i++) {
            copy[i] = data[i];
        }
        return copy;
    }
}