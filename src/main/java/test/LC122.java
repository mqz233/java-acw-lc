package test;

/**
 * @Author：Yan Zhaoyang
 * @Package：test
 * @Project：java-acw-lc
 * @name：LC122
 * @Date：2024/6/17 12:54
 * @Filename：LC122
 * @Desc：
 */
public class LC122 {
    public int maxProfit(int[] prices) {
        // 输入：prices = [7,1,5,3,6,4]
        // 输出：7
        // dp[i][0] 第i天持有股票的最大利润
        // dp[i][1] 第i天不持有股票的最大利润
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        // dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]-prices[i])
        // dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]+prices[i])
        for (int i=1; i<prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }
        return dp[prices.length-1][1];

    }
}
