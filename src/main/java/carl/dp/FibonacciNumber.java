package carl.dp;

// https://leetcode.cn/problems/fibonacci-number/
public class FibonacciNumber {
    // dp[i]含义：第i个斐波那契数的值
    // 递推公式：dp[i] = dp[i-1]+dp[i-2];
    // 初始化  dp[0] = 0;  dp[1] = 1;
    // 遍历顺序：从2开始，遍历到n
    public int fib(int n) {
        if (n<=1){
            return n;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <=n ; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];



    }
}
