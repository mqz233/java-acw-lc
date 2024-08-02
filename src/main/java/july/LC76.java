package july;
import java.util.*;

public class LC76 {
    /*
    * 输入：s = "ADOBECODEBANC", t = "ABC"
输出："BANC"
解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
* */
    public String minWindow(String s, String t) {
        if(t.length()>s.length()) return "";
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c:t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int mapSize = map.size();
        int l=0;
        int r=0;
        int valid = 0;
        String res = null;
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
                // l需要向右移动，findMap value 和 valid的回溯是必须做的
                char lChar = s.charAt(l);
                if(map.containsKey(lChar)){
                    if(map.get(lChar).equals(findMap.get(lChar))){
                        valid--;
                    }
                    findMap.put(lChar,findMap.get(lChar)-1);
                }
                // 判断res是否需要更新
                if(res == null || res.length() > r-l+1){
                    res = s.substring(l,r+1);
                }
                l++;
            }
            r++;
        }

        if(res == null){
            res = "";
        }
        return res;
    }

    public static void main(String[] args) {
        LC76 lc76 = new LC76();
        lc76.minWindow("ADOBECODEBANC","ABC");
    }
}
