package test;

public class LC376 {
    public int wiggleMaxLength(int[] nums) {
        // 摆动序列 动态规划
        // dp[i][0] i为结尾，同时i是局部最大值的情况,最长子序列的长度
        // dp[i][1] i为结尾，同时i是局部最小值的情况,最长子序列的长度
        // dp[i][0] 接到某个山谷后面 nums[i]>nums[j] Math.max(dp[i][0],dp[j][1]+1)
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for(int i=1;i<nums.length;i++){
            // 把一条横线的情况传递下去
            dp[i][0] = dp[i][1] = 1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i][0] = Math.max(dp[i][0],dp[j][1]+1);
                }
                if(nums[i]<nums[j]){
                    dp[i][1] = Math.max(dp[i][1],dp[j][0]+1);
                }
            }
        }
        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);

    }
}
