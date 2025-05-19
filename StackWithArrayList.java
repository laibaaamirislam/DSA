import java.util.ArrayList;

public class StackWithArrayList {

    // Create an ArrayList to store the stack elements
    private ArrayList<Integer> stack;

    // Constructor to initialize the stack
    public StackWithArrayList() {
        stack = new ArrayList<>();
    }

    // Method to add an element to the top of the stack (push operation)
    public void push(int data) {
        stack.add(data);  // Add element at the end of the ArrayList
    }

    // Method to remove and return the top element of the stack (pop operation)
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;  // Return -1 to indicate the stack is empty
        }
        return stack.remove(stack.size() - 1);  // Remove and return the last element
    }

    // Method to return the top element of the stack without removing it (peek operation)
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;  // Return -1 to indicate the stack is empty
        }
        return stack.get(stack.size() - 1);  // Return the last element
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return stack.isEmpty();  // Check if the ArrayList is empty
    }

    // Method to display the stack elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Stack elements: " + stack);
        }
    }

    public static void main(String[] args) {
        StackWithArrayList stack = new StackWithArrayList();

        // Push elements to the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Display the stack
        System.out.print("Stack after pushes: ");
        stack.display();  // Expected output: Stack elements: [10, 20, 30]

        // Peek the top element
        System.out.println("Top element is: " + stack.peek());  // Expected output: Top element is: 30

        // Pop an element from the stack
        System.out.println("Popped element: " + stack.pop());  // Expected output: Popped element: 30

        // Display the stack again
        System.out.print("Stack after pop: ");
        stack.display();  // Expected output: Stack elements: [10, 20]

        // Pop all elements
        stack.pop();
        stack.pop();

        // Check if the stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty());  // Expected output: Is stack empty? true
    }
}

