package carl.dp;

/**
 * @Author：Yan Zhaoyang
 * @Package：carl.dp
 * @Project：java-acw-lc
 * @name：CompleteBackpack2
 * @Date：2024/3/8 14:25
 * @Filename：CompleteBackpack2
 * @Desc： 完全背包 零钱兑换,求硬币min个数 https://leetcode.cn/problems/coin-change/
 */
public class CompleteBackpack4 {

    public static void main(String[] args) {
        CompleteBackpack4 completeBackpack3 = new CompleteBackpack4();
        int result = completeBackpack3.coinChange(new int[]{2}, 3);
        System.out.println(result);
    }

    public int coinChange(int[] coins, int amount) {

        int size = amount;
        int[] dp = new int[size + 1];
        // 求最小值:dp[0]=0 其他dp[j]为Int最大值,防止被覆盖
        dp[0] = 0;
        for (int i = 1; i <= size; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= size; j++) {
                // 防止+1溢出
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
//                System.out.print(dp[j]);
//                System.out.print(' ');
                }

            }
//            System.out.println(" round ");
        }
        return dp[size] == Integer.MAX_VALUE ? -1 : dp[size];
    }
}
