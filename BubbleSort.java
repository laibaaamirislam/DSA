import java.util.Random;

public class BubbleSort {
    public static void bubbleSort(int[] A, int N) {
        for (int count = N - 1; count > 0; count--) {
            for (int index = 0; index < count; index++) {
                if (A[index] > A[index + 1]) {
                    int temp = A[index];
                    A[index] = A[index + 1];
                    A[index + 1] = temp;
                }
            }
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
            bubbleSort(array, array.length);
            long endTime = System.nanoTime();
            System.out.println("Bubble Sort: " + (endTime - startTime) / 1000000.0 + " ms");

            System.out.println();
        }
    }
}
