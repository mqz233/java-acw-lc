package _24july;
import java.util.*;

/**
 * @description: 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
 * 创建一个根节点，其值为 nums 中的最大值。
 * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
 * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
 * 返回 nums 构建的 最大二叉树 。
 */
public class LC654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        if(nums.length == 1) return new TreeNode(nums[0]);

        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for(int i=0; i<nums.length;i++){
            if(nums[i]>max){
                maxIndex = i;
                max = nums[i];
            }
        }
        TreeNode root = new TreeNode(max);
        if(maxIndex == 0){
            root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums,1,nums.length));
        }
        else if(maxIndex == nums.length-1){
            root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums,0,nums.length-1));
        }
        else{
            root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums,maxIndex+1,nums.length));
            root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums,0,maxIndex));
        }

        return root;

    }
}
