package test;
import java.util.*;

public class LC54 {

    public List<Integer> spiralOrder(int[][] matrix) {

        // matrix m代表行
        int m = matrix.length;
        // n代表列
        int n = matrix[0].length;

        List<Integer> res =  new ArrayList<Integer>();
        // p = 0 代表行
        // q = 0 代表列
        // i代表行
        // j代表列

        // 1/4 i= p j=q j< n-1-q; j++
        // 2/4 j= n-1-q; i=p i<m-1-p; i++
        // 3/4 i= m-1-p; j=n-1-q; j>q; j--;
        // 4/4 j=q; i=m-1-p; i>p; i--

        // p++; j++;
        //if (p>m/2) break;

        int p=0;
        int q=0;

        while (true){

            for (int j=q;j<n-1-q;j++){
                res.add(matrix[p][j]);
            }
            for (int i=p;i<m-1-p;i++){
                res.add(matrix[i][n-1-q]);
            }
            for (int j=n-1-q;j>q;j--){
                res.add(matrix[m-1-p][j]);
            }
            for (int i=m-1-p;i>p;i--){
                res.add(matrix[i][q]);
            }

            p++;
            q++;

            if (p>m/2){
                break;
            }

        }

        return res;

    }

    public static void main(String[] args) {

        new LC54().spiralOrder(new int[][]{
                new int[]{1,2,3},
                new int[]{4,5,6},
                new int[]{7,8,9},

        });
    }
}
