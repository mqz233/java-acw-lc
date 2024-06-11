package test;
import java.util.*;

public class LC322 {
    public int coinChange(int[] coins, int amount) {

        // 返回凑成需要的最少数量，不能凑成返回-1
        int[] dp = new int[amount+1];
        Arrays.fill(dp,10001);
        dp[0] = 0;
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
            }
        }
        return dp[amount] == 10001?-1:dp[amount];

    }
    
}
