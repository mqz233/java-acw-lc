package _24july;

public class LC718_2 {
    public int fnc(int[] nums1,int[] nums2){
        int res = 0;
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        for(int i=1;i<=nums1.length;i++){
            for(int j=1;j<=nums2.length;j++){
                if(nums2[j-1] == nums1[i-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                    if(dp[i][j]>res) res = dp[i][j];
                }
            }
        }
        return res;
    }
}
