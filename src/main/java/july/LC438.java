package july;

import java.util.*;

/*
* 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。

异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。



示例 1:

输入: s = "cbaebabacd", p = "abc"
输出: [0,6]
解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 示例 2:

输入: s = "abab", p = "ab"
输出: [0,1,2]
解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。


提示:

1 <= s.length, p.length <= 3 * 104
s 和 p 仅包含小写字母
* */
public class LC438 {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<p.length();i++){
            Integer value = map.getOrDefault(p.charAt(i), 0);
            map.put(p.charAt(i),value+1);
        }

        int l = 0;
        int r = 0;
        int size = map.size();
        int need = 0;
        HashMap<Character,Integer> find = new HashMap<>();
        while(r<s.length()){
            char curChar = s.charAt(r);
            // 只有p中有这个字符，再去put
            if(map.containsKey(curChar)){
                Integer value = find.getOrDefault(s.charAt(r), 0);
                find.put(s.charAt(r),value+1);
                if(map.getOrDefault(s.charAt(r),0) == value+1){
                    need++;
                }
            }
            // 收缩条件，本题需要连续的，也就是子串
            if(r-l+1==p.length()){
                // 当前字串符合条件
                if(need == size){
                    res.add(l);
                }

                if(map.containsKey(s.charAt(l))){
                    Integer value2 = find.get(s.charAt(l));
                    if(Objects.equals(value2, map.get(s.charAt(l)))){
                        need--;
                    }
                    find.put(s.charAt(l),value2-1);
                }
                l++;
            }
            r++;

        }

        return res;

    }

    public List<Integer> findAnagrams1(String s, String t) {
        List<Integer> res = new ArrayList<>();
        if (s == null || t == null || s.length() < t.length()) {
            return res;
        }

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        // 构建need哈希表
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            // 窗口内数据更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 判断左侧窗口是否要收缩
            while (right - left >= t.length()) {
                if (valid == need.size()) {
                    res.add(left);
                }

                char d = s.charAt(left);
                left++;

                // 窗口内数据更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LC438 lc438 = new LC438();
//        lc438.findAnagrams1("cbaebabacd","abc");
        lc438.findAnagrams("cbaebabacd","abc");
    }
}
