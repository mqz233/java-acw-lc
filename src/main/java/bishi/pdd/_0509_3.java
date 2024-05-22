package bishi.pdd;
import java.util.*;

public class _0509_3 {

//    4
//    aBBa aa
        public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        String s = in.next();
        StringBuilder sb = new StringBuilder(s);
        int res = 0;
        while (sb.length()>0){
            int start =0;
            int max = 1;
            int count = 1;
            int maxStart = 0;
            while (start+1<sb.length()){
                if (sb.charAt(start)==sb.charAt(start+1)){
                    start++;
                    count++;
                    if (count>max){
                        maxStart = start-count+1;
                        max = count;
                    }
                }else {
                    start++;
                    count=1;
                }

            }
            sb.delete(maxStart,maxStart+max);
            res++;
        }
        System.out.println(res);


    }
}
