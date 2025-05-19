import java.util.Random;

public class SelectionSort {
    public static void selectionSort(int[] A, int N) {
        int pos_min, tmp;
        for (int count = 0; count < N; count++) {
            pos_min = count;
            for (int index = count; index < N; index++) {
                if (A[index] < A[pos_min]) {
                    pos_min = index;
                }
            }
            tmp = A[pos_min];
            A[pos_min] = A[count];
            A[count] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] sizes = {10000, 50000, 100000};

        for (int size : sizes) {
            System.out.println("Testing with array size: " + size);
            int[] array = new int[size];
            Random rand = new Random();
            for (int i = 0; i < size; i++) {
                array[i] = rand.nextInt(100000);
            }

            long startTime = System.nanoTime();
            selectionSort(array, array.length);
            long endTime = System.nanoTime();
            System.out.println("Selection Sort: " + (endTime - startTime) / 1000000.0 + " ms");

            System.out.println();
        }
    }
}

