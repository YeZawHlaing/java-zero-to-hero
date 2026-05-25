package org.backend.twoSum;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 3, 7};
        int target = 9;

        int[] result = twoSum(nums, target);

        // 3. Used Arrays.toString() so the console prints the actual values cleanly
        System.out.println(Arrays.toString(result));
        // Expected Output: [1, 4] because arr[1] (2) + arr[4] (7) = 9
    }

    public static int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[j] == target-nums[i]){
                    return new int[] {i,j};
                }
            }
        }
        return new int[]{};
    }
}