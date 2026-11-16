package Algorithms;

public class MergeSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Already sorted
        }
        mergeSortRecursive(arr, 0, arr.length - 1);
    }

    // Step 1: Divide the array recursively into left and right halves
    private static void mergeSortRecursive(int[] arr, int left, int right) {
        if (left >= right) {
            return; // Base case: single element subarray
        }

        int mid = left + (right - left) / 2;

        mergeSortRecursive(arr, left, mid);      // Sort left half
        mergeSortRecursive(arr, mid + 1, right); // Sort right half

        // Step 2: Conquer by merging the two sorted halves
        merge(arr, left, mid, right);
    }

    // Merges two sorted subarrays: arr[left..mid] and arr[mid+1..right]
    private static void merge(int[] arr, int left, int mid, int right) {
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        // Temporary arrays to hold both halves
        int[] leftTemp = new int[leftSize];
        int[] rightTemp = new int[rightSize];

        for (int i = 0; i < leftSize; i++) {
            leftTemp[i] = arr[left + i];
        }
        for (int j = 0; j < rightSize; j++) {
            rightTemp[j] = arr[mid + 1 + j];
        }

        // Two pointers (i for leftTemp, j for rightTemp) + k for main array
        int i = 0, j = 0, k = left;

        while (i < leftSize && j < rightSize) {
            // '<=' keeps Merge Sort STABLE (left element wins ties)
            if (leftTemp[i] <= rightTemp[j]) {
                arr[k++] = leftTemp[i++];
            } else {
                arr[k++] = rightTemp[j++];
            }
        }

        // Copy any remaining elements from leftTemp or rightTemp
        while (i < leftSize) {
            arr[k++] = leftTemp[i++];
        }
        while (j < rightSize) {
            arr[k++] = rightTemp[j++];
        }
    }
}
