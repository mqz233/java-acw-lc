package _24july;

public class LC674_2 {
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 1;
        dp[0] = 1;
        for(int i=1;i<nums.length;i++){
            dp[i] = nums[i]>nums[i-1]?dp[i-1]+1:1;
            if(dp[i]>res) res = dp[i];
        }
        return res;
    }
}
