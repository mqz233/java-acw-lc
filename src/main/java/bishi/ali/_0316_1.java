package bishi.ali;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

public class _0316_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = 1000010;  // 定义常量 N 为 1000010
        double[] prices = new double[N];  // 定义一个双精度浮点数数组 prices
        double[] endPrices = new double[N];  // 定义一个双精度浮点数数组 endPrices

        int n = input.nextInt();  // 输入商品数量 n
        double k = input.nextDouble();  // 输入购买金额上限 k

        for (int i = 0; i < n; i++) {
            prices[i] = input.nextDouble();  // 输入每个商品的价格
        }

        char[] prices01 = new char[n];
        for (int i = 0; i < n; i++) {
            prices01[i] = input.next().charAt(0);  // 输入每个商品的类型，0 或 1
        }

        for (int i = 0; i < n; i++) {
            if (prices01[i] == '1') {
                endPrices[i] = prices[i] * 0.95;  // 如果商品类型为 1，则打折后的价格为当前价格乘以 0.95
            } else {
                endPrices[i] = prices[i];  // 否则保持原价格不变
            }
        }
        Arrays.sort(endPrices, 0, n);  // 对打折后的商品价格进行排序

        int cnt = 0;
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += endPrices[i];  // 累加商品价格
            if (sum > k) {  // 如果累加价格超过 k，则结束循环
                break;
            }
            cnt++;  // 统计购买的商品数量
        }
        System.out.println(cnt);  // 输出最终购买的商品数量
    }

    @Test
    public void test(){
        Scanner input = new Scanner(System.in);
        int N = 1000010;  // 定义常量 N 为 1000010
        double[] prices = new double[N];  // 定义一个双精度浮点数数组 prices
        double[] endPrices = new double[N];  // 定义一个双精度浮点数数组 endPrices

        int n = input.nextInt();  // 输入商品数量 n
        double k = input.nextDouble();  // 输入购买金额上限 k

        for (int i = 0; i < n; i++) {
            prices[i] = input.nextDouble();  // 输入每个商品的价格
        }

        String off = input.next();
        System.out.println("输出内容："+off);
//        if (input.hasNextLine()){
//            off = input.nextLine();
//            System.out.println("输出内容："+off);
//        }
        
        for (int i = 0; i < n; i++) {
            prices[i] = off.charAt(i) == '1' ? prices[i] * 0.95 : prices[i];
            System.out.println("输出内容："+prices[i]);
        }

        Arrays.sort(prices, 0, n);  // 对打折后的商品价格进行排序

        for (int i = 0; i < n; i++) {
            System.out.println("排序："+prices[i]);
        }

        int cnt = 0;
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += prices[i];  // 累加商品价格
            if (sum > k) {  // 如果累加价格超过 k，则结束循环
                break;
            }
            cnt++;  // 统计购买的商品数量
        }
        System.out.println(cnt);  // 输出最终购买的商品数量
    }

    public void test2(){
        // 不好用动态规划，涉及小数
//        Scanner scanner = new Scanner(System.in);
//        // n种物品
//        int n = scanner.nextInt();
//        // 背包容量k元
//        int k = scanner.nextInt();
//        double[] prices = new double[n];
//        for (int i = 0; i < n; i++) {
//            prices[i] = scanner.nextDouble();
//        }
//        String off = scanner.nextLine();
//        for (int i = 0; i < n; i++) {
//            prices[i] = off.charAt(i) == 1 ? prices[i] * 0.95 : prices[i];
//        }
//        double[] dp = new double[k + 1];
//        // dp[i] 背包载重为i时最大价值
//        // 01背包 单层循环 先物品再背包 背包倒叙
//        for (int i = 0; i < n; i++) {
//            for (int j = k; (double)j > prices[i];j--){
//                dp[j] = Math.max(dp[j],dp[])
//            }
//        }
    }
}
