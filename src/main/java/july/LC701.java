package july;

/**
 * @description:
 */
public class LC701 {
    void fnc(TreeNode node,int val){
        if(val>node.val){
            if(node.right == null){
                node.right = new TreeNode(val);
            }else{
                fnc(node.right,val);
            }
        }else{
            if(node.left == null){
                node.left = new TreeNode(val);
            }else{
                fnc(node.left,val);
            }
        }
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        fnc(root,val);
        return root;
    }
}
