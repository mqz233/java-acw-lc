package test;

import java.util.Arrays;
import java.util.Collections;

public class LC1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        //输入：A = [4,2,3], K = 1
        //输出：5
        //解释：选择索引 (1) ，然后 A 变为 [4,-2,3]。
        //输入：A = [3,-1,0,2], K = 3
        //输出：6
        //解释：选择索引 (1, 2, 2) ，然后 A 变为 [3,1,0,2]。
        // 2 3 4
        // 有负数，优先翻转负数
        // 没有负数，翻转最小的
        Arrays.sort(nums);
        int index = 0;
        while (index<nums.length && nums[index] < 0 && k>0) {
            nums[index] = -nums[index];
            index++;
            k--;
        }
        if (k == 0) {
            int sum = 0;
            for(int num:nums){
                sum+=num;
            }
            return sum;
        }else {
            Arrays.sort(nums);
            if (k%2 == 1){
                nums[0] = -nums[0];
            }
            int sum = 0;
            for(int num:nums){
                sum+=num;
            }
            return sum;
        }



    }
}
