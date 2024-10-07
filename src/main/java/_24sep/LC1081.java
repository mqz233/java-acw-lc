package _24sep;

import java.util.*;

public class LC1081 {
    // 删除字符 考虑什么时候删除
    // 和LC402差不多 当前字符比前一个字符小的时候，考虑删除
    // 同时，前一个字符数量需要>=1 即后面还会出现
    public String smallestSubsequence(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        ArrayDeque<Character> q = new ArrayDeque<>();
        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 有了就直接跳过？
            if (!hs.contains(c)) {
                while (!q.isEmpty() && c < q.getLast() && arr[q.getLast() - 'a'] >= 1) {
                    char tmp = q.removeLast();
                    hs.remove(tmp);
                }
                q.addLast(c);
                hs.add(c);
            }
            arr[c - 'a']--;
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char c = q.removeFirst();
            sb.append(c);

        }
        return sb.toString();

    }

    public String smallestSubsequence2(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> seen = new HashSet<>();
        Map<Character, Integer> remainCounter = new HashMap<>();

        // Initialize the counter with the characters in the string
        for (char c : s.toCharArray()) {
            remainCounter.put(c, remainCounter.getOrDefault(c, 0) + 1);
        }

        for (char c : s.toCharArray()) {
            if (!seen.contains(c)) {
                while (!stack.isEmpty() && c < stack.peek() && remainCounter.get(stack.peek()) > 0) {
                    seen.remove(stack.pop());
                }
                seen.add(c);
                stack.push(c);
            }
            remainCounter.put(c, remainCounter.get(c) - 1);
        }

        StringBuilder result = new StringBuilder();
        for (Character c : stack) {
            result.append(c);
        }
        return result.toString();
    }
}

