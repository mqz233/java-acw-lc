package aug;
import java.util.*;

public class LC48 {
    public void rotate(int[][] matrix) {
        int up = 0;
        int down = matrix.length-1;
        int left = 0;
        int right = matrix.length-1;
        while(up<down&&left<right){
            for(int i=0; i<down-up;i++) {
                int tmp = matrix[down - i][left];
                matrix[down - i][left] = matrix[down][right - i];
                matrix[down][right - i] = matrix[up + i][right];
                matrix[up + i][right] = matrix[up][left + i];
                matrix[up][left + i] = tmp;
            }
            up++;
            down--;
            left++;
            right--;
        }
    }
}
