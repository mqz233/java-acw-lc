package test;
import java.util.*;

public class LC496_2 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer,Integer> map = new HashMap<>();
        for(int j=0; j<nums1.length; j++){
            map.put(nums1[j], j);            
        }

        int[] res = new int[nums1.length];
        Arrays.fill(res,-1);
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(0);
            for(int i=1;i<nums2.length;i++){
                while(!q.isEmpty()&&nums2[i]>nums2[q.getLast()]){
                    Integer tmp = q.removeLast();
                    if(map.getOrDefault(nums2[tmp],-1)!=-1){
                        res[map.get(nums2[tmp])] = nums2[i];
                    }
                    
                }
                q.add(i);
            }

        return res;

    }
    
}
