package test;
import java.util.*;

public class LC496{
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        //对于nums2中的每一个元素，构建单调栈
        //构建方法：和末尾元素比较，如果比末尾大说明在右边找到符合的了，这时在nums1中寻找该元素并为res赋值

        int[] res = new int[nums1.length];
        Arrays.fill(res,-1);

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums1.length; i++){
            map.put(nums1[i],i);
        }

        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(0);

        for(int i=1;i<nums2.length;i++){

            // 当前元素比 q.getLast()大
            while(!q.isEmpty()&&nums2[i]>nums2[q.getLast()]){
                Integer tmp  = q.removeLast();
                if(map.containsKey(nums2[tmp])){
                    res[map.get(nums2[tmp])] = nums2[i];
                }
            }

            q.addLast(i);
        }

        return res;

    }

}