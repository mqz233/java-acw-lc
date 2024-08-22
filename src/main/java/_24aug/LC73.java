package _24aug;

public class LC73 {
    public void fnc(int[][] matrix){
        int[] m = new int[matrix.length];
        int[] n = new int[matrix[0].length];
        for(int i=0; i<m.length;i++){
            for(int j=0; j<n.length;j++){
                if(matrix[i][j] == 0){
                    m[i] = 1;
                    n[j] = 1;
                }
            }
        }

        for(int i=0; i<m.length;i++){
            if(m[i] == 1){
                for(int j=0;j<n.length;j++){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int i=0; i<n.length;i++){
            if(n[i] == 1){
                for(int j=0;j<m.length;j++){
                    matrix[j][i] = 0;
                }
            }
        }
    }
}
