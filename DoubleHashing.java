public class DoubleHashing {
    Pair[] array;
    final int capacity = 10;

    public DoubleHashing() {
        array = new Pair[capacity];
    }

    private void insert(Pair p) {
        int u = (2 * p.key + 3) % capacity;
        int v = (3 * p.key + 1) % capacity;

        for (int i = 0; i < capacity; i++) {
            p.prob++;

            int w = (u + v + i) % capacity;
            if (array[w] == null) {
                array[w] = p;
                break;
            }

            if (array[w].key == p.key) {
                array[w] = p;
                break;
            }
        }
    }

    public Pair search(int k){

        Pair p=null;
        int u = (2*k + 3) % capacity;
        int v = (3*k + 1) % capacity;

        for(int i = 0; i < capacity; i++){
            int w = (u+v+i) % capacity;
            if (array[w] != null && array[w].key== k){
                p=array[w];
                break;
            }
        }
        return p;
    }

    public Pair delete(Pair pair){

        int k = pair.key;

        Pair p=null;
        int u = (2*k + 3) % capacity;
        int v = (3*k + 1) % capacity;

        for(int i = 0; i < capacity; i++){
            int w = (u+v+i) % capacity;
            if (array[w] != null && array[w].key== k){
                p=array[w];
                array[w] = null;
                break;
            }
        }
        return p;
    }

    public void display(){
        for  ( int i =0; i < capacity; i++){
            if(array[i]!=null){

                System.out.println("Index: " + i +
                        ", Key: " + array[i].key +
                        ", Value: " + array[i].value +
                        ", Prob: " + array[i].prob);
            } else {
                System.out.println("slot " + i + " is empty!");
            }
        }
    }

    public static void main(String[] args) {
        DoubleHashing hash = new DoubleHashing();

        hash.insert(new Pair(3, 3));
        hash.insert(new Pair(2, 2));
        hash.insert(new Pair(9, 9));
        hash.insert(new Pair(6, 6));
        hash.insert(new Pair(11, 11));
        hash.insert(new Pair(13, 13));
        hash.insert(new Pair(7, 7));
        hash.insert(new Pair(12, 12));

        hash.display();
        Pair p = hash.search(11);
        System.out.println("searched value with key: " + p.key);
        Pair p1 = hash.search(12);
        System.out.println("searched value with key: " + p1.key);
        Pair p2 = hash.search(7);
        System.out.println("searched value with key: " + p2.key);

        Pair  p3=hash.delete(p);
        System.out.println("deleted val w key " + p.key + " is: " + p3.value );

        hash.display();
    }
}
