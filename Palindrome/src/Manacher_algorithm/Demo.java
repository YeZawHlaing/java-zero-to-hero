package Manacher_algorithm;

public class Demo {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        // Step 1: Transform string to handle even lengths (e.g., "aba" -> "^#a#b#a#$")
        StringBuilder sb = new StringBuilder("^");

        for (int i = 0; i < s.length(); i++) {
            sb.append("#").append(s.charAt(i));
        }
        sb.append("#$");
        String T = sb.toString();

        System.out.println(T);

        int n = T.length();
        System.out.println("length of string with # : "+n);

        int[] P = new int[n]; // Array to store palindrome radius
        int C = 0;            // Center of the current furthest-reaching palindrome
        int R = 0;            // Right boundary of the current furthest-reaching palindrome

        int maxLen = 0;       // Length of the longest palindrome found
        int centerIndex = 0;  // Center index of the longest palindrome found

        // Step 2: Main Manacher's loop
        for (int i = 1; i < n - 1; i++) {
            int iMirror = 2 * C - i; // Mirror of i around Center C

            System.out.println("iMorror values:  "+iMirror);
            System.out.println("-----------");

            // If i is inside the current boundary R, copy the mirrored radius (bounded by R - i)
            if (R > i) {
                P[i] = Math.min(R - i, P[iMirror]);
            } else {
                P[i] = 0; // Reset if outside boundary
            }

            // Attempt to expand the palindrome centered at i
            while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i])) {
                P[i]++;
            }

            // If the palindrome centered at i expands past R, adjust the Center and Right boundary
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }

            // Track the absolute maximum radius found
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }

        // Step 3: Extract the original substring using the centerIndex and maxLen
        int start = (centerIndex - 1 - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        String input1 = "babad";
        String input2 = "cbbd";

        System.out.println("Manacher's Algorithm");
        System.out.println("---------------------");

        System.out.println("LPS of 'babad': " + longestPalindrome(input1));
        System.out.println(" ");
        System.out.println("LPS of 'cbbd': " + longestPalindrome(input2));
    }
}
