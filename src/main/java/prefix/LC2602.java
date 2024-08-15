package prefix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC2602 {
    public List<Long> minOperations(int[] nums, int[] queries) {
        // O(n*m) 太慢
//        List<Long> res = new ArrayList<>();
//        for(int i=0; i<queries.length; i++){
//            long tmp = 0L;
//            for(int j=0; j<nums.length;j++){
//                tmp += Math.abs(nums[j]-queries[i]);
//            }
//            res.add(tmp);
//        }
//        return res;
        // O(m+n)?
        List<Long> res = new ArrayList<>();
        // nums排序
        Arrays.sort(nums);
        // 计算前缀和数组
        long[] arr = new long[nums.length+1];
        for(int i=1;i<=nums.length;i++){
            arr[i] = arr[i-1]+nums[i-1];
        }
        for(int i=0; i<queries.length; i++){
            // 二分查找queries[i]的位置
            int index = search(nums,queries[i]);
            long tmp1 = (long) queries[i] *(index) - (arr[index]);
            long tmp2 = (arr[arr.length-1] - arr[index]) - (long)(arr.length-1-index)*(queries[i]);
            res.add(tmp1+tmp2);

        }
        return res;
    }

    public int search(int[]nums,int find){
        // L开始都比find大
        // r的右边大于等于find
        // l = r+1;
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid] < find){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return l;
    }
}
