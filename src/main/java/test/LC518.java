package test;

public class LC518 {

    public int change(int amount, int[] coins) {

        // [1,2,5] 凑成5，一共有几种方案
        // dp[j] 凑成j共有几种方案
        // dp[j] += dp[j-coins[i]]

        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int i=0; i<coins.length; i++){
            for(int j=coins[i];j<=amount;j++){
                dp[j] += dp[j-coins[i]];
                // System.out.println(""+j+" "+dp[j]);
            }
        }
        
        return dp[amount];

        

    }

    public static void main(String[] args) {
        new LC518().change(5, new int[]{1,2,5});
    }
    
}
