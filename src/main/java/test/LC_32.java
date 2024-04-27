package test;

import java.util.Stack;

public class LC_32 {
    public int longestValidParentheses(String s) {


        int start = 0;
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                // stack 为空说明单个)，从下个index开始找
                if (stack.isEmpty()) {
                    start = i+1;
                    continue;
                } else {
                    // 匹配成功出栈
                    stack.pop();
                    // 尝试更新最大值
                    if (stack.isEmpty()){
                        // stack为空，start开始的全部的左括号匹配完了
                        max = Math.max(max,i-start+1);
                    }else {
                        // 此时字串长度为 i-stack.peek()
                        max = Math.max(max,i-stack.peek());
                    }

                }

            }
        }


        return max;

    }

}
