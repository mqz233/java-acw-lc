package carl.array;

public class GenerateMatrix {
    public static void main(String[] args) {

        new GenerateMatrix().generateMatrix(1);

    }

    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int count = 1;
        for (int i = 0; i <= n / 2; i++) {
            for (int j = 0 + i; j < n - i; j++) {
                ans[i][j] = count++;
            }
            for (int j = i + 1; j < n - i; j++) {
                ans[j][n - i - 1] = count++;
            }
            for (int j = n - i - 2; j >= 0 + i; j--) {
                ans[n - i - 1][j] = count++;
            }
            for (int j = n - i - 2; j > 0 + i; j--) {
                ans[j][i] = count++;

            }
        }

        return ans;

    }
}
