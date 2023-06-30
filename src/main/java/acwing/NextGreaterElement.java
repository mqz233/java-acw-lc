package acwing;

import java.util.*;

public class NextGreaterElement {

    //https://leetcode.cn/problems/next-greater-element-i/

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new NextGreaterElement().nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        // 创建map用来存储结某个元素对应的“下一个更大元素”
        Map<Integer, Integer> map = new HashMap<>();

        // 创建栈用来构建单调栈
        Deque<Integer> stack = new ArrayDeque<>();

        // 用来储存结果
        int[] res = new int[nums1.length];

        // 找右边最大，数组逆序入栈
        for (int i = nums2.length - 1; i >= 0; i--) {

            // eg. [1, 4, 2, 3]，添加到4时，此时栈内是[3,2]，4大于2，2出栈；4大于3，3出栈，
            // 栈为空，说明此处应该返回-1

            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], stack.peek());
            }

            stack.push(nums2[i]);

        }

        // 输出元素对应的“下一个更大元素”
        for (int j = 0; j < nums1.length; j++) {
            res[j] = map.get(nums1[j]);
        }

        return res;

    }
}
