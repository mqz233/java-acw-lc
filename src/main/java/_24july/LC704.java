package _24july;

/**
 * @Desc：示例 1:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例 2:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 */
public class LC704 {

    public int search(int[] nums, int target) {

        int l = 0;
        int r = nums.length-1;

        while (l<=r){
            int mid = l + (r-l)/2;
            if (nums[mid] == target) return mid;
            else if(nums[mid]>target){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return -1;


    }
}
