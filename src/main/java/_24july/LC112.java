package _24july;

/**
 * @description: 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 */
public class LC112 {

    boolean flag = false;
    public void fnc(TreeNode node, int sum){
        if(flag) return;
        sum = sum - node.val;
        if(node.left == null && node.right == null){
            if(sum==0) {
                flag = true;
            }
            return;
        }
        if(node.left!=null){
            fnc(node.left,sum);
        }
        if(node.right!=null){
            fnc(node.right,sum);
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if(root == null) return false;
        fnc(root,targetSum);
        return flag;
    }
}
