public class LinkedListCircularQueue {
        LinkedList queue;
        Node front;
        Node rear;

        public LinkedListCircularQueue() {
            front = null;
            rear=null;
            queue=new LinkedList();
        }

        public void enqueue(int value){
            Node newNode = new Node(value);
            if(front==null){
                front=newNode;
                front.next=front;
            }else{
                Node ptr=front;
                while(ptr.next!=null){
                    ptr=ptr.next;
                }
                ptr.next=newNode;
                newNode.next=front;
            }
        }

//        public Node dequeue(){
//
//        }

}
