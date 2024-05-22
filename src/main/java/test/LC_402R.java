package test;

import java.util.Stack;

public class LC_402R {

    // 移掉k个数，使得剩下的数字最小
    // 1234567 3 1234
    // 7654321 3 4321
    // 6123746
    // 10200 1 0200
    public String removeKdigits(String num, int k) {

        int count = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i=1; i<num.length();i++){
            // 从左到右遍历，如果比栈顶元素小，那么一直出栈，知道大于等于或者count ==k
            while (!stack.isEmpty()&&count<k&&num.charAt(i)<num.charAt(stack.peek())){
                stack.pop();
                count++;
            }

            //否则入栈
            stack.push(i);

        }

        StringBuilder res = new StringBuilder();
        StringBuilder res2 = new StringBuilder();
        while (!stack.isEmpty()){
            res.append(num.charAt(stack.pop()));
        }

        // 反转，截取前length-k个
        String tmp = res.reverse().substring(0,num.length()-k);
        // 去除前导0
        boolean flag = false;
        for (int i=0; i<tmp.length();i++){
            if (tmp.charAt(i)!='0'){
                flag = true;
                res2.append(tmp.charAt(i));
            }else{
                if (flag){
                    res2.append('0');
                }
            }
        }

        return res2.toString().length() == 0?"0":res2.toString();

    }
}
