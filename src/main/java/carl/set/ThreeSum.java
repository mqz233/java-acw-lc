package carl.set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        // jdk1.8 数组排序
        Arrays.sort(nums);

        // 创建结果list
        List<List<Integer>> result = new ArrayList<>();

        // 第一层循环，遍历每个元素
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) return result;
            // 对第一层循环的a去重（注意要和前一个数比较，和后一个数比较会漏掉-1,-1,2这种情况）
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 对第二层循环的b和c去重
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    // b向后移动 c向前移动
                    left++;
                    right--;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else {
                    left++;
                }
            }

        }

        return result;


    }
}
