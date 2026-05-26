package twoMergeArrays;

import java.util.Arrays;

public class Demo {
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


    public static void main(String[] args){
        int[] arr1 = {1, 3};
        int[] arr2 = {2}; // Works with any sizes now

        int[] result = TwoArrays(arr1, arr2);

        System.out.println("Mixed array: " + Arrays.toString(result));
    }
}