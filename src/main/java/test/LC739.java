package test;
import java.util.*;

public class LC739 {
    public int[] dailyTemperatures(int[] temperatures) {

        // [5,6,7,1,4,9,2,3]
        int[] res = new int[temperatures.length];
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(0);
        for(int i=1; i<temperatures.length; i++){
            while(!q.isEmpty() && temperatures[i]>temperatures[q.getLast()]){
                Integer tmp = q.removeLast();
                res[tmp] = i-tmp;
            }
            q.addLast(i);
        }
        return res;


    }
}
