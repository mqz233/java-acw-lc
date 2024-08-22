package _24aug;

public class LC240 {

    public boolean fnc(int[][] matrix, int target, int s1, int s2) {
        if (target < matrix[s1][s2]) {
            return false;
        } else if (target == matrix[s1][s2]) {
            return true;
        } else {
            if (s1 + 1 < matrix.length && s2 + 1 < matrix[0].length && target >= matrix[s1 + 1][s2 + 1]) {
                return fnc(matrix, target, s1 + 1, s2 + 1);
            }
            boolean right = false;
            boolean down = false;
            if (s1 + 1 < matrix.length) {
                right = fnc(matrix, target, s1 + 1, s2);
            }
            if (right) return true;
            if (s2 + 1 < matrix[0].length) {
                down = fnc(matrix, target, s1, s2 + 1);
            }
            return down;
        }
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        return fnc(matrix, target, 0, 0);
    }
}
