import java.util.Scanner;

public class ArrayStack {

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

    private static void display(ArrayStack s) {
        System.out.println();
        if (s.isEmpty()) {
            System.out.println("   TOP -> (empty)");
        } else {
            int[] items = s.toArray();
            for (int i = items.length - 1; i >= 0; i--) {
                System.out.println((i == items.length - 1 ? "   TOP -> " : "          ")
                        + "[ " + items[i] + " ]");
            }
        }
        System.out.println("   (size " + s.size() + " of " + s.getCapacity() + ")");
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();
        Scanner in = new Scanner(System.in);
        java.util.Random random = new java.util.Random();
        boolean running = true;

        while (running) {
            System.out.println("===== ARRAY STACK (max " + stack.getCapacity() + ") =====");
            System.out.println("1. Push   2. Pop   3. Peek   4. Check stack (isEmpty/isFull)");
            System.out.println("5. Clear   6. Random   0. Exit");
            System.out.print("Choose: ");
            String choice = in.hasNextLine() ? in.nextLine().trim() : "0";

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Enter a whole number: ");
                        int value = Integer.parseInt(in.nextLine().trim());
                        stack.push(value);
                        System.out.println("PUSH " + value + " done.");
                        break;
                    case "2":
                        System.out.println("POP: " + stack.pop() + " removed.");
                        break;
                    case "3":
                        System.out.println("PEEK: top is " + stack.peek() + " (not removed).");
                        break;
                    case "4":
                        System.out.println(stack.isEmpty() ? "Stack is EMPTY."
                                : stack.isFull() ? "Stack is NOT empty - it is FULL."
                                : "Stack is NOT empty.");
                        break;
                    case "5":
                        stack.clear();
                        int count = random.nextInt(stack.getCapacity()) + 1;
                        for (int i = 0; i < count; i++) {
                            stack.push(random.nextInt(100) + 1);
                        }
                        System.out.println("RANDOM: " + count + " element(s) pushed.");
                        break;                    case "6":
                        stack.clear();
                        System.out.println("CLEAR: stack is now empty.");
                        break;                 
                    case "0":
                        running = false;
                        System.out.println("Goodbye.");
                        continue;
                    default:
                        System.out.println("INVALID CHOICE: enter 0 to 6");
                        continue;
                }
            } catch (NumberFormatException ex) {
                System.out.println("INVALID INPUT: Please enter a whole number.");
            } catch (IllegalStateException ex) {
                System.out.println(ex.getMessage());
            }
            display(stack);
        }
        in.close();
    }
}