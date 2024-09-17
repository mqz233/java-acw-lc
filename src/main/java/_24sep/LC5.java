package _24sep;

public class LC5 {
    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int max = 1;
        int l = 0;
        int r = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                dp[i][i + 1] = true;
                max = 2;
                l = i;
                r = i + 1;
            }
        }
        for (int size = 3; size <= n; size++) {
            for (int i = 0; i < n; i++) {
                if (i + size > n) {
                    break;
                }
                if (arr[i] == arr[i + size - 1]) {
                    dp[i][i + size - 1] = dp[i + 1][i + size - 2];
                    if (dp[i + 1][i + size - 2] && size > max) {
                        max = size;
                        l = i;
                        r = i + size - 1;
                    }
                } else {
                    dp[i][i + size - 1] = false;
                }

            }
        }
        return s.substring(l, r + 1);
    }

    public static void main(String[] args) {
        LC5 lc5 = new LC5();
        lc5.longestPalindrome("aacabdkacaa");
    }
}
