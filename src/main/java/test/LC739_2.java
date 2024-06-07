package test;
import java.util.*;

public class LC739_2 {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(0);
        int[] res = new int[temperatures.length];
        Arrays.fill(res,0);
        for(int i=1;i<temperatures.length;i++){
            // 出队
            while(!q.isEmpty()&&temperatures[i]> temperatures[q.getLast()]){
                int tmp = q.removeLast();
                res[tmp] = i-tmp;
            }
            q.addLast(i);
        }
        return res;

    }

    
}
