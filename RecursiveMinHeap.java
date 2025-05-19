import java.util.ArrayList;

public class RecursiveMinHeap {
    private ArrayList<Integer> recursiveMinHeap;

    public RecursiveMinHeap() {
        recursiveMinHeap=new ArrayList<>();
    }
    public int parent(int k){
        return (k-1)/2;
    }
    public int left(int k){
        return (2*k)+1;
    }
    public int right(int k){
        return (2*k)+2;
    }

    public void swap(int i,int j){
        int temp=recursiveMinHeap.get(i);
        recursiveMinHeap.set(i,recursiveMinHeap.get(j));
        recursiveMinHeap.set(j,temp);
    }

    public void insert(int value){
        recursiveMinHeap.add(value);
        int currIndex=recursiveMinHeap.size()-1;
        recursiveHeapifyUp(currIndex);
    }

    public void recursiveHeapifyUp(int currIndex){
        if(recursiveMinHeap.get(currIndex) > recursiveMinHeap.get(parent(currIndex))){
            return;
        }
        if(currIndex>0 && recursiveMinHeap.get(currIndex) < recursiveMinHeap.get(parent(currIndex))){
            swap(currIndex,parent(currIndex));
            recursiveHeapifyUp(parent(currIndex));
        }
    }

    public int deleteRoot(){
        if(recursiveMinHeap.isEmpty()){
            throw new RuntimeException("Heap is empty");
        }
        int root=recursiveMinHeap.get(0);
        int Last=recursiveMinHeap.remove(recursiveMinHeap.size()-1);

        if(!recursiveMinHeap.isEmpty()){


            recursiveMinHeap.set(0,Last);
            int currIndex=0;
            recursiveHeapifyDown(currIndex);
        }
        return root;
    }
    public void recursiveHeapifyDown(int currIndex){
        int left = left(currIndex);
        int right = right(currIndex);

        int smallest=currIndex;

        if (left < recursiveMinHeap.size() && recursiveMinHeap.get(left) < recursiveMinHeap.get(smallest)) {
            smallest=left(currIndex);
        }

        if(right < recursiveMinHeap.size() && recursiveMinHeap.get(right) < recursiveMinHeap.get(smallest)){
            smallest=right(currIndex);
        }

        if(smallest==currIndex){
            return;
        }

        swap(currIndex,smallest);
        currIndex=smallest;
        recursiveHeapifyDown(currIndex);

    }

    public void print(){
        for(int i:recursiveMinHeap){
            System.out.println(i);
        }
    }

}
