package bishi.hw;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class _0424_1 {
    // 二叉搜索树，中序遍历
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int find  = scanner.nextInt();
        String[] split = s.split(" ");
        int[] nums = new int[split.length];
        for (int i=0;i<split.length;i++){
            nums[i] = Integer.parseInt(split[i]);
        }
        // 二叉搜索树中序遍历有序
        Arrays.sort(nums);
        // 有序数组可以使用二分搜索
        // 二分查找
        int l=0;
        int r = nums.length - 1;
        StringBuilder res = new StringBuilder();
        res.append('S');
        while (l<=r){
            int mid = l+(r-l)/2;
            if (nums[mid]==find){
                res.append('Y');
                break;
            } else if (find > nums[mid]) {
                res.append('R');
                l = mid + 1;
            } else {
                res.append('L');
                r = mid - 1;
            }
        }

        if (l>r){
            System.out.println(res.substring(0,res.length()-1)+"N");
        }else {
            System.out.println(res);

        }



    }
}
