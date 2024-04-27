package carl.tree;

public class GetMinimumDifference {

    public int fnc (TreeNode node, int value){
        if (node.left != null&& Math.abs(node.val-node.left.val)<value){
            value = Math.abs(node.val-node.left.val);
        }
        if (node.right != null&& Math.abs(node.val-node.right.val)<value){
            value = Math.abs(node.val-node.right.val);
        }
        int l = node.left == null?value:  fnc(node.left,value);
        int r = node.right == null?value:  fnc(node.right,value);
        return Math.min(l, r);
    }


    public int getMinimumDifference(TreeNode root) {

        return fnc(root,Integer.MAX_VALUE);


    }
}
