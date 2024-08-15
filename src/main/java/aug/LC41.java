package aug;
/*
* 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。

请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。


示例 1：

输入：nums = [1,2,0]
输出：3
解释：范围 [1,2] 中的数字都在数组中。
示例 2：

输入：nums = [3,4,-1,1]
输出：2
解释：1 在数组中，但 2 没有。
示例 3：

输入：nums = [7,8,9,11,12]
输出：1
解释：最小的正数 1 没有出现。
* */
public class LC41 {
    public int firstMissingPositive(int[] nums) {
         for(int i=0;i<nums.length;i++){
             if(nums[i]<=0) nums[i] = nums.length+1;
         }
         for(int i=0;i<nums.length;i++){
             int index = Math.abs(nums[i]);
             if(index<=nums.length){
                 if(nums[index-1]>0) nums[index-1] = -nums[index-1];
             }
         }
         int res = -1;
         for(int i=0;i<nums.length;i++){
             if(nums[i]>0) {
                 res = i+1;
                 break;
             }
             if(i == nums.length-1){
                 res = nums.length+1;
             }

         }
         return res;
    }
}
