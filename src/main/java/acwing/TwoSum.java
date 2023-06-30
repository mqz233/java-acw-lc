package acwing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 两数之和，使用HashMap解决
// https://leetcode.cn/problems/two-sum/submissions/
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        //初始化
        Map<Integer,Integer> m = new HashMap<>();
        // 遍历每个元素，如果target - nums[i] 不在map中，那么put(nums[i],i)
        // 如果存在那么返回 i和（target - nums[i] ）的下标
        for (int i = 0; i < nums.length; i++) {
            int t = target - nums[i];
            if (m.containsKey(t)){
                return new int[]{i,m.get(t)};
            }
            else{
                m.put(nums[i],i);
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{3, 3}, 6)));
    }
}
