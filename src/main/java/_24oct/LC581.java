package _24oct;

import java.util.*;


public class LC581 {

    // 单调栈左边的要求非严格递增
    // 左边从0开始，第一个非连续的就是起点
    // 右边的要求非严格递减，同理
    // 1，3，2，2，2
    // 2,6,4,8,10,9,15
    public int findUnsortedSubarray1(int[] nums) {
        ArrayDeque<Integer> q1 = new ArrayDeque<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (!q1.isEmpty() && nums[i] < nums[q1.getLast()]) {
                q1.removeLast();
            }
            q1.addLast(i);
        }
        int l = 0;
        while (!q1.isEmpty() && q1.removeFirst() == l) {
            l++;
        }

        ArrayDeque<Integer> q2 = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!q2.isEmpty() && nums[i] > nums[q2.getLast()]) {
                q2.removeLast();
            }
            q2.addLast(i);
        }
        int r = n - 1;
        while (!q2.isEmpty() && q2.removeFirst() == r) {
            r--;
        }

        if (r > l) {
            return r - l + 1;
        } else {
            return 0;
        }


    }


    public static void main(String[] args) {
        int[] ints = {1,3,2,2,2};
        LC581 lc581 = new LC581();
        lc581.findUnsortedSubarray1(ints);

    }
}

