package _24aug;
import java.util.*;

/*
* 示例 1:

输入: temperatures = [73,74,75,71,69,72,76,73]
输出: [1,1,4,2,1,1,0,0]
示例 2:

输入: temperatures = [30,40,50,60]
输出: [1,1,1,0]
示例 3:

输入: temperatures = [30,60,90]
输出: [1,1,0]
 */
public class LC739 {
    public int[] dailyTemperatures(int[] temperatures) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int[] res = new int[temperatures.length];
        q.addLast(0);
        for(int i=1;i<temperatures.length;i++){
            while(!q.isEmpty()&&temperatures[i]>temperatures[q.getLast()]){
                int index = q.removeLast();
                res[index] = i-index;
            }
            q.addLast(i);
        }

        return res;

    }
}
