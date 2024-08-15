package aug;

public class LC236 {
    TreeNode res = null;
    public boolean fnc(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return false;
        if(root != p && root != q){
            boolean left = fnc(root.left,p,q);
            boolean right = fnc(root.right,p,q);
            if(left&&right){
                if(res == null){
                    res = root;
                }
                return false;
            }
            return left||right;
        }else {
            boolean left = fnc(root.left,p,q);
            boolean right = fnc(root.right,p,q);
            if(left||right && res == null){
                res = root;
                return false;
            }
            return true;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        fnc(root,p,q);
        return res;
    }
}
