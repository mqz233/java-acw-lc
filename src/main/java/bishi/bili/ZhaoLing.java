package bishi.bili;

public class ZhaoLing {
    public int GetCoinCount (int N) {
        // write code here
        int sum = 1024-N;
        if (sum == 0){
            return 0;
        }
        // 1 4 16 64
        int[] dp = new int[sum+1];
        dp[0] = 0;
        for (int i=1;i<=sum;i++){
            int min= 1100;
            if (i-1>=0){
                min = Math.min(dp[i - 1] + 1, min);
            }
            if (i-4>=0){
                min = Math.min(dp[i - 4] + 1, min);
            }
            if (i-16>=0){
                min = Math.min(dp[i - 16] + 1, min);
            }
            if (i-64>=0){
                min = Math.min(dp[i - 64] + 1, min);
            }
            dp[i] = min;
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        ZhaoLing zhaoLing = new ZhaoLing();
        System.out.println(zhaoLing.GetCoinCount(200));
    }
}
