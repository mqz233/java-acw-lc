package test;

import java.util.*;

public class LC416 {
    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum%2 != 0) return false;
        sum = sum/2;
        int[] dp = new int[sum+1];
        dp[0] = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=sum; j>= nums[i]; j--){
                dp[j] = Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }
        return dp[sum] == sum;

    }

}
