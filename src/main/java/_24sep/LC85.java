package _24sep;
import  java.util.*;

public class LC85 {
//    public int maximalRectangle(char[][] matrix) {
//        int m = matrix.length;
//        int n = matrix[0].length;
//        int res = 0;
//        // 0 x方向 1 y方向
//        int[][][] dp = new int[m][n][2];
//        if (matrix[0][0] == '0') {
//            dp[0][0][0] = 0;
//            dp[0][0][1] = 0;
//        } else {
//            dp[0][0][0] = 1;
//            dp[0][0][1] = 1;
//        }
//        // 第一行初始化
//        for (int i = 1; i < n; i++) {
//            // y方向
//            dp[0][i][1] = matrix[0][i] == '0' ? 0 : 1;
//            // x方向
//            if(matrix[0][i] == '0'){
//                dp[0][i][0] = 0;
//            }else{
//                dp[0][i][0] =  dp[0][i - 1][0] + 1;
//            }
//        }
//
//        // 第一列初始化
//        for (int i = 1; i < m; i++) {
//            // y方向
//            if(matrix[i][0] == '0'){
//                dp[i][0][1] = 0;
//            }else{
//                dp[i][0][1] =  dp[i-1][0][1] + 1;
//            }
//            // x方向
//            dp[i][0][0] = matrix[i][0] == '0' ? 0 : 1;
//        }
//
//        for(int i=1;i<m;i++){
//            for(int j=1;j<n;j++){
//                if(matrix[i][j] == '0'){
//                    dp[i][j][0] = 0;
//                    dp[i][j][1] = 0;
//
//                }else{
//                    dp[i][j][0] = Math.min(dp[i][j-1][0]+1,dp[i-1][j][0]);
//                    dp[i][j][1] = Math.min(dp[i][j-1][0],dp[i-1][j][0]+1);
//                }
//
//            }
//        }
//
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                if(dp[i][j][0]*dp[i][j][1] > res){
//                    res = dp[i][j][0]*dp[i][j][1];
//                }
//            }
//        }
//
//        return res;
//    }

    public int maximalRectangle(char[][] matrix) {
        // 通过计算每行中每一列的高度，把问题转换成LC84
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] sum = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == '0'){
                    sum[i][j] = 0;
                }else{
                    if(i-1>=0){
                        sum[i][j] = sum[i-1][j] + 1;
                    }else{
                        sum[i][j] = 1;
                    }
                }
            }
        }
        int max = 0;
        for(int i=0;i<m;i++){
            ArrayDeque<Integer> q = new ArrayDeque<>();
            int[] l = new int[n];
            Arrays.fill(l,-1);
            int[] r = new int[n];
            Arrays.fill(r,n);
            for(int j=0;j<n;j++){
                while(!q.isEmpty() && sum[i][j]<=sum[i][q.getLast()]){
                    q.removeLast();
                }
                if(!q.isEmpty()){
                    l[j] = q.getLast();
                }
                q.addLast(j);
            }
            q.clear();
            for(int j=n-1;j>=0;j--){
                while(!q.isEmpty()&&sum[i][j]<=sum[i][q.getLast()]){
                    q.removeLast();
                }
                if(!q.isEmpty()){
                    r[j] = q.getLast();
                }
                q.addLast(j);
            }
            for(int j=0;j<n;j++){
                int size = (r[j]-l[j]-1)*sum[i][j];
                if(size > max){
                    max = size;
                }
            }


        }
        return max;

    }

    public static void main(String[] args) {

        LC85 lc85 = new LC85();
        char[][] arr = new char[4][5];
        arr[0][0] = '1';
        arr[0][1] = '0';
        arr[0][2] = '1';
        arr[0][3] = '0';
        arr[0][4] = '0';
        arr[1][0] = '1';
        arr[1][1] = '0';
        arr[1][2] = '1';
        arr[1][3] = '1';
        arr[1][4] = '1';
        arr[2][0] = '1';
        arr[2][1] = '1';
        arr[2][2] = '1';
        arr[2][3] = '1';
        arr[2][4] = '1';
        arr[3][0] = '1';
        arr[3][1] = '0';
        arr[3][2] = '0';
        arr[3][3] = '1';
        arr[3][4] = '0';
        lc85.maximalRectangle(arr);
    }
}
