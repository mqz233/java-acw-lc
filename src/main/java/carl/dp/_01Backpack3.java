package carl.dp;

public class _01Backpack3 {
    public static void main(String[] args) {
        // https://leetcode.cn/problems/partition-equal-subset-sum/
//        Scanner scanner = new Scanner(System.in);
        // 物品种类M 背包容量N
//        int M = scanner.nextInt();
//        int N = scanner.nextInt();
//        int[] weights = new int[M];
//        int[] values = new int[M];
        int M = 4;
        int N = 11;
        int[] weights = new int[]{1,5,11,5};
        int[] values = new int[]{1,5,11,5};
        // 每个物品载重
//        for (int i=0;i<M;i++){
//            weights[i] = scanner.nextInt();
//        }
        // 每个物品价值
//        for (int i=0;i<M;i++){
//            values[i] = scanner.nextInt();
//        }
        // 初始化DP,啥都不放,价值为0
        int[] dp = new int[N+1];
        // dp[j]含义 载重为j的背包,放物品的最大价值
        // 递推公式 dp[j] = Math.max(dp[j],dp[j-weights[i]]+values[i])
        // 遍历顺序 先物品再背包,背包载重逆序
        for (int i=0; i<M;i++)
        {
            System.out.println();
            System.out.println(new StringBuilder("放第").append(i+1).append("个物品").toString());
            for (int j=N;j>=weights[i];j--){
                dp[j] = Math.max(dp[j],dp[j-weights[i]]+values[i]);
                System.out.print(new StringBuilder(j).append(" ").append(dp[j]).toString());
            }
        }
        System.out.println();
        System.out.println(dp[N]);
    }

}
