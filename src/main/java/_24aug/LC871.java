package _24aug;

/**
 * @description: 汽车从起点出发驶向目的地，该目的地位于出发位置东面 target 英里处。
 *
 * 沿途有加油站，用数组 stations 表示。其中 stations[i] = [positioni, fueli] 表示第 i 个加油站位于出发位置东面 positioni 英里处，并且有 fueli 升汽油。
 *
 * 假设汽车油箱的容量是无限的，其中最初有 startFuel 升燃料。它每行驶 1 英里就会用掉 1 升汽油。当汽车到达加油站时，它可能停下来加油，将所有汽油从加油站转移到汽车中。
 *
 * 为了到达目的地，汽车所必要的最低加油次数是多少？如果无法到达目的地，则返回 -1 。
 *
 * 注意：如果汽车到达加油站时剩余燃料为 0，它仍然可以在那里加油。如果汽车到达目的地时剩余燃料为 0，仍然认为它已经到达目的地。
 *
 *
 *
 * 示例 1：
 *
 * 输入：target = 1, startFuel = 1, stations = []
 * 输出：0
 * 解释：可以在不加油的情况下到达目的地。
 * 示例 2：
 *
 * 输入：target = 100, startFuel = 1, stations = [[10,100]]
 * 输出：-1
 * 解释：无法抵达目的地，甚至无法到达第一个加油站。
 * 示例 3：
 *
 * 输入：target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
 * 输出：2
 * 解释：
 * 出发时有 10 升燃料。
 * 开车来到距起点 10 英里处的加油站，消耗 10 升燃料。将汽油从 0 升加到 60 升。
 * 然后，从 10 英里处的加油站开到 60 英里处的加油站（消耗 50 升燃料），
 * 并将汽油从 10 升加到 50 升。然后开车抵达目的地。
 * 沿途在两个加油站停靠，所以返回 2 。
 *
 */
public class LC871 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        // dp[i] 加油i次所能到达的最大距离
        // dp[i] = dp[j]
        int[] dp = new int[stations.length+1];
        dp[0] = startFuel;
        for(int i=0;i<stations.length;i++){
            // 现在到达station[2]
            // 那么我可能从起点直接过来的，可能从station[0]或者station[1]过来的
            // 前提加0,1,2次油能够过来
            // 加3次油更新 = 加2次油+站点油值 dp[3] = Math.max(dp[3],dp[2]+station[3])
            // 加两次油更新 = 加一次油

            // 尝试更新站点dp[0] - dp[j]?
            // target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
            for( int j=i;j>=0;j--){
                // 注意遍历顺序
                // 加4次油是从加3次油得到的
                // 所以不能由加3次油并且经过station[3]得到 加4次油并经过station[3]
                // 只能由不经过station[3]的加3次油得到 加4次油并经过station[3]
                // 否则就矛盾了加3次油经过station[3]，加4次油就没站可用了，计算出来的值也是错误的。
//            for( int j=0;j<=i;j++){
                // 加j次油能够到达当前加油站
               if(dp[j]>=stations[i][0]){
                   // 尝试更新当前加j+1次油，而且通过本加油站能到达的最大距离
                   dp[j+1] = Math.max(dp[j+1],dp[j]+stations[i][1]);
               }
            }

            for(int k=0; k<dp.length;k++){
                System.out.print(dp[k]);
                System.out.print(" ");
            }
            System.out.println();
        }
        for(int i=0; i<dp.length;i++){
            if(dp[i]>=target){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LC871 lc871 = new LC871();
        int[][] nums = new int[4][2];
        nums[0] = new int[]{10,60};
        nums[1] = new int[]{20,30};
        nums[2] = new int[]{30,30};
        nums[3] = new int[]{60,40};
        lc871.minRefuelStops(100,10,nums);
    }
}
