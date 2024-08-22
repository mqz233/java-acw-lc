package _24aug;
import java.util.*;
/*
* 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。



注意：

对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
如果 s 中存在这样的子串，我们保证它是唯一的答案。


示例 1：

输入：s = "ADOBECODEBANC", t = "ABC"
输出："BANC"
解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
示例 2：

输入：s = "a", t = "a"
输出："a"
解释：整个字符串 s 是最小覆盖子串。
示例 3:

输入: s = "a", t = "aa"
输出: ""
解释: t 中两个字符 'a' 均应包含在 s 的子串中，
因此没有符合条件的子字符串，返回空字符串。


提示：

m == s.length
n == t.length
1 <= m, n <= 105
s 和 t 由英文字母组成
* */

public class LC76 {
    public String minWindow(String s, String t) {
/*
* 输入：s = "ADOBECODEBANC", t = "ABC"
输出："BANC"
* */
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c:t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        int l = 0;
        int r = 0;
        String res = null;
        int mapSize = map.size();
        int valid = 0;
        HashMap<Character,Integer> findMap = new HashMap<>();
        while(r<s.length()){
            char curChar = s.charAt(r);
            if(map.containsKey(curChar)){
                findMap.put(curChar,findMap.getOrDefault(curChar,0)+1);
                if(findMap.get(curChar).equals(map.get(curChar))){
                    valid++;
                }
            }

            while(valid == mapSize){
                String tmp = s.substring(l,r+1);
                if(res == null || tmp.length()<res.length()){
                    res = tmp;
                }
                char lChar = s.charAt(l);
                // 回溯过程
                if(map.containsKey(lChar)){
                    if(map.get(lChar).equals(findMap.get(lChar))){
                        valid--;
                    }
                    findMap.put(lChar,findMap.get(lChar)-1);
                }
                l++;
            }

            r++;
        }
        if(res == null) res = "";
        return res;
    }
}
