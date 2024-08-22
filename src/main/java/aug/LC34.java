package aug;
import java.util.*;

public class LC34 {
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while(l<=r){
            int mid= l + (r-l)/2;
            if(nums[mid]<=target){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }

        int l2 = 0;
        int r2 = nums.length-1;
        while(l2<=r2){
            int mid= l2 + (r2-l2)/2;
            if(nums[mid]<=target-1){
                l2 = mid+1;
            }else{
                r2 = mid-1;
            }
        }

        if(l2>r) return new int[]{-1,-1};

        return new int[]{l2,r};
    }
}
