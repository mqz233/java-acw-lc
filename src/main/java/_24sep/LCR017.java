package _24sep;

import java.util.*;

// 两个map 记录每个字符个数
// 两个count 记录字符种类
// count什么时候++ 这个字符在map1的数量和map2的数量相等
// 什么时候满足条件 两个count相等
// 收缩什么时候结束 count != map
public class LCR017 {
    public String minWindow(String s, String t) {
        // 记录t中每个种类字符的个数
        HashMap<Character, Integer> tMap = new HashMap<>();
        // 记录s
        HashMap<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        // 记录tMap大小，即一共有几种字符
        int tCount = tMap.size();
        // 记录s
        int sCount = 0;
        // 滑动窗口
        int l = 0;
        int r = 0;
        // 最小值
        String res = null;
        while (r < s.length()) {
            char c = s.charAt(r);
            // 如果是t串里的字符
            if (tMap.containsKey(c)) {
                // sMap记录
                sMap.put(c, sMap.getOrDefault(c, 0) + 1);
                // s串里这个字符的数量和t串字符的数量相等
                if (sMap.get(c).equals(tMap.get(c))) {
                    sCount++;
                }
            }
            // sCount == tCount说明满足条件 左侧开始缩
            while (sCount == tCount) {
                // 记录更新最短串
                String tmp = s.substring(l, r + 1);
                if (res == null || tmp.length() < res.length()) {
                    res = tmp;
                }
                char lc = s.charAt(l);
                // 左侧的这个字符在map里
                if (sMap.containsKey(lc)) {
                    // 这个字符数量等于tMap中的数量，现在把它移除后，这个字符的数量就不够了，sCount--
                    if (sMap.get(lc).equals(tMap.get(lc))) {
                        sCount--;
                    }
                    sMap.put(lc, sMap.get(lc) - 1);
                }
                l++;
            }

            r++;
        }

        return res == null ? "" : res;

    }

    public String minWindow2(String s, String t) {
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

    public static void main(String[] args) {
        LCR017 lcr017 = new LCR017();
        lcr017.minWindow("bba", "ab");
    }
}

