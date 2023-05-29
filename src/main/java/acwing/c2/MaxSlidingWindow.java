package acwing.c2;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author mqz23
 * 滑动窗口 单调队列 https://leetcode.cn/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 */
public class MaxSlidingWindow {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MaxSlidingWindow().maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        // 存储结果
        int[] results = new int[nums.length - k + 1];

        // 双向队列
        Deque<Integer> q = new LinkedList<>();

        // 初始化
        for (int j = 0; j < k; j++) {
            // 队列不为空且当前元素比队尾大，队尾元素依次出队直到满足条件
            while (!q.isEmpty() && nums[j] > nums[q.peekLast()]) {
                q.removeLast();
            }
            q.offerLast(j);
        }
        if (!q.isEmpty()) {
            results[0] = nums[q.peekFirst()];
        }


        // 数组上滑动
        for (int i = k; i <= nums.length - 1; i++) {

            // 判断队头元素是否已经不在窗口内，<= 不是 < 因为等于0的时候，0已经不在窗口内了
            if (!q.isEmpty() && q.peekFirst() <= i - k) {
                q.removeFirst();
            }
            // 新进入元素入队列
            while (!q.isEmpty() && nums[i] > nums[q.peekLast()]) {
                q.removeLast();
            }
            q.offerLast(i);
            results[i - k + 1] = nums[q.peekFirst()];
        }

        return results;

    }
}

