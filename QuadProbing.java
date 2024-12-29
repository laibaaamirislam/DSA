import java.util.ArrayList;

public class QuadProbing {
    ArrayList<Pair> array;

    public QuadProbing() {
        this.array = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            array.add(null);
        }
    }

    public void insert(Pair p) {
        int u = (2 * p.key + 3) % array.size();

        for (int i = 0; i < array.size(); i++) {
            int v = (u + (i * i)) % array.size();

            p.prob++;
            if (array.get(v) == null) {
                array.set(v, p);
                break;
            }

            if (array.get(v).value == p.value) {
                array.set(v, p);
                break;
            }


        }
    }

    public void display() {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) != null) {
                System.out.println("Index: " + i +
                        ", Key: " + array.get(i).key +
                        ", Value: " + array.get(i).value +
                        ", Prob: " + array.get(i).prob);
            } else {
                System.out.println("slot " + i + " is empty!");
            }
        }
    }

    public Pair remove(Pair p) {
        Pair removed = null;
        int u = (2 * p.key + 3) % array.size();

        for (int i = 0; i < array.size(); i++) {
            int v = (u + (i * i)) % array.size();

            if (array.get(v) != null && array.get(v).value == p.value && array.get(v).key == p.key) {
                removed = array.get(v);
                array.set(v, null);
                break;
            }
        }

        return removed;
    }

    public Pair search(int k) {
        Pair p = null;
        int u = (2 * k + 3) % array.size();
        for (int i = 0; i < array.size(); i++) {
            int v = (u + (i * i)) % array.size();
            if (array.get(v) != null && array.get(v).key == k) {
                p = array.get(v);
                break;
            }
        }
        return p;
    }

    public static void main(String[] args) {
        QuadProbing hash = new QuadProbing();
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

        Pair  p3=hash.remove(p);
        System.out.println("deleted val w key " + p.key + " is: " + p3.value );

        hash.display();
    }
}
