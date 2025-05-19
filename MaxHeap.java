import java.util.ArrayList;

public class MaxHeap {

    private ArrayList<Integer> maxHeap;

    public MaxHeap() {
        maxHeap= new ArrayList<>();
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
        int temp=maxHeap.get(i);
        maxHeap.set(i,maxHeap.get(j));
        maxHeap.set(j,temp);
    }


    public void insert(int value){
        maxHeap.add(value);
        int currIndex=maxHeap.size()-1;

        while(currIndex>0 && maxHeap.get(currIndex) > maxHeap.get(parent(currIndex)) ){
            swap(currIndex, parent(currIndex));
            currIndex=parent(currIndex);
        }

    }

    public int deleteRoot(){
        if(maxHeap.isEmpty()){
            throw new RuntimeException("Heap is empty");
        }
        int root=maxHeap.get(0);
        int Last=maxHeap.remove(maxHeap.size()-1);

        if(!maxHeap.isEmpty()){


            maxHeap.set(0,Last);
            int currIndex=0;

            while(true) {


                int left = left(currIndex);
                int right = right(currIndex);

                int largest=currIndex;

                if (left < maxHeap.size() && maxHeap.get(left) > maxHeap.get(largest)) {
                    largest=left(currIndex);
                }

                if(right < maxHeap.size() && maxHeap.get(right) > maxHeap.get(largest)){
                    largest=right(currIndex);
                }

                if(largest==currIndex){
                    break;
                }

                swap(currIndex,largest);
                currIndex=largest;
            }
        }
        return root;
    }


    public void print(){
        for (int i:maxHeap){
            System.out.println(i);
        }
    }
}
