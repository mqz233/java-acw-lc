package test;
import java.util.*;

public class LC455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0;
        int j=0;
        int num = 0;
        while(i<g.length&&j<s.length){
            while(j<s.length && s[j]<g[i]) j++;
            if(j<s.length){
                num++;
                i++;
                j++;
            }
     
        }
        return num;

    }
}
