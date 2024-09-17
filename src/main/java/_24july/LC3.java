package _24july;
import java.util.*;
/*
* 给定一个字符串 s ，请你找出其中不含有重复字符的 最长
子串
 的长度。



示例 1:

输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。


提示：

0 <= s.length <= 5 * 104
s 由英文字母、数字、符号和空格组成
* */
public class LC3 {
    public int fnc(String s){
        if(s.length() == 0) return 0;
        HashSet<Character> set = new HashSet<>();
        int l = 0;
        int r = 0;
        int res = 1;
        while(r < s.length()){
            char curChar = s.charAt(r);
            if(!set.contains(curChar)){
                set.add(curChar);
                if(r-l+1>res) res = r-l+1;
            }else{
                while(set.contains(curChar)){
                    set.remove(s.charAt(l));
                    l++;
                }
                set.add(curChar);
            }
            r++;
        }
        return res;
    }
}