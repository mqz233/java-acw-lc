package carl.dp;

/**
 * @Author：Yan Zhaoyang
 * @Package：carl.dp
 * @Project：java-acw-lc
 * @name：CompleteBackpack2
 * @Date：2024/3/8 14:25
 * @Filename：CompleteBackpack2
 * @Desc： 组合总和4-完全背包刚好装满，但是要求给出拍列 https://leetcode.cn/problems/combination-sum-iv/description/
 */
public class CompleteBackpack3 {
    public int combinationSum4(int[] nums, int target) {

        // 背包大小
        int size = target;
        // dp[j] 含义完全装满载重为j的背包，有几种排列方式
        // 初始化 dp[0] = 1
        int[] dp = new int[size+1];
        dp[0] = 1;
        // 先背包再物品 求排列，先背包再物品
        for (int j=0;j<=size;j++){
            for (int i=0;i<nums.length;i++){
                // 背包载重要大于物品重量
                if (j>=nums[i]){
                    dp[j] = dp[j] + dp[j-nums[i]];
                    System.out.print(dp[j]);
                }
            }
            System.out.println(" round over");

        }

        return dp[size];

    }

    public static void main(String[] args) {
        CompleteBackpack3 completeBackpack3 = new CompleteBackpack3();
        completeBackpack3.combinationSum4(new int[]{1,2,3},4);
    }
}
