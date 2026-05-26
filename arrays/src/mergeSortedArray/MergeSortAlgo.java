package mergeSortedArray;

import java.util.Arrays;

public class MergeSortAlgo {
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

        // FIX 1: Base case to stop infinite recursion
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

        int i = 0; // pointer for left array
        int j = 0; // pointer for right array
        int k = 0; // pointer for finalArray

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

    public static void main(String[] args){
        int[] arr1 = {1, 3};
        int[] arr2 = {2}; // Works with any sizes now

        int[] result = TwoArrays(arr1, arr2);

        System.out.println("Mixed array: " + Arrays.toString(result));

        mergeSorted(result);

        // FIX 2: Print the array AFTER sorting to see the result
        System.out.println("Merged sorted array: " + Arrays.toString(result));
    }
}
