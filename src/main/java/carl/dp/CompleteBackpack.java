package carl.dp;

import java.util.Scanner;

/**
 * @Author：Yan Zhaoyang
 * @Package：carl.dp
 * @Project：java-acw-lc
 * @name：CompleteBackpack
 * @Date：2024/3/8 14:09
 * @Filename：CompleteBackpack
 * @Desc：
 */
public class CompleteBackpack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 物品种类
        int N = scanner.nextInt();
        // 背包载重
        int V = scanner.nextInt();
        // 物品重量，价值
        int[] weights = new int[N];
        int[] values = new int[N];
        for (int i=0; i<N; i++){
            weights[i] = scanner.nextInt();
            values[i] = scanner.nextInt();
        }
        // dp数组 含义dp[j] 载重为j的背包的最大价值
        int[] dp = new int[V+1];

        // 先物品再背包，完全背包从j=weights[i]开始
        for (int i=0; i<N; i++){
            for (int j=weights[i];j<=V;j++){
                dp[j] = Math.max(dp[j],dp[j-weights[i]]+values[i]);
            }
        }

        System.out.println(dp[V]);

    }
}
