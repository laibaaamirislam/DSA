public class PriorityQueueWithArrayList {

    class Node{
        int value;
        int priority;
        Node next;

        public Node(int value, int priority) {
            this.value = value;
            this.priority = priority;
            this.next=null;
        }
    }

    Node head;
    int size=0;

    public PriorityQueueWithArrayList() {
        head = null;
    }

    public void enqueue(Node node){
        if(head==null || head.priority<node.priority){
            node.next=head;
            head=node;
        }else{
            Node temp=head;
            while(temp.next!=null && temp.next.priority>=node.priority){
                temp=temp.next;;
            }
            node.next=temp.next;
            temp.next=node;
        }
        size++;
        System.out.println("enqueued");
    }

    public Node dequeue(){
        if(isEmpty()){
            System.out.println("queue is empty");
            return null;
        }
        Node node=head;
        head=head.next;
        size--;
        System.out.println("dequeued");
        return node;

    }

    public void display(){
        if(isEmpty()){
            System.out.println("empty");
        }else{
            Node temp=head;
            System.out.println("size: "+size);
            while(temp!=null){

                System.out.println("value: "+temp.value + "\t" + "priority: "+temp.priority);
                temp=temp.next;
            }
        }
    }

    public boolean isEmpty(){
        if(head==null){
            return true;
        }
        return false;
    }


}
