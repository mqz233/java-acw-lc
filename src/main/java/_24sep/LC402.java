package _24sep;
import java.util.*;

public class LC402 {
    // 如何判断一个数字是否需要被移除，如果比前面的数字小，说明需要移除
    // 因为移除了前面的数字之后，整个数会变小
    public String removeKdigits(String num, int k) {
        char[] arr = num.toCharArray();
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int count = 0;
        q.addLast(arr[0]-'0');
        for(int i = 1;i<arr.length;i++){
            while(!q.isEmpty()  && arr[i]-'0'<q.getLast()){
                q.removeLast();
                count++;
                // 已经移除了k个数，直接返回
                if(count == k){
                    StringBuilder sb = new StringBuilder();
                    while(!q.isEmpty()){
                        sb.append(q.removeFirst());
                    }
                    sb.append(num, i, arr.length);
                    int j = 0;
                    // 去除前导0，如果结果Length == 0 返回 '0'
                    while(j<sb.length()&& sb.charAt(j) == '0') j++;
                    String res  = sb.substring(j,sb.length());
                    return res.isEmpty()?"0":res;
                }
            }
            q.addLast(arr[i]-'0');

        }
        // 移除的数量不够，返回前n-k个数字
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            sb.append(q.removeFirst());
        }
        String tmp = sb.substring(0,num.length()-k);
        int j = 0;
        while(j<tmp.length() && tmp.charAt(j) == '0') j++;
        String res = tmp.substring(j);
        return res.isEmpty()?"0":res;
    }

    public static void main(String[] args) {
        LC402 lc402 = new LC402();
        String s = lc402.removeKdigits("10", 1);
        System.out.println(s);
    }
}
