package _24aug;

public class LC74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = m*n-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(matrix[mid/n][mid%n]<=target){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }

        if(r!=-1&&matrix[r/n][r%n] ==  target){
            return true;
        }

        return false;

    }
}
