package test;

import java.util.Scanner;

public class MaxSatisfiedCustomers {
    private static int maxSatisfied = 0;
    private static int[] availableDrinks; // 记录每种酒是否可用

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 顾客数量
        int m = scanner.nextInt(); // 酒的编号范围
        int[][] orders = new int[n][2]; // 存储每个顾客的点单

        availableDrinks = new int[m + 1]; // 初始化酒的可用性
        for (int i = 0; i <= m; i++) {
            availableDrinks[i] = 1; // 初始时每种酒都有一份
        }

        for (int i = 0; i < n; i++) {
            orders[i][0] = scanner.nextInt();
            orders[i][1] = scanner.nextInt();
        }

        backtrack(0, 0, orders, n, m);

        System.out.println(maxSatisfied);
    }

    // 回溯函数
    private static void backtrack(int index, int satisfied, int[][] orders, int n, int m) {
        if (index == n) { // 所有顾客都考虑过
            maxSatisfied = Math.max(maxSatisfied, satisfied); // 更新最大满意顾客数
            return;
        }

        // 尝试满足当前顾客
        int[] customerOrders = orders[index];
        if (availableDrinks[customerOrders[0]] > 0 && availableDrinks[customerOrders[1]] > 0) {
            // 如果两种酒都有，满足顾客
            availableDrinks[customerOrders[0]]--;
            availableDrinks[customerOrders[1]]--;
            backtrack(index + 1, satisfied + 1, orders, n, m);
            availableDrinks[customerOrders[0]]++; // 回溯恢复状态
            availableDrinks[customerOrders[1]]++;
        }

        // 不满足当前顾客，继续尝试下一个
        backtrack(index + 1, satisfied, orders, n, m);
    }
}
