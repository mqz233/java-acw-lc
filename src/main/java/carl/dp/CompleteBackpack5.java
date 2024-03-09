package carl.dp;

/**
 * @Author：Yan Zhaoyang
 * @Package：carl.dp
 * @Project：java-acw-lc
 * @name：CompleteBackpack2
 * @Date：2024/3/8 14:25
 * @Filename：CompleteBackpack2
 * @Desc： 完全平方数 https://leetcode.cn/problems/perfect-squares/description/
 */
public class CompleteBackpack5 {

    public static void main(String[] args) {
        CompleteBackpack5 completeBackpack3 = new CompleteBackpack5();
        int result = completeBackpack3.numSquares(12);
        System.out.println(result);
    }

    public int numSquares(int n) {

        int max = (int) Math.sqrt(n);
        // dp[j] 含义凑成j需要的平方数最小数量
        // dp[0] = 0
        // 完全背包求最小,其他初始化为Int.max
        // 顺序:不是组合排列,都可以
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= max; i++) {
            int tmp = (int) Math.pow(i, 2);
            for (int j = tmp; j <= n; j++) {
                if (dp[j - tmp] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - tmp] + 1);
//                    System.out.print(dp[j]);
//                    System.out.print(' ');
                }
            }
//            System.out.println(" round ");

        }

        return dp[n];
    }
}
