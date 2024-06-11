package test;

import java.util.*;

public class LC377 {
    public int combinationSum4(int[] nums, int target) {

        // 求排列
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 1; j <= target; j++)
            for (int i = 0; i < nums.length; i++) {
                if(j>=nums[i]) dp[j] += dp[j-nums[i]];
            }

        return dp[target];

    }
}
