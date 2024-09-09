package bishi.quna;
import java.util.*;

public class _quna_0906_03 {
    static int count = 0;
    static int max = 0;
    static Map<String,Boolean> map = new HashMap<>();
    public static boolean test(String str){
        int[] arr = new int[10];
        for(char c:str.toCharArray()){
            arr[c-'0']++;
        }
        int tmp = 0;
        for(int i=0;i<10;i++){
            if(arr[i]!=0){
                if(arr[i] == 1){
                    return false;
                }
                if(tmp == 0){
                    tmp = arr[i];
                }else{
                    if(tmp!=arr[i]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static void fnc(String str,int index,int start){
        if(index >= str.length()){
            if(count>max){
                max = count;
            }
            return;
        }

        for(int i=index;i<str.length();i+=2){
            String tmp = str.substring(start,i+1);
            if(null == map.get(tmp)){
                map.put(tmp,test(tmp));
            }
            if(map.get(tmp)){
                count++;
                fnc(str,i+2,i+1);
                count--;
            }
        }
    }
    public static void main(String[] args) {
       int n = 8;
       String str = "01102222";
       fnc(str,1,0);
        System.out.println(max);
    }
}
