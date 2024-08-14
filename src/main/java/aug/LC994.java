package aug;

import java.util.*;

/**
 * @description: 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 *
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 *
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * 示例 2：
 *
 * 输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个方向上。
 * 示例 3：
 *
 * 输入：grid = [[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 */
public class LC994 {

    public int orangesRotting(int[][] grid) {
        // direction
        int[][] dirs = new int[2][4];
        dirs[0] = new int[]{1,-1,0,0};
        dirs[1] = new int[]{0,0,1,-1};
        int m = grid.length;
        int n = grid[0].length;
        // 广度搜索
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n;j++){
                if(grid[i][j] == 2){
                    q.addLast(new int[]{i,j});
                }
            }
        }

        // 计算需要的分钟数
        int curMin = 0;
        while(!q.isEmpty()){
            // 当前队列大小
            int size = q.size();
            // 计算这一分钟有多少橘子被腐烂
            int count = 0;
            for(int i=0;i<size;i++){
                int[] arr1 = q.removeFirst();
                int x1 = arr1[0];
                int y1 = arr1[1];
                // 腐化4个方向的橘子
                for(int j=0; j<4;j++){
                    int x2 = x1 + dirs[0][j];
                    int y2 = y1 + dirs[1][j];
                    if(x2>=0&&x2<m&&y2>=0&&y2<n&&grid[x2][y2] == 1){
                        count++;
                        grid[x2][y2] = 2;
                        q.addLast(new int[]{x2,y2});
                    }
                }
            }
            // 腐化成功，那么分钟数+1
            if(count>0) curMin++;

        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n;j++){
                if(grid[i][j] == 1){
                    // 不能全部腐化
                    return -1;
                }
            }
        }

        return curMin;
    }
}
