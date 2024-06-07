package test;

import java.util.*;

public class LC494 {

    public int findTargetSumWays(int[] nums, int target) {

        // [1,1,1,1,1] target = 3
        // 凑X X - (sum-X) = target 2X = sum+target

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum + target) % 2 != 0 || (sum + target) / 2 < 0)
            return 0;
        int x = (sum + target) / 2;
        // dp[0] 最开始就一种方法
        // 01背包，先物品再背包，背包倒叙
        int[] dp = new int[x+1];
        dp[0] = 1;
        for(int i=0; i<nums.length; i++ ){
            for(int j=x;j>=nums[i];j--){
                dp[j]+=dp[j-nums[i]];
            }
        }
        return dp[x];

    }

}
