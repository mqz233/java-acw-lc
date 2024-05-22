package test;

import java.util.Stack;

public class LC316 {
    public static void main(String[] args) {
        LC316 lc316 = new LC316();
        System.out.println(lc316.removeDuplicateLetters("cbacdcbc"));
    }

    public String removeDuplicateLetters(String s) {
        // 去除重复字符，保证结果的字典序最小
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        boolean[] visit = new boolean[26];
        visit[s.charAt(0) - 'a'] = true;

        // 方法：(1)和前面的元素比较，如果比前面的小或等于，尝试出栈（出栈规则是如果从当前位置往后能找到该字符，那么出队，否则不出队）
        // (2) 需要记录该元素是否访问过，如果访问过，那么就不往里放了
        // (3) 只能用lastIndexOf(s.charAt(stack.peek())，带index的是从后往前找
        for (int i = 1; i < s.length(); i++) {
            if (!visit[s.charAt(i) - 'a']){
                while (!stack.isEmpty() && s.charAt(i) <= s.charAt(stack.peek()) && s.lastIndexOf(s.charAt(stack.peek())) > i) {
                    Integer index = stack.pop();
                    visit[s.charAt(index) - 'a'] = false;
                }
                // 判断前后两个相等的时候
                if (!visit[s.charAt(i) - 'a']) {
                    stack.push(i);
                    visit[s.charAt(i) - 'a'] = true;
                }
            }

        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(s.charAt(stack.pop()));
        }
        res.reverse();
        return res.toString();
    }
}
