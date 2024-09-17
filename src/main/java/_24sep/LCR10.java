package _24sep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LCR10 {
    public int subarraySum(int[] nums, int k) {
        // 计算前缀和 pre[i]
        // map store
        // key = pre[i]-k v = "count"
        int n = nums.length;
        int[] pre = new int[n+1];
        int res  = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=1;i<=n;i++){
            pre[i] = pre[i-1]+nums[i-1];
            // 先找，再更新，避免k=0的情况，把自己算进去了
            if(map.get(pre[i]-k) != null){
                res+= map.get(pre[i]-k);
            }
            map.put(pre[i],map.getOrDefault(pre[i],0)+1);

        }

        return res;

    }

    public static void main(String[] args) {
        LCR10 a = new LCR10();
        a.subarraySum(new int[]{1},0);
    }
}
