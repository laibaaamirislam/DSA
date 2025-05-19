import java.util.ArrayList;

public class Heap {

    private ArrayList<Integer> minHeap;

    public Heap() {
       minHeap=new ArrayList<>();
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
        int temp=minHeap.get(i);
        minHeap.set(i,minHeap.get(j));
        minHeap.set(j,temp);
    }

    public void insert(int value){
        minHeap.add(value);
        int currIndex=minHeap.size()-1;
        while(currIndex>0 && minHeap.get(currIndex) < minHeap.get(parent(currIndex))){
            swap(currIndex,parent(currIndex));
            currIndex=parent(currIndex);
        }
    }

    public int deleteRoot(){
        if(minHeap.isEmpty()){
            throw new RuntimeException("Heap is empty");
        }
        int root=minHeap.get(0);
        int Last=minHeap.remove(minHeap.size()-1);

        if(!minHeap.isEmpty()){


            minHeap.set(0,Last);
            int currIndex=0;

            while(true) {


                int left = left(currIndex);
                int right = right(currIndex);

                int smallest=currIndex;

                if (left < minHeap.size() && minHeap.get(left) < minHeap.get(smallest)) {
                    smallest=left(currIndex);
                }

                if(right < minHeap.size() && minHeap.get(right) <minHeap.get(smallest)){
                    smallest=right(currIndex);
                }

                if(smallest==currIndex){
                    break;
                }

                swap(currIndex,smallest);
                currIndex=smallest;
            }
        }
        return root;
    }

    public void print(){
        for (int i:minHeap){
            System.out.println(i);
        }
    }
}
