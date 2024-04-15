package test;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Scanner;

// 岛屿数量：BFS
public class LC_200 {
    public static void main(String[] args) {

    }

    @Test
    public void test1() {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] pos = new int[m][n];


        int island_num = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pos[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (pos[i][j] == 1) {
                    // 维护队列
                    ArrayDeque<int[]> queue = new ArrayDeque<>();
                    // 初始化
                    queue.addLast(new int[]{i, j});
                    pos[i][j] = 0;
                    island_num++;
                    //
                    while (!queue.isEmpty()) {
                        int[] p = queue.removeFirst();
                        // 查看4个方向的pos是否添加过，未添加过的入队
                        if (p[0] - 1 >= 0 && pos[p[0] - 1][p[1]] == 1) {
                            queue.addLast(new int[]{p[0] - 1, p[1]});
                            pos[p[0] - 1][p[1]] = 0;
                        }
                        if (p[1] - 1 >= 0 && pos[p[0]][p[1] - 1] == 1) {
                            queue.addLast(new int[]{p[0], p[1] - 1});
                            pos[p[0]][p[1] - 1] = 0;
                        }
                        if (p[0] + 1 < m && pos[p[0] + 1][p[1]] == 1) {
                            queue.addLast(new int[]{p[0] + 1, p[1]});
                            pos[p[0] + 1][p[1]] = 0;
                        }
                        if (p[1] + 1 < n && pos[p[0]][p[1] + 1] == 1) {
                            queue.addLast(new int[]{p[0], p[1] + 1});
                            pos[p[0]][p[1] + 1] = 0;
                        }
                    }
                }

            }
        }
        System.out.println(island_num);

    }
}
