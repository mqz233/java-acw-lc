package test;
import java.util.*;

public class LC343 {
    public int integerBreak(int n) {

        if ( n== 2) return 1;
        if (n == 3) return 2;
        int[] dp = new int[n+1];
        dp[2] = 2;
        dp[3] = 3;
        for(int i=4;i<=n;i++){
            for(int l=2;l<=i/2;l++){
                int r = i-l;
                if(r<2) break;
                dp[i] = Math.max(dp[i],dp[l]*dp[r]);
            }
        }
        return dp[n];

    }

}