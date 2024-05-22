package test;
import java.util.*;
public class LC131 {

    public List<List<String>> res = new ArrayList<>();
    public LinkedList<String> path = new LinkedList<>();

    public boolean is(String s){
        if (s.length()==0){
            return true;
        }
        int l = 0;
        int r = s.length()-1;
        while (l<r){
            if (s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }


    public void fnc(String s,int l,int r){

        // 无法再切分，且左侧都为回文串
        if (l==r){
            res.add(new ArrayList<>(path));
            return;
        }

        // 这一层这刀切在哪
        for (int i=l+1;i<=r;i++){
            String tmp = s.substring(l,i);
            // 切完必须是回文串，否则剪掉
            if (is(tmp)){
                path.add(tmp);
                fnc(s,i,r);
                path.removeLast();
            }
        }
    }

    public List<List<String>> partition(String s) {
        fnc(s,0,s.length());
        return res;
    }

    public static void main(String[] args) {
        LC131 lc131 = new LC131();
        lc131.partition("aab");
    }

}
