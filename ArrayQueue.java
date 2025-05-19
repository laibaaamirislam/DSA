public class ArrayQueue {
    int[] array;
    int front;
    int rear;

    public ArrayQueue() {
        front = -1;
        rear = -1;
        array = new int[4];
    }

    public void enqueue(int num) {
        if (isFull()) {
            System.out.println("Queue overflow");
        } else {
            if (front == -1) {  // First insertion
                front = 0;
            }
            array[++rear] = num;
            System.out.println(num + " enqueued");
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue underflow");
            return -1;
        }
        int var = array[front];
        if (front == rear) {  // Queue becomes empty after this dequeue
            front = rear = -1;
        } else {
            front++;
        }
        System.out.println(var + " dequeued");
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
        return front == -1;
    }

    public boolean isFull() {
        return rear == array.length - 1;
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }
        return rear - front + 1;
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.print("Queue elements: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
    }


}
