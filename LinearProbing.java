public class LinearProbing {
    Pair [] array;

    public LinearProbing() {
        array= new Pair[10];
    }
    public void insert(Pair pair) {
        int u = (2 * pair.key + 3) % array.length;
        int initialIndex = u;

        for (int i = 0; i < array.length; i++) {
            int v = (u + i) % array.length;

            if (array[v] == null) {
                array[v] = pair;
                pair.prob = i + 1;
                return;
            }

            if (array[v].key == pair.key) {
                array[v].value = pair.value;
                return;
            }
        }

        System.out.println("Hash table is full! Cannot insert.");
    }


    public void display() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                System.out.println("Index: " + i +
                        ", Key: " + array[i].key +
                        ", Value: " + array[i].value +
                        ", Prob: " + array[i].prob);
            } else {
                System.out.println("Index: " + i + " is empty.");
            }
        }
    }

    public Pair delete(Pair pair) {
        Pair target = null;
        int key = pair.key;
        int u = (2 * pair.key + 3) % array.length;
        for (int i = 0; i < array.length; i++) {
            int v = (u + i) % array.length;
            if (array[v] != null && array[v].key == pair.key && array[v].value == pair.value) {
                target = array[v];
                array[v] = null;
                for (int j = 1; j < array.length; j++) {
                    int w = (v + j) % array.length;
                    if (array[w] == null) break;
                    Pair rehashPair = array[w];
                    array[w] = null;
                    insert(rehashPair);
                }
                break;
            }
        }
        return target;
    }


    public Pair search(int key){
        int k = key;
        Pair target=null;
        int u = (2*k + 3) % array.length;
        for( int i = 0 ; i < array.length; i++){
            int v = (u+i) % array.length;
            if(array[v] != null && key == array[v].key ){
                target = array[v];
            }
        }
       return target;
    }




    public static void main(String[] args) {
        LinearProbing hash = new LinearProbing();


        hash.display();
        hash.insert(new Pair(3,3));
        hash.insert(new Pair(2,2));
        hash.insert(new Pair(9,9));
        hash.insert(new Pair(6,6));
        hash.insert(new Pair(11,11));
        hash.insert(new Pair(13,13));
        hash.insert(new Pair(7,7));
        hash.insert(new Pair(12,12));
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
