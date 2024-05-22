package test;

public class LC45 {

    public int jumpCount(int[] nums) {

        // dp[n] 到下标为n的位置需要的最小次数
        int[] dp = new int[nums.length];

        dp[0] = 0;
        for (int i=1;i<dp.length;i++){
            dp[i] = i;
            for (int j=i-1;j>=0;j--){
                if (nums[j]>=i-j){
                    dp[i] = Math.min(dp[i],dp[j]+1);
                }

            }
        }


        return dp[dp.length-1];

    }

}
