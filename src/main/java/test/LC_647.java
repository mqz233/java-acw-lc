package test;

public class LC_647 {
    public int countSubstrings(String s) {

        // count
        int count = 0;
        // dp[i][j] i-j之间是否为回文串
        int size = s.length();
        int[][] dp = new int[size][size];

        // length==1
        for (int i=0;i<size;i++){
            dp[i][i] = 1;
            count++;
        }
        // length==2
        for (int i=0;i<size-1;i++){
            if (s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = 1;
                count++;
            }
        }
        // length>=3
        for (int i=3;i<=size;i++){
            for (int j=0;j<size-i+1;j++){
                if (s.charAt(j)==s.charAt(j+i-1)&&dp[j+1][j+i-2]==1){
                    dp[j][j+i-1] = 1;
                    count++;
                }
            }
        }
        return count;

    }
}
