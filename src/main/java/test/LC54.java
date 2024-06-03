package test;
import java.util.*;

public class LC54 {

    public List<Integer> spiralOrder(int[][] matrix) {

        int l = 0;
        int r = matrix[0].length-1;
        int up = 0;
        int down = matrix.length-1;
        List<Integer> res = new ArrayList<>();
        while(l<=r&&up<=down){
            for(int i=l;i<=r;i++){
                res.add(matrix[up][i]);
            }
            up++;
            for(int i=up;i<=down;i++){
                res.add(matrix[i][r]);
            }
            r--;
            if(up<=down){
                for(int i=r;i>=l;i--){
                    res.add(matrix[down][i]);
                }
            }
            down--;
            if(l<=r){
                for(int i=down;i>=up;i--){
                    res.add(matrix[i][l]);
                }
            }
         
            l++;
        }

        return res;

    }

    public static void main(String[] args) {

        new LC54().spiralOrder(new int[][]{
                new int[]{6,9,7},

        });
    }
}
