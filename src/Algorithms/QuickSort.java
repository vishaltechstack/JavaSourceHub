package Algorithms;

public class QuickSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        quickSortRecursive(arr, 0, arr.length - 1);
    }

    private static void quickSortRecursive(int[] arr, int low, int high) {
        if (low < high) {
            // Partition array around pivot and get the pivot's final sorted index
            int pivotIndex = partition(arr, low, high);

            // Recursively sort elements before and after the pivot
            quickSortRecursive(arr, low, pivotIndex - 1);
            quickSortRecursive(arr, pivotIndex + 1, high);
        }
    }

    // Lomuto Partition Scheme: Uses the last element (arr[high]) as the pivot
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];

        // 'i' tracks the boundary of elements strictly smaller than the pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j); // Move smaller element into the left partition
            }
        }

        // Place the pivot right after the last smaller element (its exact final position!)
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
