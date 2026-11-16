package Algorithms;

public class BinarySearchDemo {

    // 1. Iterative Binary Search: O(log n) time, O(1) extra space (Preferred in production)
    public static int binarySearchIterative(int[] sortedArr, int target) {
        int left = 0;
        int right = sortedArr.length - 1;

        while (left <= right) {
            // Overflow-safe midpoint formula: avoids (left + right) exceeding Integer.MAX_VALUE
            int mid = left + (right - left) / 2;

            if (sortedArr[mid] == target) {
                return mid; // Target found at index 'mid'
            } else if (sortedArr[mid] < target) {
                left = mid + 1;  // Discard left half; search right half
            } else {
                right = mid - 1; // Discard right half; search left half
            }
        }

        return -1; // Target does not exist in the array
    }

    // 2. Recursive Binary Search: O(log n) time, O(log n) call stack space
    public static int binarySearchRecursive(int[] sortedArr, int target, int left, int right) {
        // Base case: Search window exhausted
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (sortedArr[mid] == target) {
            return mid;
        } else if (sortedArr[mid] < target) {
            return binarySearchRecursive(sortedArr, target, mid + 1, right);
        } else {
            return binarySearchRecursive(sortedArr, target, left, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] data = {4, 11, 19, 27, 35, 48, 62, 79, 91};

        int target1 = 48;
        int target2 = 50;

        System.out.println("Iterative search for " + target1 + " -> Index: " +
                binarySearchIterative(data, target1)); // Index 5

        System.out.println("Recursive search for " + target1 + " -> Index: " +
                binarySearchRecursive(data, target1, 0, data.length - 1)); // Index 5

        System.out.println("Search for missing " + target2 + " -> Index: " +
                binarySearchIterative(data, target2)); // -1
    }
}
