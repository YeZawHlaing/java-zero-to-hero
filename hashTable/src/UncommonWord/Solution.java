package UncommonWord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        String s1 = "This apple is sweet";
        String s2 = "This apple is sour";

        // 1. Split into pure String arrays (No Arrays.toString() here!)
        String[] words1 = s1.toLowerCase().split(" ");
        String[] words2 = s2.toLowerCase().split(" ");

        HashMap<String, Integer> wordCounts = new HashMap<>();

        // 2. Count words from the first string
        for (String word : words1) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }

        // 3. Count words from the second string into the SAME map
        for (String word : words2) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }

        List<String> uncommonWords = new ArrayList<>();

        // 4. Use keySet to pull out words that appeared exactly once
        for (String word : wordCounts.keySet()) {
            if (wordCounts.get(word) == 1) {
                uncommonWords.add(word);
            }
        }

        // Print final result at the very end
        System.out.println("Uncommon words: " + uncommonWords);
    }
}