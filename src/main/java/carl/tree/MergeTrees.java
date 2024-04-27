package carl.tree;

public class MergeTrees {

    public TreeNode fnc(TreeNode n1, TreeNode n2){
        if (n1 == null&&n2 == null){
            return null;
        }

        int value = 0;
        if (n1 != null){
            value+=n1.val;
        }
        if (n2 != null){
            value+=n2.val;
        }
        TreeNode node = new TreeNode(value);

        node.left = fnc(n1==null?null:n1.left,n2==null?null:n2.left);
        node.right = fnc(n1==null?null:n1.right,n2==null?null:n2.right);

        return node;

    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        return fnc(root1,root2);
    }
}
