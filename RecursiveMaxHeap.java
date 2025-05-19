import java.util.ArrayList;

public class RecursiveMaxHeap {
    private ArrayList<Integer> recursiveMaxHeap;

    public RecursiveMaxHeap() {
        recursiveMaxHeap=new ArrayList<>();
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
        int temp=recursiveMaxHeap.get(i);
        recursiveMaxHeap.set(i,recursiveMaxHeap.get(j));
        recursiveMaxHeap.set(j,temp);
    }

    public void insert(int value){
        recursiveMaxHeap.add(value);
        int currIndex=recursiveMaxHeap.size()-1;
        recursiveHeapifyUp(currIndex);
    }

    public void recursiveHeapifyUp(int currIndex){
        if(recursiveMaxHeap.get(currIndex) < recursiveMaxHeap.get(parent(currIndex))){
            return;
        }
        if(currIndex>0 && recursiveMaxHeap.get(currIndex) > recursiveMaxHeap.get(parent(currIndex))){
            swap(currIndex,parent(currIndex));
            recursiveHeapifyUp(parent(currIndex));
        }
    }

    public int deleteRoot(){
        if(recursiveMaxHeap.isEmpty()){
            throw new RuntimeException("Heap is empty");
        }
        int root=recursiveMaxHeap.get(0);
        int Last=recursiveMaxHeap.remove(recursiveMaxHeap.size()-1);

        if(!recursiveMaxHeap.isEmpty()){
            recursiveMaxHeap.set(0,Last);
            int currIndex=0;
            recursiveHeapifyDown(currIndex);
        }
        return root;
    }
    public void recursiveHeapifyDown(int currIndex){
        int left = left(currIndex);
        int right = right(currIndex);

        int smallest=currIndex;

        if (left < recursiveMaxHeap.size() && recursiveMaxHeap.get(left) > recursiveMaxHeap.get(smallest)) {
            smallest=left(currIndex);
        }

        if(right < recursiveMaxHeap.size() && recursiveMaxHeap.get(right) > recursiveMaxHeap.get(smallest)){
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
        for(int i:recursiveMaxHeap){
            System.out.println(i);
        }
    }

}
