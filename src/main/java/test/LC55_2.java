package test;

import java.util.Arrays;

/**
 * @Author：Yan Zhaoyang
 * @Package：test
 * @Project：java-acw-lc
 * @name：LC55_2
 * @Date：2024/6/17 13:05
 * @Filename：LC55_2
 * @Desc：
 */
public class LC55_2 {
    // 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
    // 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
    // 输入：nums = [2,3,1,1,4]
    // 输出：true
    // 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        int max = (int)Math.pow(10,9) + 1;
        Arrays.fill(dp,max);
        dp[0] = 0;
        for(int i=1; i<nums.length; i++){
            for(int j=i-1;j>=0;j--){
                if(j+nums[j]>=i){
                    dp[i] = Math.min(dp[i],dp[j]+1);
                }
            }
        }
        if (dp[nums.length-1]!=max) return true;
        else return false;
    }
}
