package test;

public class LCR131 {
    public int cuttingBamboo(int bamboo_len) {

        if (bamboo_len==1){
            return 1;
        }
        if (bamboo_len==2){
            return 1;
        }
        if (bamboo_len==3){
            return 2;
        }

        int[] dp = new int[bamboo_len+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i=4;i<=bamboo_len;i++){
            for (int j=i-1;j>=i/2;j--){
                dp[i] = Math.max(dp[i],dp[i-j]*dp[j]);
            }
        }

        return dp[bamboo_len];
    }
}
