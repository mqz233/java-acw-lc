package test;

import java.math.BigDecimal;
import java.util.*;

public class Main {


    public static int minPathSum(int[][] grid) {
        // write code here
        int m = grid.length;
        int n= grid[0].length;
        int[][] dp = new int[m+1][n+1];

        for(int i=0;i<n;i++){
            dp[0][i] = 10001;
        }
        for(int i=0;i<m;i++){
            dp[i][0] = 10001;
        }
        dp[1][1] = grid[0][0];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(i==1 && j==1) continue;
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i-1][j-1];
            }
        }
        return dp[m][n];

    }

    public int wiggleMaxLength(int[] nums) {
        // write code here
        int[][] dp =new int[2][nums.length];
        dp[0][0] = 1;
        dp[1][0] = 1;
        for(int i=1;i<nums.length;i++){
            dp[0][i] = 1;
            dp[1][i] = 1;
            for(int j=0;j<i;j++){
                if(nums[j]>nums[i]){
                    dp[1][i] = Math.max(dp[1][i],dp[0][j]+1);
                }
                if(nums[j]<nums[i]){
                    dp[0][i] = Math.max(dp[0][i],dp[1][j]+1);
                }
            }
        }
        return Math.max(dp[0][nums.length-1],dp[1][nums.length-1]);
    }

    public static void main(String[] args) {
        int[][] grid = new int[3][3];
        grid[0][0] = 1;
        grid[0][1] = 3;
        grid[0][2] = 1;
        grid[1][0] = 1;
        grid[1][1] = 5;
        grid[1][2] = 1;
        grid[2][0] = 4;
        grid[2][1] = 2;
        grid[2][2] = 1;
        minPathSum(grid);
    }


}
