package test;
import java.util.*;

public class LC503 {

    public int[] nextGreaterElements(int[] nums) {

        // [1,2,1] 输出[2,-1,2]
        int[] res = new int[nums.length];
        Arrays.fill(res,-1);
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(0);
        int length = nums.length;
        for(int i=1; i<2*length;i++){

            while(!q.isEmpty()&&nums[i%length]>nums[q.getLast()]){
                Integer tmp = q.removeLast();
                res[tmp] = nums[i%length];
            }

            q.addLast(i%length);
        }

        return res;

    }
    
}
