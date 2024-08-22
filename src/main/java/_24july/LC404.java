package _24july;

/**
 * @description: 给定二叉树的根节点 root ，返回所有左叶子之和。
 */
public class LC404 {

    int sum = 0;
    public void fnc(TreeNode node, boolean flag){
        if(node == null) return;
        if(node.left == null && node.right == null && flag){
            sum+=node.val;
            return;
        }
        fnc(node.left,true);
        fnc(node.right,false);

    }

    public int sumOfLeftLeaves(TreeNode root) {
        fnc(root.left,true);
        fnc(root.right,false);
        return sum;
    }
}
