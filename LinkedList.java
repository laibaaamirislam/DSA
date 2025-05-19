public class LinkedList {
    Node head = null;
    Node curr=null;
    Node prev=null;
    int nodeCount=-1;

    public LinkedList() {
    }

    public Node search(int value){
        Node ptr=head;
        while(ptr!= null){
            if(ptr.data==value) {
                return ptr;
            }
            ptr=ptr.next;
        }
        return null;
    }

    public void print(){
        Node ptr=head;
        while(ptr!=null){
            System.out.println(ptr.data);
            ptr=ptr.next;
        }
    }

    public void insertStart(int value){
        Node newestNode = new Node(value);
        if(head==null){
            head=newestNode;
        }else{
            newestNode.next=head;
            head=newestNode;
        }
    }

    public void insertEnd(int value){
        Node newestNode = new Node(value);
        if(head==null){
            head=newestNode;
        }
        else{
            Node ptr = head;
            while(ptr.next!=null){
                ptr=ptr.next;
            }
            ptr.next=newestNode;
        }
    }

    public void insertMiddle(int value, int loc){
        Node newestNode = new Node(value);
        if(head==null){
            head=newestNode;
        }
        else{
            curr=head;
            prev=null;
            nodeCount=0;

            while(curr!=null){
                nodeCount++;
                    if(nodeCount==loc){
                        newestNode.next = curr;

                        if(prev!=null){
                            prev.next=newestNode;
                        }else{
                            newestNode.next=head;
                            head=newestNode;
                        }
                        break;
                    }
                    prev=curr;
                    curr=curr.next;
            }
        }
    }

    public void deleteStart(){
        if(head != null){
            head=head.next;
        }
    }

    public void deleteEnd(){
        if(head!=null){
            if(head.next==null){
                head=null;
            }else{
                curr=head;
                prev=null;

                while(curr.next!=null){
                    prev=curr;
                    curr=curr.next;
                }
                prev.next=null;
            }
        }
    }

    public void deleteLocation(int loc){
        nodeCount=0;
        if(head!=null){
            if(loc==1){
                Node temp=head;
                head=head.next;
                temp=null;
            }else{
                curr=head;
                prev=null;

                while(curr!=null){
                    nodeCount++;

                    if(nodeCount==loc){
                        prev.next=curr.next;
                        break;
                    }

                    prev=curr;
                    curr=curr.next;
                }
            }
        }
    }

}
