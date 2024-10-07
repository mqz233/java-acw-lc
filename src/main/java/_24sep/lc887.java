package _24sep;

public class lc887 {
    public int superEggDrop1(int k, int n) {
        // 背包问题
        // k个鸡蛋 -> k个背包
        // n次操作 -> n个物品
        // 确定的最大楼层为价值
        // 递推 i,count确定的价值，分成两种情况 蛋碎，操作数减一；蛋没碎，操作数减一；本次扔出去可以确定一层
        // dp[i][count] =  dp[i][count] + dp[i-1][count-1] + 1
        int[][] dp = new int[k+1][n+1];
        // int count = 0;
        for(int i=0;i<=n;i++){
            dp[0][i] = 0;
        }
        for(int i=0;i<=k;i++){
            dp[i][0] = 0;
        }
        for(int i=1;i<=n;i++){
            for(int j=k;j>0;j--){
                dp[j][i] = dp[j][i-1]+dp[j-1][i-1]+1;
//                if(dp[j][i]>n){
//                    return i;
//                }
            }

        }
        return -1;

    }

    public int superEggDrop(int k, int n) {
        if(n==1){
            return 1;
        }
        //背包：鸡蛋数（k个）； 物品：操作数（n个）；价值：确定楼层
        int[][] dp = new int[k+1][n+1];

        // 有人问了，为什么不是鸡蛋作为物品，操作数作为背包？
        // 背包问题往往物品与价值有正相关关系。
        // 鸡蛋有k个，但实际不一定全都用上，限制一定的操作数，鸡蛋增加，确定楼层（价值）不一定增加
        // 而取一定的鸡蛋，操作数每增加1，确定楼层(价值)就会一定增加
        int count=0;

        // 先遍历物品，再遍历背包
        for(;dp[k][count]<n;){ // 遍历物品，这里直到价值为n就结束
            count++;
            for (int i = k; i >=1; i--) { // 遍历背包，二维数组可以正序或倒叙
                //当前价值 = 鸡蛋碎了的价值 + 鸡蛋没碎的价值 + 确定当前层的价值1
                dp[i][count] = dp[i-1][count-1]+dp[i][count-1]+1;
            }
        }

        return count;
    }


    public static void main(String[] args) {
        lc887 lc887 = new lc887();
        lc887.superEggDrop1(5,6);
    }
}
