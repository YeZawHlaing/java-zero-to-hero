package smallerThanCurrent;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args){
        int[] nums = {8,1,2,2,3};
        int[] res=new int[nums.length];
        int count;

        for(int i=0;i<nums.length;i++){
            count=0;
            for (int j=0;j<nums.length;j++){
                if(i!=j && nums[j]<nums[i]){
                    count++;
                }
            }
            res[i]=count;
            System.out.print(res[i]);
        }



    }
}
