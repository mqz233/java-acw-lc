package _24july;

/**
 * @description: 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 *
 * 返回 你可以获得的最大乘积 。
 */
public class LC343 {
    public int integerBreak(int n) {

        int[] dp = new int[n+1];
        dp[2] = 1;
        for(int i=3;i<=n;i++){
            for(int j=2;j<=i-1;j++){
                dp[i] = Math.max(dp[i],Math.max(dp[j]*(i-j),j*(i-j)));
            }
        }
        return dp[n];
    }
}
