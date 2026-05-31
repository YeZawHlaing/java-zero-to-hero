package removeDuplicateNum;

import java.util.HashSet;

public class Solution {

    public static int removeDuplicate(int[] nums){
        HashSet<Integer> set=new HashSet<>();
        int index=0;

        for(int i=0; i<nums.length;i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                nums[index]=nums[i];
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args){

        int[] nums={1,2,1,3};

        int[] expectedNums = {1,2,3}; // The expected answer with correct length

        int k = removeDuplicate(nums); // Calls implementation

        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
        System.out.println("k= "+k);

        System.out.println(removeDuplicate(nums));
    }
}
