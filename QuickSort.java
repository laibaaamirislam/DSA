import java.util.Arrays;
import java.util.Random;

public class QuickSort {

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
            quickSort(array, 0, array.length - 1);
            long endTime = System.nanoTime();
            System.out.println("Quick Sort: " + (endTime - startTime) / 1000000.0 + " ms");

            System.out.println();
        }
    }

    public static void quickSort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivotIndex = partition(A, start, end);
        quickSort(A, start, pivotIndex - 1);
        quickSort(A, pivotIndex + 1, end);
    }

    public static int partition(int[] A, int left, int right) {
        int pivot = A[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (A[j] <= pivot) {
                swap(A, i, j);
                i++;
            }
        }
        swap(A, i, right);
        return i;
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}

