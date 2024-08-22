package _24aug;

public class LC153 {
    public int findMin(int[] nums) {
        // 4 5 6 7 0 1 2 3
        // 0 1 2 3 4 5 6 7
        int l = 0;
        int r = nums.length - 1;
        int rightNum = nums[r];
        while (l <= r) {
            int mid = l + (r - l) / 2;
            // nums[mid] 比最右边的小，说明一定在第二段或整个就是递增的
            // 那么最小值在mid 左边
            // nums[mid] 比最右边的大，说明一定在第一段 而且分两段
            // 最小值在mid 右边
            if(nums[mid]<rightNum){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }

        return l;



    }
}
