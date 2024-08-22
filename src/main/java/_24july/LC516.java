package _24july;
/*
*  给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。

示例 1: 输入: "bbbab" 输出: 4 一个可能的最长回文子序列为 "bbbb"。

示例 2: 输入:"cbbd" 输出: 2 一个可能的最长回文子序列为 "bb"。

提示：

1 <= s.length <= 1000
s 只包含小写英文字母
* */

public class LC516 {
    public int fnc(String str){
        int res = 1;
        int lt = str.length();
        int[][] dp = new int[lt+1][lt+1];
        for(int i=0;i<lt;i++){
            dp[i][i+1] = 1;
        }
        for(int i=0; i<lt-1;i++){
            if(str.charAt(i) == str.charAt(i+1)){
                dp[i][i+2] = 2;
                if(res == 1) res = 2;
            }else{
                dp[i][i+2] = 1;
            }
        }
        for(int i=3;i<=lt;i++){
            for(int j=0;j<lt-i+1;j++){
                int r = j+i;
                if(str.charAt(j) == str.charAt(r-1)){
                    dp[j][r] = dp[j+1][r-1] + 2;
                    if(dp[j][r]>res) res = dp[j][r];
                }else{
                    dp[j][r] = Math.max(dp[j+1][r],dp[j][r-1]);
                }
            }
        }

        return res;
    }
}
