package _24aug;
import java.util.*;

public class LC394 {
    public String decodeString(String s) {
        // 出栈时机 == 遇到 ']'
        ArrayDeque<Character> q = new ArrayDeque<>();
        for(char c:s.toCharArray()){
            if(c!=']'){
                q.addLast(c);
            }else{
                StringBuilder sb = new StringBuilder();
                while(!q.isEmpty()&&Character.isLetter(q.getLast())){
                    sb.insert(0,q.removeLast());
                }
                // 去掉[
                q.removeLast();
                StringBuilder num = new StringBuilder();
                while(!q.isEmpty()&&Character.isDigit(q.getLast())){
                    num.insert(0,q.removeLast());
                }
                int count = Integer.parseInt(num.toString());
                for(int i=0;i<count;i++){
                    for(char c1:sb.toString().toCharArray()){
                        q.addLast(c1);
                    }
                }
            }
        }

        StringBuilder res = new StringBuilder();
        while(!q.isEmpty()){
            res.insert(0,q.removeLast());
        }

        return res.toString();
    }

//    public static void main(String[] args) {
//        new LC394().decodeString("3[a2[c]]");
//    }
}
