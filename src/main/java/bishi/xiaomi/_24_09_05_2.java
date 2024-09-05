package bishi.xiaomi;

/**
 * @description:
 */

import java.util.Scanner;

public class _24_09_05_2 {
    static int[][] dp;
    static int[] a;
    static int n, x;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        x = scanner.nextInt();
        dp = new int[n][1010];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 1010; j++) {
                dp[i][j] = -1; // 初始化dp数组
            }
        }
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int s = 0;
        for (int num : a) {
            s = (s + num) % x; // 计算数组a的和对x取模
        }
        System.out.println(dfs(0, s));
    }

    public static int dfs(int u, int m) {
        if (u == n) {
            return (x - m) % x; // 递归终止条件
        }
        if (dp[u][m] != -1) {
            return dp[u][m]; // 记忆化搜索
        }
        int res = dfs(u + 1, m); // 不选择当前元素
        res = Math.min(res, dfs(u + 1, (m - a[u] + x) % x) + 1); // 选择当前元素
        dp[u][m] = res; // 存储结果
        return res;
    }
}