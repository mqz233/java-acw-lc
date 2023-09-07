package carl.deque;

import java.util.LinkedList;
import java.util.Deque;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 自定义双端队列
        // 入队元素大于队头元素，剩余元素全部弹出。
        // 入队元素小于队头元素，则与队尾元素比较，直到入队元素小于队尾元素，保持单调性。
        // 出队元素小于对头元素，不出队。出队元素等于队头元素，出队。
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length-k+1];

        // 开始滑动
        for (int i = 0; i < nums.length; i++) {
            // 出队
            if (i>=k&&nums[i-k] == deque.peek()){
                deque.poll();
            }
            //入队
            if (deque.isEmpty()){
                deque.offer(nums[i]);
            }
            // 删除队尾元素，保持单调性 （和队头元素相等时，也要插入）
            else if (nums[i]<= deque.peek()){
                while (nums[i]> deque.getLast()){
                    deque.pollLast();
                }
                deque.offer(nums[i]);
            }
            else {
                deque.clear();
                deque.offer(nums[i]);
            }
            if (i>=k-1){
                result[i-k+1] = deque.peek();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        new MaxSlidingWindow().maxSlidingWindow(new int[]{-7,-8,7,5,7,1,6,0},3);
    }
}
