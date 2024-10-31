package _24oct;

import java.util.Scanner;

public class MHY1019_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long mod = 1000000007;
        long sum1 = 0;
        long sum2 = 0;

        for (int i = 1; i <= n; i++) {
            sum1 += (long) i * i * (i - 1);
            sum1 %= mod;

            if (i > 1) {
                long term = (long) (i - 1) * i * (2 * i - 1) / 6;
                sum2 += term;
                sum2 %= mod;
            }
        }

        long result = (sum1 - sum2 + mod) % mod;
        System.out.println(result);
    }

}