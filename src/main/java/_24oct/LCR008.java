package _24oct;

public class LCR008 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        int sum = 0;
        int res = 100001;
        while(r<n){
            sum+=nums[r];
            if(sum>=target){
                while(sum>=target){
                    res = Math.min(res,r-l+1);
                    sum -= nums[l];
                    l++;
                }
            }
            r++;
        }
        return res==100001?0:res;
    }

    public static void main(String[] args) {
        int[] ints = {2, 3, 1, 2, 4, 3};
        LCR008 lcr008 = new LCR008();
        lcr008.minSubArrayLen(7,ints);
    }
}
