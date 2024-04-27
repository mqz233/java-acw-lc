package test;

import java.util.Stack;

public class LC_402 {

    public String removeKdigits(String num, int k) {

        int count = k;
        Stack<Character> s = new Stack<>();
        s.push(num.charAt(0));
        for (int i = 1; i < num.length(); i++) {
            while(!s.isEmpty()&&num.charAt(i)<s.peek()&&count>0){
                count--;
                s.pop();
            }
            s.push(num.charAt(i));
        }

        StringBuilder res = new StringBuilder();
        while (!s.isEmpty()){
            res.append(s.pop());
        }
        // 剩下的字符，取前n-k个
        String tmp = res.reverse().substring(0, num.length() - k);
        // 删除前导0
        boolean flag = false;
        StringBuilder res2 = new StringBuilder();
        for (int i=0;i<tmp.length();i++){
            if (tmp.charAt(i)!='0'){
                flag = true;
            }
            if (tmp.charAt(i)=='0'&&!flag){
                continue;
            }
            res2.append(tmp.charAt(i));
        }

        return res2.toString().isEmpty() ?"0":res2.toString();

    }

    public static void main(String[] args) {
        new LC_402().removeKdigits("1432219",3);
    }
}
