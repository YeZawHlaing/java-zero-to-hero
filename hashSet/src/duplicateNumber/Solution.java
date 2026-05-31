package duplicateNumber;

import java.util.HashSet;

public class Solution {
    public static boolean Isduplicate(int[] nums){
        HashSet<Integer> set=new HashSet<>();

        for(int i=0;i<nums.length;i++){
            if(!set.add(nums[i])){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args){

        int[] nums={1,2,3};
        System.out.println(Isduplicate(nums));

    }
}
