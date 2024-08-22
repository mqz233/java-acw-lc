package _24july;

/**
 * @description: 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * 差值是一个正数，其数值等于两值之差的绝对值
 */
public class LC530 {

    int[] nums = new int[10001];
    int count = -1;
    public void fnc(TreeNode node){
        if(node.left != null)fnc(node.left);
        nums[++count] = node.val;
        if(node.right != null) fnc(node.right);
    }
    public int getMinimumDifference(TreeNode root) {
        fnc(root);
        int res = Integer.MAX_VALUE;
        for(int i=0; i<count; i++){
            if(nums[i+1]-nums[i] < res){
                res = nums[i+1]-nums[i];
            }
        }
        return res;
    }
}
