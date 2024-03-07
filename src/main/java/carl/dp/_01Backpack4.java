package carl.dp;

import java.util.Arrays;

public class _01Backpack4 {

    public int findTargetSumWays(int[] nums, int target) {
        // nums = [1,1,1,1,1], target = 3
        // output:5
        // 分为正数组x和负数组y x+y = sum; x-y=target; x= (sum+target)/2
        // dp[j]含义 填满j的组合数
        // 递推公式: dp[j] = 上一层dp[j](不选nums[i])+dp[j-nums[i]](选nums[i])
        // 初始化 dp[0]=1 其他为0
        // 顺序:01背包单层版本


        int sum = Arrays.stream(nums).sum();
        if (sum<Math.abs(target)){
            return 0;
        }
        int size = (sum+target)/2;
        if ((sum+target)%2==1){
            return 0;
        }
        int[] dp = new int[size+1];
        dp[0] = 1;
        for (int i=0;i< nums.length;i++){
            for (int j=size;j>=nums[i];j--){
                dp[j] = dp[j]+dp[j-nums[i]];
            }
        }

        return dp[size];

    }
    public static void main(String[] args) {
        // https://leetcode.cn/problems/target-sum/目标和
    }
}
