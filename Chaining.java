import java.util.LinkedList;

public class Chaining {
    LinkedList<Data>[] array;
    int capacity = 10;


    public Chaining() {
        array = new LinkedList[capacity];
        initializie(array);
    }

    public void initializie(LinkedList<Data>[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = new LinkedList<Data>();

        }
    }

    public void insert(Data data) {
        int index = data.key % capacity;

        if (checkDuplicate(data, index)) {
            array[index].add(data);
        }

        System.out.println("inserted:" + data.value + " with key " + data.key);
    }

    public boolean checkDuplicate(Data data, int index) {

        int size = array[index].size();

        for (int i = 0; i < size; i++) {
            if (array[index].get(i).value == data.value) {
                return false;
            }
        }
        return true;
    }


    public Data remove(Data data) {
        Data removed = null;
        int index = data.key % capacity;
        int size = array[index].size();
        for (int i = 0; i < size; i++) {
            if (array[index].get(i).value == data.value) {
                removed = array[index].remove(i);
            }
        }

        return removed;
    }


    public Data search(int key) {
        Data target = null;
        int index = key % capacity;
        int size = array[index].size();
        for (int i = 0; i < size; i++) {
            if (array[index].get(i).key == key) {
                target = array[index].get(i);
            }
        }
        return target;
    }

    public void display() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].size(); j++) {
                System.out.println("index: " + j + "\n" + "key: " + array[i].get(j).key + ", value: " + array[i].get(j).value);
            }
        }
    }


    public static void main(String[] args) {
        Chaining hashTable = new Chaining();

        hashTable.insert(new Data(2, 5));
        hashTable.insert(new Data(3, 4));
        hashTable.insert(new Data(20, 8));

        Data data = hashTable.remove(new Data(3, 4));

        System.out.println("removed: " + data.value + " with key " + data.key);
        hashTable.display();


    }
}

