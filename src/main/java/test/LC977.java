package test;

import java.util.*;

public class LC977 {

    public int[] sortedSquares(int[] nums) {

        int l = 0;
        int r = nums.length - 1;
        int[] res = new int[nums.length];
        int size = nums.length-1;
        while (l <= r) {
            if (Math.abs(nums[l]) > Math.abs(nums[r])) {
                res[size--] = nums[l] * nums[l];
                l++;
            } else {
                res[size--] = nums[r] * nums[r];
                r--;
            }
        }
        return res;

    }

}
