package _24oct;

public class LC162 {
    public int find(int[] nums,int l,int r){
        int mid = l + ((r-l)>>1);
        // mid是峰值，返回mid
        if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
            return mid;
        }
        // 左边大于mid递归调用 l -- mid-1
        if(nums[mid-1]>nums[mid]){
            return find(nums,l,mid-1);
        } // 右边大于mid递归调用 mid+1 -- r
        else{
            return find(nums,mid+1,r);
        }

    }
    public int findPeakElement(int[] nums) {
        // 峰值 arr[i]>arr[i-1] arr[i]>arr[i+1]
        // 0左边无穷小 lengt-1右边无穷小

        // s1: length = 1 直接返回0
        if(nums.length == 1) return 0;
        // s2: 两边是峰值 返回两边
        int n = nums.length;
        if(nums[0]>nums[1]) return 0;
        if(nums[n-1]>nums[n-2]) return n-1;
        // s3 在1 - n-2之间进行二分查找
        // 左边上升，下降，中间必然有峰值
        return find(nums,1,n-2);

    }

    public static void main(String[] args) {
        LC162 lc162 = new LC162();
        lc162.findPeakElement(new int[]{1,2,3,1});

//        System.out.println(0>>1);
    }
}
