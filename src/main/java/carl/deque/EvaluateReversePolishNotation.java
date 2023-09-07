package carl.deque;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push((num2 + num1));
                        break;
                    case "-":
                        stack.push((num2 - num1));
                        break;
                    case "*":
                        stack.push((num2 * num1));
                        break;
                    case "/":
                        stack.push((num2 / num1));
                        break;
                    default:
                }
            }
        }

        return stack.pop();

    }

    private boolean isNumber(String token){
        return !("+".equals(token)||"-".equals(token)||"*".equals(token)||"/".equals(token));
    }

}
