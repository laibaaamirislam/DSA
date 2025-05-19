import java.lang.reflect.Array;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        ArrayQueue  queue = new ArrayQueue();
//        queue.enqueue(5);
//        queue.enqueue(5);
//        queue.enqueue(5);
//
//        queue.displayQueue();
//        queue.dequeue();
//        queue.enqueue(5);
//        queue.enqueue(5);
//        queue.dequeue();
//        queue.dequeue();
//        queue.dequeue();
//        queue.dequeue();
//        CircularQueue cq = new CircularQueue();
//        cq.enqueue(5);
//        cq.enqueue(6); cq.enqueue(8); cq.enqueue(9);
//
//        cq.displayQueue();
//        System.out.println("\n");
//
//        cq.dequeue();
//        cq.enqueue(7);
//        cq.displayQueue();


//        cq.dequeue();cq.dequeue();
//        cq.enqueue(5);
//        cq.enqueue(5); cq.enqueue(5); cq.enqueue(5);cq.enqueue(5);
//        cq.enqueue(5); cq.enqueue(5); cq.enqueue(5);

//        PriorityQueue pq = new PriorityQueue();
//        pq.enqueue(5);
//        pq.enqueue(5);
//        pq.enqueue(5);
//        pq.enqueue(5);
////        pq.displayQueue();
//
//        pq.dequeue();
//        pq.dequeue();
//        pq.dequeue();
//        pq.dequeue();
//
//        pq.displayQueue();


//        LinkedList linkedList=new LinkedList();
//        linkedList.insertStart(5);
//        linkedList.insertEnd(8);
//        linkedList.insertMiddle(6,2);
////        linkedList.deleteEnd();
////        linkedList.deleteStart();
//        linkedList.deleteLocation(2);
//
//
//       Node n=linkedList.search(8);
//        System.out.println(n);


//        PriorityQueueWithArrayList priorityQueue = new PriorityQueueWithArrayList();
//
//        // Creating some nodes with value and priority
//        PriorityQueueWithArrayList.Node node1 = priorityQueue.new Node(10, 3);
//        PriorityQueueWithArrayList.Node node2 = priorityQueue.new Node(20, 2);
//        PriorityQueueWithArrayList.Node node3 = priorityQueue.new Node(30, 5);
//        PriorityQueueWithArrayList.Node node4 = priorityQueue.new Node(40, 1);
//
//        // Enqueue nodes
//        priorityQueue.enqueue(node1);
//        priorityQueue.enqueue(node2);
//        priorityQueue.enqueue(node3);
//        priorityQueue.enqueue(node4);
//
//        // Display the priority queue
//        System.out.println("Priority Queue after enqueuing:");
//        priorityQueue.display();
//
//        // Dequeue elements
//        System.out.println("\nDequeuing elements:");
//        System.out.println("Dequeued: value = " + priorityQueue.dequeue().value);
//        System.out.println("Dequeued: value = " + priorityQueue.dequeue().value);
//
//        // Display the priority queue again
//        System.out.println("\nPriority Queue after dequeuing:");
//        priorityQueue.display();

        CircularQueueUsingLL queue = new CircularQueueUsingLL(3);  // Queue with capacity 3

        // Create some nodes with data
        CircularQueueUsingLL.Node node1 = queue.new Node(10);
        CircularQueueUsingLL.Node node2 = queue.new Node(20);
        CircularQueueUsingLL.Node node3 = queue.new Node(30);
        CircularQueueUsingLL.Node node4 = queue.new Node(40);  // This will test if the queue is full

        // Enqueue nodes
        queue.enq(node1);
        queue.enq(node2);
        queue.enq(node3);

        // Try to enqueue when the queue is full
        queue.enq(node4);  // Should print "full"

        // Display the queue
        System.out.println("Queue after enqueuing:");
        queue.diaplay();

        // Dequeue elements
        System.out.println("\nDequeuing elements:");
        System.out.println("Dequeued: " + queue.dequeue().data);
        System.out.println("Dequeued: " + queue.dequeue().data);

        // Display the queue again
        System.out.println("\nQueue after dequeuing:");
        queue.diaplay();

        // Enqueue a new node to test circular behavior
        queue.enq(node4);
        System.out.println("\nQueue after enqueuing again:");
        queue.diaplay();

    }
}