package test;
import java.util.*;

public class LC63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0;

        int[][] dp = new int[m+1][n+1];
        dp[1][1] = 1;
        for(int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                if(i-1>=1 && obstacleGrid[i-2][j-1]!=1) dp[i][j]+= dp[i-1][j];
                if(j-1>=1 && obstacleGrid[i-1][j-2]!=1) dp[i][j]+= dp[i][j-1];
            }
        }

        return dp[m][n];

 


    }
    
}
