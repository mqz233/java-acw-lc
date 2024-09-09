package _24sep;
import java.util.*;

// https://dwmorning.github.io/leetcode280/
public class LC280 {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        // 首先对数组进行排序
        Arrays.sort(nums);

        for(int i=2;i<nums.length;i+=2){
            int tmp = nums[i];
            nums[i] = nums[i-1];
            nums[i-1] = tmp;
        }

        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }

    public static void main(String[] args) {
        LC280 lc280 = new LC280();
        lc280.wiggleSort(new int[]{7,6,5,4,3,2,1});
    }
}
