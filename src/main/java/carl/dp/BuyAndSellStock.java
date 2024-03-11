package carl.dp;

// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/ 买卖股票的最佳时机
public class BuyAndSellStock {
    public int maxProfit(int[] prices) {
        // 状态组成:(1)持有股票或不持有股票,(2)天数
        // 持有可以是这一天买入,也可以是保持持有状态
        // 不持有可以是这一天卖出,也可以是还没购买或者已经卖出

        // dp[i][0] 第i天持有股票的最大利润
        // dp[i][1] 第i天不持有股票的最大利润
        // 最大利润 Math.max(dp[prices.length-1][0],dp[prices.length-1][1])

        // 递推公式 dp[i][0] = Math.max(dp[i-1][0],-prices[i])
        // dp [i][1] = Math.max(dp[i-1][0]+prices[i],dp[i-1][1])

        // 初始化 dp [0][0]=-prices[0] dp[0][1] = 0

        // 遍历顺序 从第1天到第prices.length-1天

        if (prices.length==1){
            return 0;
        }

        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i=1;i<prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }

        return Math.max(dp[prices.length-1][0],dp[prices.length-1][1]);

    }
}
