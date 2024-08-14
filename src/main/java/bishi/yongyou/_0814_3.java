package bishi.yongyou;

import java.util.*;

/**
 * @description:
 */
public class _0814_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int startFuel = sc.nextInt();
        sc.nextLine();
        ArrayList<int[]> arr = new ArrayList<>();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if(s.isEmpty()) break;
            String[] split = s.split(",");
            arr.add(new int[]{Integer.parseInt(split[0]), Integer.parseInt(split[1])});
        }

        int n = arr.size();
        long[] dp = new long[n + 1];
        dp[0] = startFuel;
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (dp[j] >= arr.get(i)[0]) {
                    dp[j + 1] = Math.max(dp[j + 1], dp[j] + arr.get(i)[1]);
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            if (dp[i] >= target) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}
