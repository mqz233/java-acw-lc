package test;

public class LC53_2 {
    public int maxSubArray(int[] nums) {
        // [-2,1,-3,4,-1,2,1,-5,4]
        // 连续子数组 [4,-1,2,1] 的和最大，为 6 。

        // 以某个数为结尾的作为状态
        // dp[0] = -2
        // dp[1] = Integer.max(dp[i-1]+dp[i],dp[i]

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];

        for (int i=1;i<nums.length;i++){
            dp[i] = Integer.max(dp[i-1]+nums[i],nums[i]);
            if (dp[i]>max){
                max = dp[i];
            }
        }

        return max;


    }
}
