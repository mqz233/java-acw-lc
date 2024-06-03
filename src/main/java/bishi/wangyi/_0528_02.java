package bishi.wangyi;
import java.util.*;

public class _0528_02 {

    public static void fnc(long n, long m, long[] res,Map<Integer,Long> map){

        if(n==0L){
            if(m == 0L){
                for(Integer key:map.keySet()){
                    if(map.get(key)>res[key]){
                        res[key] = map.get(key);
                    }
                }
            }

            return;    
        }

        long i = m - (7L*(n-1L));
        if(i<=1){
            i=1;
        }
        for(; i<=7L&&m-i>=n-1L; i++){
            map.put((int)(i-1L),map.getOrDefault((int)(i-1L),0L)+1L);
            fnc(n-1L,m-i,res,map);
            map.put((int)(i-1L),map.get((int)(i-1L))-1L);
        }



    }

    public static long maxDay(long n, long m, long i) {  
        if (i * n == m) {  
            return n;  
        } else if (i * n < m) {  
            long tmp = m - i * n;  
            n = n - tmp / (7 - i);  
            if (tmp % (7 - i) != 0) {  
                n--;  
            }  
            return n;  
        } else {  
            long tmp = i * n - m;  
            n = n - tmp / (i - 1);  
            if (tmp % (i - 1) != 0) {  
                n--;  
            }  
            return n;  
        }  
    }  

    public static void main(String[] args) {
        // Scanner in = new Scanner(System.in);
        // long n = in.nextLong();
        // long m = in.nextLong();
        // long[] res = new long[7];
        // Map<Integer,Long> map = new HashMap<>();
        // fnc(n,m,res,map);
        // for(int i=0; i<7; i++){
        //     System.out.println(res[i]);
        // }
        System.out.println(maxDay(5, 30, 1));


       
    }
    
}
