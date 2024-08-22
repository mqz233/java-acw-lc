package _24july;

/*
* 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

请注意 ，必须在不复制数组的情况下原地对数组进行操作。



示例 1:

输入: nums = [0,1,0,3,12]
输出: [1,3,12,0,0]
示例 2:

输入: nums = [0]
输出: [0]


提示:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1


进阶：你能尽量减少完成的操作次数吗？
* */
public class LC283 {
    public void moveZeroes(int[] nums) {
        int p1 = 0;
        int p2 = 0;
        // p1记录为0的，等待被交换的位置
        // p2找到不为0的，跟p1进行交换
        while(p2<nums.length){
            if(nums[p2] != 0){
                int tmp = nums[p2];
                nums[p2] = nums[p1];
                nums[p1] = tmp;
                p1++;
            }
            p2++;
        }

    }
}
