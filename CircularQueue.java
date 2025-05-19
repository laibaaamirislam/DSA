public class CircularQueue {
    int[] array;
    int front;
    int rear;

    public CircularQueue() {
        front = -1;
        rear = -1;
        array = new int[4];
    }

    // Enqueue operation
    public void enqueue(int num) {
        if (isFull()) {
            System.out.println("Queue overflow");
        } else {
            rear = (rear + 1) % array.length;
            array[rear] = num;
            if (front == -1) {
                front = 0;  // Set front to 0 after the first insertion
            }
            System.out.println(num + " enqueued");
        }
    }

    // Dequeue operation
    public int dequeue() {
        int var = -1;
        if (isEmpty()) {
            System.out.println("Queue underflow");
        } else {
            var = array[front];
            if (front == rear) {  // Only one element was in the queue
                front = rear = -1;  // Reset the queue
            } else {
                front = (front + 1) % array.length;
            }
            System.out.println(var + " dequeued");
        }
        return var;
    }

    // Peek at the front element
    public int front() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return array[front];
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return front == -1;
    }

    // Check if queue is full
    public boolean isFull() {
        return (rear + 1) % array.length == front;
    }

    // Get the current size of the queue
    public int size() {
        if (isEmpty()) {
            return 0;
        }
        if (rear >= front) {
            return rear - front + 1;
        } else {
            return (array.length - front + rear + 1);
        }
    }

    // Display the queue elements
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue elements: ");
        if (front <= rear) {  // Normal case (no wrapping around)
            for (int i = front; i <= rear; i++) {
                System.out.print(array[i] + " ");
            }
        } else {  // Circular case (wrapping around)
            for (int i = front; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
            for (int i = 0; i <= rear; i++) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
    }

}
