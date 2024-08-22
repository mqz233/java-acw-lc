package _24aug;

public class LC33 {
    public int search(int[] nums, int target) {
        // nums target
        int l = 0;
        int r = nums.length-1;
        int rightNum = nums[r];
        if(target == rightNum) return r;
        else if(target > rightNum){
            while(l<=r){
                // 4 5 6 7 0 1 2 3
                int mid = l + (r-l)/2;
                if(nums[mid] == target) return mid;
                if(nums[mid]>rightNum){
                    if(nums[mid]>target){
                        r = mid - 1;
                    }else{
                        l = mid + 1;
                    }
                }else{
                    r = mid - 1;
                }
            }
        }else{
            while(l<=r){
                // 4 5 6 7 0 1 2 3
                int mid = l + (r-l)/2;
                if(nums[mid] == target) return mid;
                if(nums[mid]>rightNum){
                    l = mid + 1;
                }else{
                    if(nums[mid]>target){
                        r = mid - 1;
                    }else{
                        l = mid + 1;
                    }
                }
            }
        }


        return -1;
    }
}
