package carl.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortedSquares {
    public int[] sortedSquares(int[] nums) {

        List<Integer> res = new ArrayList<Integer>();

        int left = 0;
        int right = nums.length -1;
        while(left<right){
            if (Math.abs(nums[right])>Math.abs(nums[left])){
                res.add(nums[right]*nums[right]);
                right--;
            }else{
                res.add(nums[left]*nums[left]);
            }
        }
        res.add(nums[left]*nums[left]);
        Collections.reverse(res);
        return res.stream().mapToInt(k->k).toArray();
    }
}
