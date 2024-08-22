package _24july;

import java.util.Arrays;

public class LC48 {
    public int fnc(String s1,String s2){
        int[][] dp = new int[s2.length()+1][s1.length()+1];
        Arrays.fill(dp[0],1);
        for(int i=1;i<=s2.length();i++){
            for(int j=1;j<=s1.length();j++){
                if(s2.charAt(i-1) == s1.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+dp[i][j-1];
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        return dp[s2.length()][s1.length()];
    }

    public static void main(String[] args) {
        // 输入：s = "rabbbit", t = "rabbit"
        LC48 lc48 = new LC48();
        lc48.fnc("rabbbit","rabbit");
    }
}
