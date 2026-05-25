package longestSubString;

import java.util.ArrayList;

public class Solution {

    public static int lengthOfLongestSubstringMyLogic(String s) {
        if (s == null || s.length() == 0) return 0;

        // 1. "push input string s into array arr"
        char[] arr = s.toCharArray();

        int maxCount = 0;

        // Start looping from the start of the array
        for (int start = 0; start < arr.length; start++) {

            // Your "dummyRoom" upgraded to hold the history of the current streak
            ArrayList<Character> dummyRoom = new ArrayList<>();
            int currentCount = 0;

            for (int i = start; i < arr.length; i++) {
                // "next one is pushed into nextRoom"
                char nextRoom = arr[i];

                // "condition: if dummyRoom and nextRoom is equal, loop quit"
                // (Checking if nextRoom is already inside our dummyRoom history)
                if (dummyRoom.contains(nextRoom)) {
                    break; // loop quit!
                }

                // "or if they are not same, store in result count and go next"
                dummyRoom.add(nextRoom);
                currentCount++;

                // Track the highest count we've ever seen
                maxCount = Math.max(maxCount, currentCount);
            }
        }

        return maxCount;
    }

    public static void main(String[] args) {
        String input = "abacabcb";
        int result = lengthOfLongestSubstringMyLogic(input);
        System.out.println("Longest substring length for '" + input + "' is: " + result);
        // Output will be 3 (for "abc")
    }
}