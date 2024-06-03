package test;
import java.util.*;

public class LC27 {
    
    // [3,2,2,3]
    // [2,2,_,_]

    public int removeElement(int[] nums, int val) {

        int p1 = 0;
        int p2 = 0;
        int k=0;

        while(p2 < nums.length){
            while(p2 < nums.length && nums[p2] == val){
                p2++;
            }
            if(p2<nums.length){
                nums[p1] = nums[p2];
                k++;
                p1++;
                p2++;
            }
           
        }

        return k;

    }
    
}
