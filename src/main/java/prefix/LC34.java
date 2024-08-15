package prefix;

public class LC34 {
    // 示例 1：
    //
    //输入：nums = [5,7,7,8,8,10], target = 8
    //输出：[3,4]
    //示例 2：
    //
    //输入：nums = [5,7,7,8,8,10], target = 6
    //输出：[-1,-1]
    //示例 3：
    //
    //输入：nums = [], target = 0
    //输出：[-1,-1]
    //

    // L=0 R=length-1
    public int fnc(int[] nums, int target,int l,int r){
        while(l<=r){
            int mid = l+ r-l/2;
            if(nums[mid]<target){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return l;
    }
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1,-1};
        int l = 0;
        int r = nums.length-1;
        int start = fnc(nums,target,l,r);
        int end = fnc(nums,target+1,l,r)-1;
        if(start>end) return new int[]{-1,-1};
        return new int[]{start,end};
    }
}
