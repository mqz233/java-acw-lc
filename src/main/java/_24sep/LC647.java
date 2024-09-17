package _24sep;

public class LC647 {
    public int a = 3;
    public int b =4;
    LC647(){
        a = 5;
        b = 6;
    }
    public int countSubstrings(String s) {
        char[] arr = s.toCharArray();
        int n = s.length();
        int count = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            count++;
        }
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                dp[i][i + 1] = true;
                count++;
            }
        }
        for (int size = 3; size <= n; size++) {
            for (int i = 0; i < n; i++) {
                if (i + size > n) {
                    break;
                }
                if (arr[i] == arr[i + size - 1]) {
                    dp[i][i + size - 1] = dp[i + 1][i + size - 2];
                    count++;
                }
            }
        }
        return count;

    }

    public static void main(String[] args) {

        String str = "fdsklf";
        LC647 lc647 = new LC647();
        lc647.countSubstrings(str);
    }
}
