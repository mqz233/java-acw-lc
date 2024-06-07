package test;
import java.util.*;

public class LC516 {

    public int longestPalindromeSubseq(String s) {

        //dp[i][j] 起点为i终点为j的字串最长回文子序列长度
        //最长子序列的思路 s[i] == s[j] dp[i][j] =  dp[i+1]dp[j-1]+2
        // 否则dp[i][j] = max dp[i][j-1] dp[i+1][j]

        int[][] dp = new int[s.length()][s.length()];
        for(int i=0; i<s.length(); i++){
            dp[i][i] = 1;
        }
        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = 2;
            }else{
                dp[i][i+1] = 1;
            }
        }
        // 长度为3开始找
        for(int length=3;length<=s.length();length++){
            for(int i=0;i<s.length();i++){
                int j = i+length-1;
                if(j>=s.length()) break;
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][i+length-2] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
                }
            }
        }

        return dp[0][s.length()-1];


    }
    
}
