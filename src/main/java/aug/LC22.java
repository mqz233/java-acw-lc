package aug;
import java.util.*;

public class LC22 {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    int lCount = 0;
    int rCount = 0;
    public void fnc(int n){
        if(sb.length() == n*2){
            res.add(sb.toString());
            return;
        }
        // lCount <n 可以加左括号
        if(lCount < n){
            lCount++;
            sb.append('(');
            fnc(n);
            sb.deleteCharAt(sb.length()-1);
            lCount--;
        }
        // rCount < lCount 可以加右括号
        if(rCount<lCount){
            rCount++;
            sb.append(')');
            fnc(n);
            sb.deleteCharAt(sb.length()-1);
            rCount--;
        }
    }
    public List<String> generateParenthesis(int n) {
        fnc(n);
        return res;
    }

    public static void main(String[] args) {
        LC22 lc22 = new LC22();
        lc22.generateParenthesis(3);
    }
}
