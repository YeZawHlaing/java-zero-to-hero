package longestSubString;

public class Solution {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Case 1: Odd length palindrome (e.g., "aba", center is 'b')
            int len1 = expandFromMiddle(s, i, i);

            // Case 2: Even length palindrome (e.g., "abba", center is between 'b' and 'b')
            int len2 = expandFromMiddle(s, i, i + 1);

            // Get the maximum length found at this center
            int maxLen = Math.max(len1, len2);

            // If we found a longer palindrome, update our tracking indices
            if (maxLen > (end - start)) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }

        // Return the actual substring using the tracked bounds
        return s.substring(start, end + 1);
    }

    private static int expandFromMiddle(String s, int left, int right) {
        // Expand outwards as long as bounds are valid and characters match
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Return the length of the palindrome found
        return right - left - 1;
    }

    public static void main(String[] args) {
        String input1 = "babad";
        String input2 = "cbbd";

        System.out.println("LPS of 'babad': " + longestPalindrome(input1)); // Output: "bab" or "aba"
        System.out.println("LPS of 'cbbd': " + longestPalindrome(input2));  // Output: "bb"
    }
}