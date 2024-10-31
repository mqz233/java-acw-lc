package _24oct;

public class LC34 {
    public int fnc(int[] nums,int target){
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int mid = l + ((r-l)>>1);
            //1 2 3 3 3 4 5 target等于3的时候 r = mid -1
            if(nums[mid]<target){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return l;
    }
    public int[] searchRange(int[] nums, int target) {
        // 红蓝染色 l左边的都是小于target的
        // 从l开始是大于等于target的
        // 如果所有的数都小于target，那么最后l等于 nums.length
        // 如果所有的数都大于target，那么最后r = -1
        int l1 = fnc(nums,target);
        // l1位置不是target,或者l1的位置是nums.length（所有的数都比target小），那么直接返回
        if(l1 == nums.length||nums[l1] != target ){
            return new int[]{-1,-1};
        }
        int l2 = fnc(nums,target+1);
        return new int[]{l1,l2-1};
    }

    public static void main(String[] args) {
        LC34 lc34 = new LC34();
        lc34.searchRange(new int[]{5,7,7,8,8,10},4);
    }
}