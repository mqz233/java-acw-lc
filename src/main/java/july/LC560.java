package july;
import java.util.*;
/*
* 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。

子数组是数组中元素的连续非空序列。



示例 1：

输入：nums = [1,1,1], k = 2
输出：2
示例 2：

输入：nums = [1,2,3], k = 3
输出：2


提示：

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107
* */
public class LC560 {
    // 1 2 1 2 1

    public int subarraySum(int[] nums, int k) {
        int res = 0;
        for(int i=0; i<nums.length;i++){
            int sum = 0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
                if(sum == k){
                    res++;
                }
            }
        }

        return res;
    }

    public int subarraySum1(int[] nums, int k) {
        int[] prefixArr = new int[nums.length+1];
        prefixArr[0] = 0;
        for(int i=0;i<nums.length;i++){
            prefixArr[i+1] = prefixArr[i]+nums[i];
        }
        return 0;
    }
}
