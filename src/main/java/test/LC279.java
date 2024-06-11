package test;

import java.util.*;

public class LC279 {
    public int numSquares(int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;
        int tmp = (int) Math.sqrt(n);
        for(int i=1;i<=tmp;i++){
            for(int j=i*i;j<=n;j++){
                dp[j] =  Math.min(dp[j-(i*i)]+1,dp[j]);
            }
        }

        return dp[n];


    }
}