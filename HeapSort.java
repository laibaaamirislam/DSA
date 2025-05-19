public class HeapSort {
    private int[] array;

    public HeapSort() {
    }

    public int parent(int k) {
        return (k - 1) / 2;
    }

    public int left(int k) {
        return (2 * k) + 1;
    }

    public int right(int k) {
        return (2 * k) + 2;
    }

    public void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void maxHeapify(int[] array, int indexOfParent, int size) {
        int indexOflargest = indexOfParent;
        int indexOfLeft = left(indexOfParent);
        int indexOfRight = right(indexOfParent);

        if (indexOfLeft < size && array[indexOfLeft] > array[indexOflargest]) {
            indexOflargest = indexOfLeft;
        }

        if (indexOfRight < size && array[indexOfRight] > array[indexOflargest]) {
            indexOflargest = indexOfRight;
        }

        if (indexOflargest != indexOfParent) {
            swap(indexOfParent, indexOflargest);
            maxHeapify(array, indexOflargest, size);
        }
    }

    public void buildMaxHeap(int[] array, int size) {
        for (int i = size / 2 - 1; i >= 0; i--) {
            maxHeapify(array, i, size);
        }
    }

    public void Heap_Sort(int[] unsorted, int s) {
        array = unsorted;
        int size = array.length;

        buildMaxHeap(array, size);
        for (int i = size - 1; i > 0; i--) {
            swap(0, i);
            maxHeapify(array, 0, i);
        }
    }

    public static void main(String[] args) {
        HeapSort heap = new HeapSort();
        int[] arr = {12, 11, 3, 19, 60, 7};

        heap.Heap_Sort(arr, arr.length);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
