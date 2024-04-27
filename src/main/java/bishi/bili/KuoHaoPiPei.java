package bishi.bili;
import java.util.*;

public class KuoHaoPiPei {
    public boolean IsValidExp (String s) {
        // write code here
        if (s.length()==0) return true;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int index = 1;
        while (index<s.length()&&!stack.isEmpty()){
            if (s.charAt(index) == '(' || s.charAt(index) == '{' ||  s.charAt(index) == '['){
                stack.push(index);
                index++;
            }else {
                if (s.charAt(index) == ')' && s.charAt(stack.peek()) == '('){
                    stack.pop();
                    index++;
                }else  if (s.charAt(index) == '}' && s.charAt(stack.peek()) == '{'){
                    stack.pop();
                    index++;
                }else if (s.charAt(index) == ']' && s.charAt(stack.peek()) == '['){
                    stack.pop();
                    index++;
                }else {
                    return false;
                }
            }


        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        KuoHaoPiPei kuoHaoPiPei = new KuoHaoPiPei();
        System.out.println(kuoHaoPiPei.IsValidExp("([)]"));
    }
}
