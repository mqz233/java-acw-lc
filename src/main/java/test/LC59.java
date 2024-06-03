package test;

public class LC59 {

    public int[][] generateMatrix(int n) {

        int[][] res = new int[n][n];
        int l = 0;
        int r = n - 1;
        int up = 0;
        int down = n - 1;
        int count = 0;
        while (l <= r) {
            for (int i = l; i <= r; i++) {
                res[up][i] = ++count;
            }
            up++;
            for (int i = up; i <= down; i++) {
                res[i][r] = ++count;
            }
            r--;
            if (up <= down) {
                for (int i = r; i >= l; i--) {
                    res[down][i] = ++count;
                }
            }
            down--;
            if (l <= r) {
                for (int i = down; i >= up; i--) {
                    res[i][l] = ++count;
                }
            }
            l++;
        }
        return res;

    }

}
