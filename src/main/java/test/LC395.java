package test;
import java.util.*;

public class LC395 {
    public int longestSubstring(String s, int k) {
        if (s.length() < k) return 0;
        HashMap<Character, Integer> counter = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            counter.put(s.charAt(i), counter.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (char c : counter.keySet()) {
            if (counter.get(c) < k) {
                int res = 0;
                String[] split = s.split(String.valueOf(c));
                for (String t : split) {
                    res = Math.max(res, longestSubstring(t, k));
                }
                return res;
            }
        }
        return s.length();
    }

    public static void main(String[] args) {
        LC395 lc395 = new LC395();
        lc395.longestSubstring("aaabb",3);
    }

}

