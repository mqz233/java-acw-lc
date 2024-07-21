package july;

/**
 * @description: 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 */
public class LC538 {

    int sum = 0;
    public void fnc(TreeNode root){
        if (root == null) return;
        convertBST(root.right);
        sum = sum + root.val;
        root.val = sum;
        convertBST(root.left);
    }
    public TreeNode convertBST(TreeNode root) {
      fnc(root);
      return root;
    }
}
