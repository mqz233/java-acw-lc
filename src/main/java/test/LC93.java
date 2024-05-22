package test;
import java.util.*;

public class LC93 {

    List<String> res = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();

    public void fnc(String s,int index){

        // 必须切到末尾，这次的index是 s.length()
        if (index == s.length()){
            // path的size要等于4
            if (path.size()==4){
                res.add(path.get(0)+"."+path.get(1)+"."+path.get(2)+"."+path.get(3));
            }
            return;
        }

        if (path.size()>4){
            return;
        }

        // 切分+回溯
        for (int i=index;i<index+3&&i<s.length();i++){
            String tmp = s.substring(index,i+1);
            if (tmp.startsWith("0")&&tmp.length()>1) continue;
            if (Integer.parseInt(tmp)>255) continue;
            path.add(tmp);
            fnc(s,i+1);
            path.removeLast();
        }

    }


    public List<String> restoreIpAddresses(String s) {
        fnc(s,0);
        return res;
    }

    public static void main(String[] args) {

        LC93 lc93 = new LC93();
        List<String> strings = lc93.restoreIpAddresses("25525511135");
        for (String tmp:strings){
            System.out.println(tmp);
        }
    }
}
