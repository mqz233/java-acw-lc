package test;
import java.util.*;

public class LC15 {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        // -1,4,3,-4
        Arrays.sort(nums);
        for (int i=0;i<nums.length-2;i++){
            // 该元素和左侧元素相同，那么去重
            if (i-1>=0 && nums[i] == nums[i-1]){
                continue;
            }
            int j=i+1;
            int k = nums.length-1;
            while (j<k){
                if (nums[i]+nums[j]+nums[k] < 0){
                    j++;
                }else if(nums[i]+nums[j]+nums[k] > 0){
                    k--;
                }else {
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    // 找到一个解后，为j,k去重
                    while (j<k&&nums[k]==nums[k-1]) k--;
                    while (j<k&&nums[j]==nums[j+1]) j++;
                    // 不等之后，k-- j++
                    k--;
                    j++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC15 lc15 = new LC15();
        lc15.threeSum(new int[]{-1,0,1,2,-1,-4});
    }
}
