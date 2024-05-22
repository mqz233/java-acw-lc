package test;

import java.util.HashSet;

public class LC3 {
    public int lengthOfLongestSubstring(String s) {
        // 滑动窗口
        int l = 0;
        int r = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        while (r<s.length()){
            char c = s.charAt(r);
            if (!set.contains(c)){
                // 加入set
                set.add(c);
                // 更新max
                if (r-l+1>max){
                    max = r-l+1;
                }
                r++;
            }else {
                // 从l开始移除元素，直到移除到c
                while (s.charAt(l)!=c){
                    set.remove(s.charAt(l));
                    l++;
                }
                set.remove(s.charAt(l));
                l++;
            }
        }

        return max;


    }

    public static void main(String[] args) {
        LC3 lc3 = new LC3();
        lc3.lengthOfLongestSubstring("abcabcbb");
    }
}
