package test;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class LC_239 {

    public int[] maxSlidingWindow(int[] nums, int k) {

        ArrayDeque<Integer> q = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>();
        // 初始化
        for (int i=0; i<k; i++){
            if (q.isEmpty()){
                q.addLast(nums[i]);
            }
            else if(nums[i]>q.getLast()){
                while (!q.isEmpty()&&nums[i]>q.getLast()){
                    q.removeLast();
                }
                q.addLast(nums[i]);
            }else {
                q.addLast(nums[i]);
            }

        }

        res.add(q.getFirst());

        for (int i=k;i<nums.length;i++){
            if (nums[i-k] == q.getFirst()){
                q.removeFirst();
            }
            if (q.isEmpty()){
                q.addLast(nums[i]);
            }
            else if(nums[i]>q.getLast()){
                while (!q.isEmpty()&&nums[i]>q.getLast()){
                    q.removeLast();
                }
                q.addLast(nums[i]);
            }else {
                q.addLast(nums[i]);
            }
            res.add(q.getFirst());
        }

        return res.stream().mapToInt(j->j).toArray();


    }
}
