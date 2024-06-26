package test;

public class LC516_2 {
    public int longestPalindromeSubseq(String s) {
        // "bbbab" 输出 4
        // 最长回文子序列
        // dp[i][j] i-j之间最长回文子序列长度
        int length = s.length();
        int dp[][] = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }
        for (int i = 2; i <= length; i++) {
            for (int j = 0; j < length; j++) {
                if (j + i > length)
                    break;
                int l = j;
                int r = j + i - 1;
                if (s.charAt(l) == s.charAt(r))
                    dp[l][r] = dp[l + 1][r - 1] + 2;
                else
                    dp[l][r] = Math.max(dp[l + 1][r], dp[l][r - 1]);
            }
        }
        return dp[0][length - 1];

    }
}
