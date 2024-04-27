package carl.tree;

public class LowestCommonAncestor {

    public TreeNode fnc(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null|| node == p || node == q) return node;
        TreeNode left = fnc(node.left, p, q);
        TreeNode right = fnc(node.right, p, q);
        if (left == null && right == null) return null;
        if (left != null && right == null) return left;
        if (right != null && left == null) return right;
        return node;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return fnc(root, p, q);
    }
}
