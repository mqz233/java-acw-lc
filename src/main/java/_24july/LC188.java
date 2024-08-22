package _24july;

/**
 * @description:
 */
public class LC188 {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[k][2][prices.length];
        for (int i = 0; i < k; i++) {
            dp[i][1][0] = -prices[0];

        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < k; j++) {
                if (j > 0) dp[j][0][i] = Math.max(dp[j][0][i - 1], dp[j - 1][1][i - 1] + prices[i]);
                dp[j][1][i] = Math.max(dp[j][1][i - 1], dp[j][0][i - 1] - prices[i]);
            }
        }
        return dp[k-1][0][prices.length - 1];
    }
}
