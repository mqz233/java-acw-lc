package carl.dp;

import java.util.Arrays;

/**
 * @Author：Yan Zhaoyang
 * @Package：carl.dp
 * @Project：java-acw-lc
 * @name：CompleteBackpack2
 * @Date：2024/3/8 14:25
 * @Filename：CompleteBackpack2
 * @Desc： 零钱兑换-完全背包刚好装满 https://leetcode.cn/problems/coin-change-ii/description/
 */
public class CompleteBackpack2 {
    public int change(int amount, int[] coins) {

        // 背包大小
        int size = amount;
        // dp[j] 含义完全装满载重为j的背包，有几种组合方式
        // 初始化 dp[0] = 1
        int[] dp = new int[size+1];
        dp[0] = 1;
        // 遍历：先物品再背包
        for (int i=0;i<coins.length;i++){
            for (int j = coins[i];j<=size;j++){
                // 递推：要么不放coins[i]，要么放coins[i]，上一轮的组合加起来，就是这一轮的组合数
                dp[j] = dp[j]+dp[j-coins[i]];
                System.out.print(dp[j]);
            }
            System.out.println(" round over");
        }

        return dp[size];

    }
    public static void main(String[] args) {
        CompleteBackpack2 completeBackpack2 = new CompleteBackpack2();
        completeBackpack2.change(4,new int[]{1,2,3});
    }
}
