public class PriorityQueue {
    int[] array;
    int front;
    int rear;

    public PriorityQueue() {
        front = -1;
        rear = -1;
        array = new int[4];
    }

    public void enqueue(int num) {
        if (isFull()) {
            System.out.println("Queue overflow");
        } else {
            if (front == -1) {  // If this is the first element
                front = 0;
            }
            array[++rear] = num;
        }
    }

    public int dequeue() {
        int var = -1;
        if (isEmpty()) {
            System.out.println("Queue underflow");
        } else {
            int index = find_index_of_min();
            var = array[index];  // Return the actual value at index
            for (int i = index; i < rear; i++) {  // Shift elements left
                array[i] = array[i + 1];
            }
            rear--;
            if (rear == -1) {  // If the queue becomes empty, reset front
                front = -1;
            }
        }
        return var;
    }

    public int front() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return array[front];
    }

    public boolean isEmpty() {
        return rear == -1;
    }

    public boolean isFull() {
        return rear == array.length - 1;
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }
        return rear + 1;
    }

    // Helper method to find the index of the minimum element
    public int find_index_of_min() {
        int m = 0;
        for (int i = 1; i <= rear; i++) {
            if (array[i] < array[m]) {
                m = i;
            }
        }
        return m;
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.print("Queue elements: ");
            for (int i = 0; i <= rear; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
    }

   
}
