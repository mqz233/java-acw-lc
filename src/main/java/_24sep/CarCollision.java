package _24sep;

import java.util.Scanner;

public class CarCollision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of cars
        int n = scanner.nextInt();
        int[][] cars = new int[n][2];

        // Read positions and velocities
        for (int i = 0; i < n; i++) {
            cars[i][0] = scanner.nextInt(); // position xi
            cars[i][1] = scanner.nextInt(); // velocity vi
        }

        // Sort cars by their positions to process them in order
        java.util.Arrays.sort(cars, (a, b) -> Integer.compare(a[0], b[0]));

        // Calculate minimum cars to remove
        int minRemovals = minCarsToRemove(cars);

        // Output result
        System.out.println(minRemovals);
    }

    private static int minCarsToRemove(int[][] cars) {
        int count = 0;
        int[] dp = new int[cars.length];

        // Separate cars by direction and apply non-decreasing speed condition
        int[] pos = new int[cars.length];
        int posLen = 0;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i][1] > 0) { // Only consider cars moving right
                pos[posLen++] = i;
            }
        }

        for (int i = 0; i < posLen; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (cars[pos[i]][1] >= cars[pos[j]][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            count = Math.max(count, dp[i]);
        }

        return cars.length - count;
    }
}