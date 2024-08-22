package _24july;

public class LC53 {
    public int fnc(int[] nums){
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for(int i=1;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            if(dp[i]>res) res = dp[i];
        }
        return res;
    }
}
