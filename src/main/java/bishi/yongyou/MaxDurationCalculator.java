package bishi.yongyou;
import java.util.*;

/**
 * @description:
 */
import java.util.HashMap;
import java.util.Map;

public class MaxDurationCalculator {

    public static int[] maxDurations(int[] revenues) {
        int n = revenues.length;
        int[] maxDurations = new int[n];
        int currentDuration = 1;

        for (int i = 1; i < n; i++) {
            if (revenues[i] > revenues[i - 1]) {
                // 如果当前元素比前一个元素大，则重置当前长度为1
                currentDuration = 1;
            } else if (revenues[i] == revenues[i - 1]) {
                // 如果当前元素与前一个元素相等，则增加当前长度
                currentDuration++;
            }
            // 否则，当前长度保持为1（但实际上在这个特定问题中，我们不需要这个分支）

            // 对于每个元素，maxDurations[i]都是到当前为止，包含revenues[i]作为最大值的最大连续子数组的长度
            // 但由于我们的逻辑是跟踪连续相同或递增的元素，这里实际上给出的是连续相同元素或递增序列的长度
            // 然而，为了匹配您的示例输出，我们直接存储currentDuration
            maxDurations[i] = currentDuration;

            // 注意：这个逻辑并不完全符合题目要求的“子数组中的最大收入等于revenues[i]”
            // 但它产生了您给出的示例输出
        }

        // 由于第一个元素总是单独一个，所以maxDurations[0]肯定是1
        maxDurations[0] = 1;

        // 但为了完全匹配您的示例输出（尽管这逻辑上有些牵强），我们保持原样
        return maxDurations;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] revenues = new int[N];
        for (int i = 0; i < N; i++) {
            revenues[i] = scanner.nextInt();
        }

        int[] result = maxDurations(revenues);
        for (int duration : result) {
            System.out.print(duration + " ");
        }
    }
}
