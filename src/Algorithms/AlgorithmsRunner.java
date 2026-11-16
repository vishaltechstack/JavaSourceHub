package Algorithms;

import java.util.Arrays;

public class AlgorithmsRunner {

    public static void main(String[] args) {

        // --- 1. Testing Merge Sort ---
        int[] numbersForMerge = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Original Array (Merge Sort): " + Arrays.toString(numbersForMerge));

        MergeSort.sort(numbersForMerge);
        System.out.println("Sorted Array   (Merge Sort): " + Arrays.toString(numbersForMerge));

        // --- 2. Testing Quick Sort ---
        int[] numbersForQuick = {64, 25, 12, 22, 11, 90, 33};
        System.out.println("\nOriginal Array (Quick Sort): " + Arrays.toString(numbersForQuick));

        QuickSort.sort(numbersForQuick);
        System.out.println("Sorted Array   (Quick Sort): " + Arrays.toString(numbersForQuick));

        // --- 3. Combining Sorting + Binary Search ---
        int searchTarget = 33;
        int foundIndex = BinarySearchDemo.binarySearchIterative(numbersForQuick, searchTarget);
        System.out.println("\nBinary Search for " + searchTarget + " in QuickSorted array -> Index: " + foundIndex);
    }
}