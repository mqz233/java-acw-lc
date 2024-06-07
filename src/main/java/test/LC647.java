package test;
import java.util.*;

public class LC647 {
    /*
     *  输入：s = "abc"
        输出：3
        解释：三个回文子串: "a", "b", "c"
     */
    public int countSubstrings(String s) {

        int length = s.length();
        int res = 0;

        //dp[i][j] i起始j结束的字符串是否是回文串
        boolean[][] dp = new boolean[length][length];
        for(int i=0; i<length; i++){
            dp[i][i] = true;
            res++;
        }
        for(int i=0; i<length-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                res++;
            }
        }
        for(int i=3;i<=length;i++){
            for(int l=0; l<length; l++){
                int r = l+i-1;
                if(r>=length) break;
                if(dp[l+1][r-1]&&s.charAt(l) == s.charAt(r)){
                    dp[l][r] = true;
                    res++;
                }else{
                    dp[l][r] = false;
                }
            }
            
        }

        return res;

    }
    
}
