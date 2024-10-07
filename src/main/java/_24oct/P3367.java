package _24oct;

import java.util.*;

public class P3367 {
    // 并查集 https://www.luogu.com.cn/problem/P3367
    // 实现find
    // 实现union
    public static int[] arr;

    public static int find(int x) {

        if (arr[x] != x) {
            // 扁平化操作
            arr[x] = find(arr[x]);
            return arr[x];
            // 非扁平化操作
//            return find(arr[x]);
        }
        return x;
    }

    public static void union(int x, int y) {
        int xf = find(x);
        int yf = find(y);
        if (xf == yf) return;
        arr[xf] = yf;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        arr = new int[n + 1];
        // 初始化父节点为自己
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int z = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (z == 1) {
                union(x, y);
            } else {
                int vx = find(x);
                int vy = find(y);
                System.out.println(vx==vy?"Y":"N");
            }
        }

    }
}
