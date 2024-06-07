package test;
import java.util.*;

public class LC509 {

    public int fib(int n) {

        // 动态规划
        // dp[i] 含义 dp[1] = 1 dp[2]= 1+2
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }

        return dp[n];

    }
    
}
