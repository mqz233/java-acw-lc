package july;
import java.util.*;

/**
 * @description:
 */
public class LC108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 1) return new TreeNode(nums[0]);
        if(nums.length == 2){
            TreeNode root = new TreeNode(nums[0]);
            root.right = new TreeNode(nums[1]);
            return root;
        }else{
            int mid = nums.length/2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,mid));
            root.right = sortedArrayToBST(Arrays.copyOfRange(nums,mid+1,nums.length));
            return root;
        }

    }
}
