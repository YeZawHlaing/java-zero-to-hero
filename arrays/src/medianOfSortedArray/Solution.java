package medianOfSortedArray;

import java.util.Arrays;

public class Solution {
    public static int[] TwoArrays(int[] arr1, int[] arr2){
        int[] mixArray = new int[arr1.length + arr2.length];
        int placement = 0;

        for (int i = 0; i < arr1.length; i++){
            mixArray[placement] = arr1[i];
            placement++;
        }

        for (int j = 0; j < arr2.length; j++){
            mixArray[placement] = arr2[j];
            placement++;
        }

        return mixArray;
    }

    // Sorting array using merge sort
    public static void mergeSorted(int[] finalArray){
        int mixLength = finalArray.length;

        if (mixLength < 2) {
            return;
        }

        int mid = mixLength / 2;
        int[] left = new int[mid];
        int[] right = new int[mixLength - mid];

        for (int i = 0; i < mid; i++){
            left[i] = finalArray[i];
        }

        for (int i = mid; i < mixLength; i++){
            right[i - mid] = finalArray[i];
        }

        mergeSorted(left);
        mergeSorted(right);

        finalMerged(finalArray, left, right);
    }

    public static void finalMerged(int[] finalArray, int[] left, int[] right){
        int leftSize = left.length;
        int rightSize = right.length;

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < leftSize && j < rightSize){
            if (left[i] <= right[j]){
                finalArray[k] = left[i];
                i++;
            } else {
                finalArray[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < leftSize){
            finalArray[k] = left[i];
            i++;
            k++;
        }
        while (j < rightSize){
            finalArray[k] = right[j];
            j++;
            k++;
        }
    }

    // FIX 1: Changed return type to double to properly handle even-length averages
    public static double median(int[] input){
        int totalLength = input.length;

        // Scenario A: Odd number of total elements
        if (totalLength % 2 != 0) {
            return input[totalLength / 2];
        }
        // Scenario B: Even number of total elements
        else {
            int mid1 = input[(totalLength / 2) - 1];
            int mid2 = input[totalLength / 2];
            return (mid1 + mid2) / 2.0; // Keeps the decimal precision
        }
    }

    public static void main(String[] args){
        int[] arr1 = {1, 3};
        int[] arr2 = {2}; // Combined size of 4 to test the even-length logic

        int[] result = TwoArrays(arr1, arr2);

        System.out.println("Mixed array: " + Arrays.toString(result));

        // Sorts the array 'result' in place
        mergeSorted(result);
        System.out.println("Merged sorted array: " + Arrays.toString(result));

      //Pass the sorted 'result' array into median, and print the return value
        double finalMedian = median(result);
        System.out.println("Median: " + finalMedian);
    }
}