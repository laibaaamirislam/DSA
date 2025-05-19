import java.util.Random;

public class InsertionSort {
    public static void insertionSort(int[] A, int N) {
        for (int count = 1; count < N; count++) {
            int v = A[count];
            int j = count;
            while (j > 0 && A[j - 1] > v) {
                A[j] = A[j - 1];
                j--;
            }
            A[j] = v;
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
            insertionSort(array, array.length);
            long endTime = System.nanoTime();
            System.out.println("Insertion Sort: " + (endTime - startTime) / 1000000.0 + " ms");

            System.out.println();
        }
    }
}

