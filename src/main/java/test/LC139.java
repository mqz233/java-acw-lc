package test;

import java.util.*;

public class LC139 {
    // 求排列 s = "applepenapple", wordDict = ["apple", "pen"]
    // 如果是组合，那么只会出现appleapplepen，不会出现applepenapple
    public boolean wordBreak(String s, List<String> wordDict) {
        int sLength = s.length();
        boolean dp[] = new boolean[sLength + 1];
        dp[0] = true;
        for (int j = 1; j <= sLength; j++) {
            for (int i = 0; i < wordDict.size(); i++) {
                int wordLength = wordDict.get(i).length();
                if (j - wordLength >= 0 && dp[j - wordLength]
                        && wordDict.get(i).equals(s.substring(j - wordLength, j))) {
                    dp[j] = true;
                }
            }
        }

        return dp[sLength];

    }

}
