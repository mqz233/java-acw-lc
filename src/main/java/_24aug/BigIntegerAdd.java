package _24aug;
import java.util.*;

public class BigIntegerAdd {
    public String fnc(String s1,String s2){
        // 如果s1 < s2 那么直接 -号加上
        if(s1.length()<s2.length() || (s1.length() == s2.length() && s1.compareTo(s2) < 0) ){
            return "-" + fnc(s2,s1);
        }

        int b = 0;
        StringBuilder res = new StringBuilder(s1.length());
        for(int i=0;i<s2.length();i++){
            int num2 = s2.charAt(s2.length()-i-1) - '0';
            int num1 = s1.charAt(s1.length()-i-1) - '0';
            if(num1 - b <num2){
                res.append(10+num1-b-num2);
                b  = 1;
            }else{
                res.append(num1 - b -num2);
                b = 0;
            }
        }
        for(int i=s1.length()-s2.length()-1;i>=0;i--){
            if(s1.charAt(i)-'0' == 0 && b == 1){
                res.append(9);
                b = 1;
            }else{
                res.append(s1.charAt(i)-'0' - b);
                b = 0;
            }
        }
        StringBuilder reverse = res.reverse();
        while(reverse.length()>1&& reverse.charAt(0) == '0'){
            reverse.delete(0,1);
        }
        return reverse.toString();


    }
    public static void main(String[] args) {
        String num2 = "90";
        String num1 = "90";
        BigIntegerAdd bigIntegerAdd = new BigIntegerAdd();
        String res = bigIntegerAdd.fnc(num1,num2);
        System.out.println(res);
    }
}
