package test;
import java.util.*;

public class LC96 {

    public int numTrees(int n) {
        // dp[0] = 1
        // dp[1] = 1
        // dp[2] = 2
        // dp[3] = dp[0]*dp[2]+dp[1]*dp[1]+dp[2]*dp[0]

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        if (n==1) {
            return 1;
        }
        dp[2] = 2;
        for(int i=3;i<=n;i++){
            for(int j=0; i<=i-1;j++){
                dp[i] = dp[i] + dp[j]*dp[i-j-1];
            }
        }

        return dp[n];
    }
    
}
