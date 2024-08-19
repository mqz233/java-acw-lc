package aug;
import java.util.*;

public class LC20 {
    public boolean isValid(String s) {
        // length 不能被2整除 一定不行
        //  构造map 方便判断
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        ArrayDeque<Character> q = new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                if(q.isEmpty()||map.get(c) != q.getLast()){
                    return false;
                }else{
                    q.removeLast();
                }
            }else{
                q.addLast(c);
            }
        }
        return q.isEmpty();

    }
}
