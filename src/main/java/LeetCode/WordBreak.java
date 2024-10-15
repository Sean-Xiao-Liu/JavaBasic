package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);  // Convert list to set for faster lookup
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;  // Base case: empty string can be segmented

        // Fill the dp array
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                /**
                 * In the wordBreak function, the dp[j] check is essential for ensuring that the substring s[0...j-1] can be segmented before considering the current substring s[j...i-1].
                 *
                 * Here's a breakdown of why this check is necessary:
                 *
                 * Dynamic Programming Principle: The dp array is used to store intermediate results. dp[i] indicates whether the substring s[0...i-1] can be segmented.
                 * Building on Previous Results: To determine if s[0...i-1] can be segmented, we need to find a valid split point j such that:
                 * s[0...j-1] can be segmented (i.e., dp[j] is true).
                 * s[j...i-1] is a valid word in the dictionary.
                 * Avoiding Invalid Substrings: If dp[j] is false, it means that the substring s[0...j-1] cannot be segmented.
                 * In this case, there's no point in checking if s[j...i-1] is a valid word, as the entire substring s[0...i-1] will be invalid regardless.
                 */
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;  // No need to check further once we find a valid segmentation
                }
            }
        }

        return dp[s.length()];
    }



    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak.wordBreak("leetcode",wordDict));
    }
}
