package test;
import java.util.*;

public class LC55 {
    public boolean canJump(int[] nums) {

        if (nums[0]==0&&nums.length>1){
            return false;
        }

        // dp[n] 到下标为n的位置需要的最小次数
        int[] dp = new int[nums.length];

        dp[0] = 1;
        for (int i=1;i<dp.length;i++){
            for (int j=i-1;j>=0;j--){
                if (nums[j]>=i-j&&dp[j]==1){
                    dp[i] = 1;
                }

            }
        }


        return dp[dp.length-1]==1;

    }

    public boolean canJump2(int[] nums) {


        // 贪心
        int rightmost = 0;
        for (int i=0; i<nums.length;i++){
            if (i<=rightmost){
                rightmost = Math.max(rightmost,nums[i]+i);
                if (rightmost>=nums.length-1){
                    return true;
                }
            }

        }

        return false;

    }

}
