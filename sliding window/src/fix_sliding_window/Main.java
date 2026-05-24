package fix_sliding_window;

//problem:
//Given an array of integers, find the maximum sum of any contiguous subarray of size $k$.
public class Main {
    //The sliding window pattern is all about converting an expensive nested loop ($O(n^2)$) into a highly efficient single loop ($O(n)$)

    //need a method to cut array
    public static int maxSubArraySum(int[] arr, int k){
      int windowSum=0;
      int maxSum=0;

      // compute the sum of first half window
      for (int i=0;i<k;i++){
        windowSum+=arr[i];
      }
      maxSum=windowSum;

      // compute rest of the array from the end of k
        for (int i = k; i < arr.length; i++) {
            // Add the next element entering the window, subtract the one leaving
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }


      return maxSum;
    }

    public static void main(String[] args){

     System.out.println("max sum =");
     System.out.println(maxSubArraySum(new int[]{2, 1, 5, 1, 3, 2},3));

    }
    //output= 9
}
