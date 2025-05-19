public class CircularQueueUsingLL {
    class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    Node front,rear;
    int capacity,size;

    public CircularQueueUsingLL(int capacity) {

        front=null;
        rear=null;
        this.capacity=capacity;
        size=0;


    }

    public boolean enq(Node node){
        if(isFull()){
            System.out.println("full");
            return false;
        }
        if(isEmpty()){
            front=node;
        }else{
            rear.next=node;
        }
        rear=node;
        rear.next=front;
        size++;
        System.out.println("enqueued");

        return true;
    }

    public Node dequeue(){
        if(isEmpty()){
            System.out.println("empty");
            return null;
        }
        Node node=front;
        if(front==rear){
            front=null;
            rear=null;
            size=0;
        }
        front=front.next;
        rear.next=front;
        size--;
        System.out.println("dequeued");
        return node;
    }

    public boolean diaplay(){
        if(isEmpty()){
            System.out.println("empty");
            return false;
        }
        Node temp=front;
        while(temp!=rear){
            System.out.println("value: "+temp.data);
            temp=temp.next;
        }
        System.out.println("value: "+temp.data);
        System.out.println("size: "+size);
        return true;
    }

    public boolean isFull(){
        return size==capacity;
    }
    public boolean isEmpty(){
        return front==null;
    }
}
