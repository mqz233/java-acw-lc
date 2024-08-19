package aug;
import java.util.*;

public class LC35 {
    public int searchInsert(int[] nums, int target) {
        // 1 3 5 6
        int l = 0;
        int r = nums.length-1;
        // final -> l = r+1
        // l 开始全是大于 target的
        // 0 - r 是小于等于target的
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid]<=target){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        if(r == -1) return 0;
        return nums[r] == target?r: l;
    }
}
