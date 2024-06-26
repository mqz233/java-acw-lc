package test;
import java.util.*;

public class LC53_3 {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int curMaxSum = 0;
        for(int j=nums.length-1;j>=0;j--){
            if(curMaxSum>0){
                curMaxSum += nums[j];
            }else{
                curMaxSum = nums[j];
            }
            if(curMaxSum>res) res = curMaxSum;
        }
        return res;

    }
}
