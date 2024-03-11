package carl.mstack;

import java.util.ArrayDeque;

// 单调栈 https://leetcode.cn/problems/daily-temperatures/description/
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {

        ArrayDeque<Integer> mstack = new ArrayDeque<>();

        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {

            // 栈元素不为空,当前温度比栈顶元素高,栈顶元素持续出栈
            while (!mstack.isEmpty() && temperatures[i] > temperatures[mstack.getFirst()]  ) {
                int tmp = mstack.removeFirst();
                result[tmp] = i - tmp;
            }
            mstack.addFirst(i);

        }

        return result;
    }
}
