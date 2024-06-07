package test;
import java.util.*;

public class LC746 {
    public int minCostClimbingStairs(int[] cost) {

        if(cost.length == 2) return Math.min(cost[0],cost[1]);

        int[] dp = new int[cost.length+1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i=2;i<=cost.length;i++){
            dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }

        return dp[cost.length];

    }
    
}
