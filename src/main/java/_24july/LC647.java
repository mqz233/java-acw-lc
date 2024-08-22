package _24july;

public class LC647 {
    public int fnc(String s){
        int length = s.length();
        int res = 0;
        boolean[][] dp = new boolean[length+1][length+1];
        for(int i=0;i<length;i++){
            dp[i][i+1] = true;
            res++;
        }
        for(int i=0;i<length-1;i++){
           if(s.charAt(i) == s.charAt(i+1)) {
               dp[i][i+2] = true;
               res++;
           }

        }
        for(int i=3;i<=length;i++){
            for(int j=0;j<length-i+1;j++){
                int l = j;
                int r = j+i;
                if(dp[l+1][r-1]&&s.charAt(l) == s.charAt(r-1)){
                    dp[l][r] = true;
                    res++;
                }
            }
        }
        return res;

    }
}
