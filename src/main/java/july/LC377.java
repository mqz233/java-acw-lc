package july;

import java.util.Arrays;

/**
 * @description:
 */
public class LC377 {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i=1;i<=target;i++){
            for(int j=0;j<nums.length;j++){
                if(i>=nums[j]) dp[i]+=dp[i-nums[j]];
            }
        }

        return dp[target];
    }
}
