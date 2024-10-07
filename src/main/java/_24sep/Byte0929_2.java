package _24sep;

import java.util.Arrays;

public class Byte0929_2 {

//    static int max = Integer.MIN_VALUE;
    static int count = 0;
    public static void fnc(int[] nums,int index,int max){
        for(int i=index;i<nums.length;i++){
            if(nums[i]!=max){
                count++;
            }
            if(nums[i]>max){
                max = nums[i];
            }
            fnc(nums,i+1,max);
        }
    }
    public static void main(String[] args) {
        int n = 5;
        int[] nums = new int[]{1,2,5,4,5};
        int count = 0;
        for(int i=0;i<n;i++){
            int max = nums[i];
            count++;
            int j = i+1;
            while(j<n){
                if(nums[j] != max) count++;
                if(nums[j]>max) max = nums[j];
                j++;
            }

        }
        System.out.println(count);

    }
}
