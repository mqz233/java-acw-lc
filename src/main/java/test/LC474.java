package test;

import java.util.*;

public class LC474 {

    public int[][] buildArr(String[] strs) {
        int[][] arr = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '0') {
                    arr[i][0]++;
                } else {
                    arr[i][1]++;
                }
            }
        }
        return arr;
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] arr = buildArr(strs);
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < strs.length; i++) {
            for (int j = m; j >= arr[i][0]; j--)
                for (int k = n; k >= arr[i][1]; k--) {
                    dp[j][k] = Math.max(dp[j-arr[i][0]][k-arr[i][1]]+1,dp[j][k]);
                }
        }

        return dp[m][n];

    }

}
