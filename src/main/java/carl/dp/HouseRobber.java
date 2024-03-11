package carl.dp;

// https://leetcode.cn/problems/house-robber/description/ 打家劫舍1
public class HouseRobber {

    public int rob(int[] nums) {
        // dp[i]含义 考虑下标i（包括i）以内的房屋，最多可以偷窃的金额为dp[i]。
        if (nums.length == 1){
            return nums[0];
        }
        // 初始化
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        // 递推公式dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]),偷这间,那么前一间就不能偷了
        for (int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[nums.length-1];

    }

}
