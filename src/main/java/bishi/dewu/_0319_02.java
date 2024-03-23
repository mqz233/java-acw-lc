package bishi.dewu;

import org.junit.Test;

import java.util.Scanner;

public class _0319_02 {
    public static void main(String[] args) {

    }

    @Test
    public void test(){
        Scanner scanner = new Scanner(System.in);
        // 数字个数
        int N = scanner.nextInt();
        // 要求的综合
        int M = scanner.nextInt();
        // dp
        int[] dp = new int[M+1];
        // 记录数字
        int[] nums = new int[N];
        for (int i=0; i<N;i++){
            nums[i] = scanner.nextInt();
        }
        // 01背包，先物品再背包
        // dp[j] 凑成数字j，需要num的最小数量
        // 递推公式 dp[j] = Math.min(dp[j],dp[j-nums[i]]+1)
        // 初始化dp
        // dp[0] = 0 dp[j] = Integer.MAX
        dp[0] = 0;
        for (int i=1;i<=M;i++){
            dp[i] = N+1;
        }
        for (int i=0;i<N;i++){
            for (int j=M;j>=nums[i];j--){
                dp[j] = Math.min(dp[j],dp[j-nums[i]]+1);
            }
        }
        if (dp[M] == N+1){
            System.out.println("No solution");
        }
        System.out.println(dp[M]);

    }

}
