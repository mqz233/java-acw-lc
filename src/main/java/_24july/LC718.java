package _24july;

/**
 * @description: 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 * 示例：
 *
 * 输入：
 *
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：长度最长的公共子数组是 [3, 2, 1] 。
 * 提示：
 *
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 */
public class LC718 {
    public int fnc(int[] nums1,int[] nums2){
        int max = 0;
        // dp[i][j] 以nums1[i-1]为结尾,nums2[j-1]为结尾的最长公共子数组长度
        int[][] dp = new int[nums1.length+1][nums1.length+1];
        for(int i=1;i<=nums1.length;i++){
            for(int j=1; j<=nums2.length;j++){
                if(nums1[i-1] == nums2[j-1]) dp[i][j] = dp[i-1][j-1]+1;
                else dp[i][j] = 0;
                if(dp[i][j]>max) max = dp[i][j];
            }
        }

        return max;
    }
}
