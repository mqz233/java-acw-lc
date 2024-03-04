package carl.dp;

import java.util.Scanner;

public class _01Backpack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 物品种类M 背包容量N
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int[] values = new int[M];
        int[] weights = new int[M];
        for(int i=0;i<M;i++){
            weights[i] = scanner.nextInt();
        }
        for (int i=0;i<M;i++){
            values[i] = scanner.nextInt();
        }
        // dp[i][j] 含义背包最大载重为j,weights[0]-weights[i]的物品尝试放入的最大价值
        int[][] dp = new int[M][N+1];
        // 第一列初始化 载重为0,价值为0
        for (int i=0;i<M;i++){
            dp[i][0] = 0;
        }
        // 第一行初始化 j>weights[0] ,价值即为values[0]
        for (int j=0;j<=N;j++){
            if (j>=weights[0]){
                dp[0][j] = values[0];
            }
        }
        // 递推
        for (int j=1;j<=N;j++){
            for (int i=1;i<M;i++){
                // 如果weights[i]>j,那么一定放不进去,dp[i][j]就是dp[i-1][j]
                if (weights[i]>j){
                    dp[i][j] = dp[i-1][j];
                }else {
                    // 否则和dp[i-1][j-weights[i]]+values[i] 进行比较,取最大值
                    dp[i][j] = Math.max(dp[i-1][j],values[i]+dp[i-1][j-weights[i]]);
                }
            }
        }

        // 输出最大值
        System.out.println(dp[M-1][N]);
    }
}
