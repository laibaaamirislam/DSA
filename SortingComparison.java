import java.util.Random;

public class SortingComparison {

    public static void main(String[] args) {
        int[] sizes = {10000, 50000, 100000};  // Array sizes to test
        Random rand = new Random();

        // Test for each algorithm
        for (int size : sizes) {
            System.out.println("Testing with array size: " + size);

            int[] array1 = generateRandomArray(size, rand);
            int[] array2 = array1.clone();
            int[] array3 = array1.clone();
            int[] array4 = array1.clone();
            int[] array5 = array1.clone();

            // Measure Bubble Sort
            long startTime = System.nanoTime();
            bubbleSort(array1);
            long endTime = System.nanoTime();
            System.out.println("Bubble Sort: " + (endTime - startTime) + " ns");

            // Measure Selection Sort
            startTime = System.nanoTime();
            selectionSort(array2);
            endTime = System.nanoTime();
            System.out.println("Selection Sort: " + (endTime - startTime) + " ns");

            // Measure Insertion Sort
            startTime = System.nanoTime();
            insertionSort(array3);
            endTime = System.nanoTime();
            System.out.println("Insertion Sort: " + (endTime - startTime) + " ns");

            // Measure Merge Sort
            startTime = System.nanoTime();
            mergeSort(array4, 0, array4.length - 1);
            endTime = System.nanoTime();
            System.out.println("Merge Sort: " + (endTime - startTime) + " ns");

            // Measure Quick Sort
            startTime = System.nanoTime();
            quickSort(array5, 0, array5.length - 1);
            endTime = System.nanoTime();
            System.out.println("Quick Sort: " + (endTime - startTime) + " ns");

            System.out.println("------------");
        }
    }

    public static int[] generateRandomArray(int size, Random rand) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(100000);  // Random numbers between 0 and 100,000
        }
        return array;
    }

    // Bubble Sort Implementation
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Selection Sort Implementation
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    // Insertion Sort Implementation
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    // Merge Sort Implementation
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        System.arraycopy(array, left, leftArray, 0, n1);
        System.arraycopy(array, mid + 1, rightArray, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Quick Sort Implementation
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}
