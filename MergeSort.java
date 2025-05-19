import java.util.Random;

public class MergeSort {

    public static void mergeSort(int[] A, int start, int end) {
        if (end - start + 1 < 2) {
            return;
        } else {
            int mid = (start + end) / 2;
            mergeSort(A, start, mid);
            mergeSort(A, mid + 1, end);
            merge(A, start, mid, end);
        }
    }

    public static void merge(int[] A, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = A[start + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = A[mid + 1 + j];
        }

        int i = 0, j = 0, k = start;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                A[k] = left[i];
                i++;
            } else {
                A[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            A[k] = left[i];
            k++;
            i++;
        }

        while (j < n2) {
            A[k] = right[j];
            k++;
            j++;
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
            mergeSort(array, 0, array.length - 1);
            long endTime = System.nanoTime();
            System.out.println("Merge Sort: " + (endTime - startTime) / 1000000.0 + " ms");

            System.out.println();
        }
    }}


