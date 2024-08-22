package _24aug;
import java.util.*;

public class LC54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int up = 0;
        int down = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        List<Integer> res = new ArrayList<>();
        while(up<=down&&left<=right){
            for(int i=left;i<=right;i++){
                res.add(matrix[up][i]);
            }
            up++;
            if(up>down) break;
            for(int i=up;i<=down;i++){
                res.add(matrix[i][right]);
            }
            right--;
            if(left>right) break;
            for(int i=right;i>=left;i--){
                res.add(matrix[down][i]);
            }
            down--;
            if(up>down) break;
            for(int i=down;i>=up;i--){
                res.add(matrix[i][left]);
            }
            left++;
        }
        return res;
    }
}
