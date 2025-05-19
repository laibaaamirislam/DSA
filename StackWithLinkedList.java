public class StackWithLinkedList {

    // Node class representing each element in the linked list
    class Node {
        int data;   // Data of the node
        Node next;  // Reference to the next node

        // Constructor to create a new node
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;  // Top of the stack

    // Constructor to initialize an empty stack
    public StackWithLinkedList() {
        this.top = null;
    }

    // Method to add an element to the top of the stack (push operation)
    public void push(int data) {
        Node newNode = new Node(data); // Create a new node
        newNode.next = top;            // Link the new node to the previous top
        top = newNode;                 // Update top to the new node
    }

    // Method to remove and return the top element of the stack (pop operation)
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;  // Return -1 to indicate the stack is empty
        }
        int poppedValue = top.data;  // Get the data of the top node
        top = top.next;               // Move top to the next node
        return poppedValue;           // Return the popped value
    }

    // Method to return the top element of the stack without removing it (peek operation)
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;  // Return -1 to indicate the stack is empty
        }
        return top.data;  // Return the data of the top node
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == null;  // Stack is empty if top is null
    }

    // Method to display the stack elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            Node current = top;
            System.out.print("Stack elements: ");
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;  // Move to the next node
            }
            System.out.println("null");
        }
    }
}