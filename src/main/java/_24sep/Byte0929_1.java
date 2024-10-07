package _24sep;

import java.util.Arrays;

public class Byte0929_1 {
    public static void main(String[] args) {

//        int n = 5;
//        int[] nums = new int[]{1,2,1,3,2};
        int n = 6;
        int[] nums = new int[]{3,3,2,2,1,1};
        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                dp[i] = Math.min(dp[i-1]+1,dp[i]);
                if(j+nums[j] == i){
                    dp[i] = Math.min(dp[i-1]+1,dp[j]+Math.abs(nums[j]-nums[j+nums[j]]));
                }
            }
        }
        for(int i=0;i<n;i++){
            System.out.println(dp[i]);
        }


    }
}
