package _24sep;
import java.util.*;

public class LC438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        HashMap<Character,Integer> pm = new HashMap<Character,Integer>();
        for(int i=0;i<p.length();i++){
            char c = p.charAt(i);
            pm.put(c,pm.getOrDefault(c,0)+1);
        }
        int ps = pm.size();
        int ss = 0;
        HashMap<Character,Integer> sm = new HashMap<>();
        int l = 0;
        int r = 0;
        while(r<s.length()){
            char c = s.charAt(r);
            // 更新sMap 和 sSize
            if(pm.containsKey(c)){
                sm.put(c,sm.getOrDefault(c,0)+1);
                if(pm.get(c).equals(sm.get(c))){
                    ss++;
                }
            }
            // 什么时候需要收缩连续长度为 p.length()
            if(r-l+1 ==  p.length()){
                // 判断是否满足条件 ss = ps
                if(ss == ps){
                    res.add(l);
                }
                // 收缩
                char tmp = s.charAt(l);
                if(sm.containsKey(tmp)){
                    if(sm.get(tmp).equals(pm.get(tmp))){
                        ss--;
                    }
                    sm.put(tmp,sm.get(tmp)-1);
                }
                l++;

            }
            r++;
        }
        return res;
    }

    public static void main(String[] args) {
        LC438 lc438 = new LC438();
        lc438.findAnagrams("cbaebabacd","abc");
    }
}
